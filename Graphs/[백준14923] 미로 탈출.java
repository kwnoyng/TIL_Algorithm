import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int Hx, Hy; // 시작좌표
	static int Ex, Ey; // 도착좌표
	static int[][] arr;
	static boolean[][][] vis;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans;

	static void bfs(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(r, c, 0, 0));
		vis[r][c][0] = true;

		while (!q.isEmpty()) {
			Pos cur = q.poll();

			// 현재값이 도착좌표라면 ans는 최댓값으로 최신화 후 return
			if (cur.r == Ex && cur.c == Ey) {
				ans = cur.cnt;
				return;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];
				int cnt = cur.cnt;
				int isUsed = cur.isUsed;

				// 범위 넘어가면 continue
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				// 다음으로 갈 곳이 벽이 아니면서 방문하지 않았다면
				// 마법의 지팡이 사용여부와 상관없이 갈 수 있다
				if (arr[nr][nc] == 0 && !vis[nr][nc][isUsed]) {
					q.offer(new Pos(nr, nc, cnt + 1, isUsed));
					vis[nr][nc][isUsed] = true;
				}
				// 다음으로 갈 곳이 벽이라면서 지팡이를 사용하지 않았다면
				// 마법의 지팡이를 사용하고 갈 수 있다
				else if (arr[nr][nc] == 1 && isUsed == 0) {
					q.offer(new Pos(nr, nc, cnt + 1, isUsed + 1));
					vis[nr][nc][isUsed] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Hx = Integer.parseInt(st.nextToken()) - 1;
		Hy = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(br.readLine());
		Ex = Integer.parseInt(st.nextToken()) - 1;
		Ey = Integer.parseInt(st.nextToken()) - 1;

		arr = new int[N][M];
		vis = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = -1;
		bfs(Hx, Hy);

		System.out.println(ans);
	}

	// 좌표 클래스
	static class Pos {
		int r;
		int c;
		int cnt;
		int isUsed;

		Pos(int r, int c, int cnt, int isUsed) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.isUsed = isUsed;
		}
	}
}