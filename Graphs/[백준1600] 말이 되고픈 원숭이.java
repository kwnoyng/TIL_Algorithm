import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int K, W, H;
	static int[][] arr;
	static boolean[][][] vis;
	// 말의 움직임
	static int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dy = { -1, 1, -2, 2, -2, 2, -1, 1 };
	// 원숭이의 움직임 (4방탐색)
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans = -1;

	static void bfs(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(r, c, 0, 0));
		vis[r][c][0] = true;

		while (!q.isEmpty()) {
			Pos cur = q.poll();

			// 목적지에 도착했다면 현재 동작 횟수가 최소한의 동작 횟수
			if (cur.r == H - 1 && cur.c == W - 1) {
				ans = cur.cnt;
				break;
			}

			// 4방탐색하며 상하좌우로 이동
			for (int dir = 0; dir < 4; dir++) {
				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];
				int cnt = cur.cnt;
				int k = cur.k;
				if (nr < 0 || nr >= H || nc < 0 || nc >= W)
					continue;
				// 방문하지 않았으며 이동이 가능한 곳이라면 이동, k는 그대로
				if (!vis[nr][nc][k] && arr[nr][nc] == 0) {
					vis[nr][nc][k] = true;
					q.offer(new Pos(nr, nc, cnt + 1, k));
				}
			}
			// 말의 움직임으로 이동이 가능하다면 이동
			if (cur.k < K) {
				for (int dir = 0; dir < 8; dir++) {
					int nr = cur.r + dx[dir];
					int nc = cur.c + dy[dir];
					int cnt = cur.cnt;
					int k = cur.k;
					if (nr < 0 || nr >= H || nc < 0 || nc >= W)
						continue;
					// 방문하지 않았으며 이동이 가능한 곳이라면 이동, k는 1 증가
					if (!vis[nr][nc][k + 1] && arr[nr][nc] == 0) {
						vis[nr][nc][k + 1] = true;
						q.offer(new Pos(nr, nc, cnt + 1, k + 1));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][W];
		vis = new boolean[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// (0, 0)에서 bfs함수 호출
		bfs(0, 0);
		System.out.println(ans);
	}

	static class Pos {
		int r;
		int c;
		int cnt;
		int k;

		Pos(int r, int c, int cnt, int k) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}
	}
}
