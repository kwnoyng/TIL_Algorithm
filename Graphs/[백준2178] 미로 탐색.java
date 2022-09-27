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
	static boolean[][] vis;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans;

	// bfs 구현
	static void bfs(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(r, c, 1));
		vis[r][c] = true;

		while (!q.isEmpty()) {
			Pos cur = q.poll();
			if (cur.r == N - 1 && cur.c == M - 1) {
				ans = cur.cnt;
				break;
			}
			for (int dir = 0; dir < 4; dir++) {
				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];
				int cnt = cur.cnt;
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (!vis[nr][nc] && arr[nr][nc] == 1) {
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
		arr = new int[N][M];
		vis = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(0, 0);
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
