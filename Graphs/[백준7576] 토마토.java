import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N;
	static int[][] arr;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cnt;
	static Queue<Pos> q;

	// bfs 구현
	static void bfs() {
		while (!q.isEmpty()) {
			Pos cur = q.poll();

			// 4방탐색을 하며 토마토가 인집한 익지 않은 토마토에 대하여 일수를 저장하여 최소 일수를 구함
			for (int dir = 0; dir < 4; dir++) {
				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (arr[nr][nc] == 0) {
					arr[nr][nc] = arr[cur.r][cur.c] + 1;
					q.offer(new Pos(nr, nc));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				// 입력받을 때 익은 토마토가 있으면 큐에 저장
				if (arr[i][j] == 1)
					q.offer(new Pos(i, j));
			}
		}
		bfs();

		// bfs함수 호출 이후 하나라도 토마토가 익지 않았다면 -1 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				cnt = Math.max(cnt, arr[i][j]);
			}
		}
		System.out.println(cnt - 1);
	}

	// 좌표를 저장할 클래스
	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
