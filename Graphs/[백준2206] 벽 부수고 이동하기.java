import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr;
	static boolean[][][] vis;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cnt;
	static int ans;

	// bfs 구현
	static void bfs(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(r, c, 1, 0));
		vis[r][c][0] = true; // 시작점은 벽을 부수지 않으면서 r,c를 방문

		while (!q.isEmpty()) {
			Pos cur = q.poll();
			// (N, M)으로 이동했다면 현재의 거리가 최단 경로
			if (cur.r == N - 1 && cur.c == M - 1) {
				ans = cur.cnt;
				break;
			}
			for (int dir = 0; dir < 4; dir++) {
				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];
				int cnt = cur.cnt;
				int wall = cur.wall;
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				// 다음으로 갈 칸이 벽이 아닐 때
				// 기존에 벽을 부쉈든 안 부쉈든 벽이 아니면 갈 수 있으므로 wall는 변함이 없음
				if (arr[nr][nc] == 0 && !vis[nr][nc][wall]) {
					vis[nr][nc][wall] = true;
					q.offer(new Pos(nr, nc, cnt + 1, wall));
				}
				// 다음으로 갈 칸이 벽이면서 아직까지 벽을 부수지 않았을 때
				// 기존에 벽을 부쉈다면 다음 칸은 벽으로 갈 수 없음
				else if (arr[nr][nc] == 1 && wall == 0) {
					vis[nr][nc][wall] = true;
					q.offer(new Pos(nr, nc, cnt + 1, wall + 1));

				}

			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		vis = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		// (0, 0)부터 시작
		bfs(0, 0);
		if (ans == 0)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	static class Pos {
		int r;
		int c;
		int cnt;
		int wall; // 벽을 부쉈는지

		Pos(int r, int c, int cnt, int wall) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.wall = wall;
		}
	}
}