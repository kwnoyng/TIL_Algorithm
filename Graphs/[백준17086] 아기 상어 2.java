import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static Queue<Pos> q;
	static int ans;

	// bfs 구현
	static void bfs() {
		while (!q.isEmpty()) {
			Pos cur = q.poll();

			ans = Math.max(ans, cur.cnt);

			for (int dir = 0; dir < 8; dir++) {
				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];
				int cnt = cur.cnt;

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				// 사방탐색하여 빈 칸이라면 거리를 1 증가시켜 큐에 저장
				// 빈 칸의 값을 현재의 값 + 1로 갱신
				if (arr[nr][nc] == 0) {
					q.offer(new Pos(nr, nc, cnt + 1));
					arr[nr][nc] = arr[cur.r][cur.c] + 1;
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
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				// 상어의 좌표를 큐에 넣어준다
				if (arr[i][j] == 1)
					q.offer(new Pos(i, j, 0));
			}
		}

		bfs();

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
