import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] arr;
	static boolean[][] vis;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans;

	static void bfs(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(r, c, 0));
		vis[r][c] = true;

		while (!q.isEmpty()) {
			Pos cur = q.poll();

			// dist를 계속 거리의 최댓값으로 갱신
			if (cur.cnt > ans)
				ans = cur.cnt;

			// 4방탐색으로 하며 방문하지 않은 육지라면 큐에 넣는다
			for (int dir = 0; dir < 4; dir++) {
				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];
				int cnt = cur.cnt;

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (!vis[nr][nc] && arr[nr][nc] == 'L') {
					q.offer(new Pos(nr, nc, cnt + 1));
					vis[nr][nc] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		// 2중포문을 돌면서 육지라면
		// 해당 지점에서 bfs를 돌리고 최대 거리를 찾는다(dist)
		// ans를 dist의 최댓값으로 갱신
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 'L') {
					vis = new boolean[N][M];
					bfs(i, j);
				}
			}
		}

		System.out.println(ans);

	}

	static class Pos {
		int r;
		int c;
		int cnt;

		Pos(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}