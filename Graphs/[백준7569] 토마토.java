import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N, H;
	static int[][][] arr;
	static int[] dr = { -1, 1, 0, 0, 0, 0 };
	static int[] dc = { 0, 0, -1, 1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static Queue<Pos> q;
	static int cnt;

	static void bfs() {
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			for (int dir = 0; dir < 6; dir++) {
				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];
				int nh = cur.h + dh[dir];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || nh < 0 || nh >= H)
					continue;
				if (arr[nr][nc][nh] == 0) {
					arr[nr][nc][nh] = arr[cur.r][cur.c][cur.h] + 1;
					q.offer(new Pos(nr, nc, nh));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[N][M][H];
		q = new LinkedList<>();
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if (arr[i][j][k] == 1)
						q.offer(new Pos(i, j, k));
				}
			}
		}
		bfs();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < H; k++) {
					if (arr[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
					cnt = Math.max(cnt, arr[i][j][k]);
				}
			}
		}
		System.out.println(cnt - 1);
	}

	static class Pos {
		int r;
		int c;
		int h;

		public Pos(int r, int c, int h) {
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}
}
// 2차원 토마토에서 3차원 토마토로 바뀌었을 뿐...!
