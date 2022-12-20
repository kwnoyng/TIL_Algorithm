import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int S, X, Y;
	static int[][] map;
	static boolean[][] vis;
	static PriorityQueue<Pos> pq;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 퍼트릴 바이러스를 찾는 findVirus 함수
	static void findVirus() {
		pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 퍼트린 칸이 아니며 해당 칸에 바이러스가 존재한다면 pq에 삽입 후 방문처리
				if (!vis[i][j] && map[i][j] > 0) {
					pq.offer(new Pos(i, j, map[i][j]));
					vis[i][j] = true;
				}
			}
		}
	}

	// 사방으로 퍼트리는 bfs함수
	static void bfs() {
		// pq가 빌 때까지 반복
		while (!pq.isEmpty()) {
			Pos cur = pq.poll();
			// 현재 바이러스에서 사방탐색
			for (int dir = 0; dir < 4; dir++) {
				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];
				int virus = cur.virus;
				// 경계값이 벗어났다면 continue
				if (nr <= 0 || nr > N || nc <= 0 || nc > N)
					continue;
				// 다음 칸에 바이러스가 존재하지 않는다면 바이러스를 퍼트린다.
				if (map[nr][nc] == 0)
					map[nr][nc] = virus;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		vis = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		// S초 동안 반복
		while (S-- > 0) {

			// 바이러스를 찾고 퍼트린다.
			findVirus();
			bfs();

			// map[X][Y]에 이미 바이러스가 존재한다면 break
			if (map[X][Y] != 0)
				break;
		}

		System.out.println(map[X][Y]);
	}

	static class Pos implements Comparable<Pos> {
		int r;
		int c;
		int virus;

		Pos(int r, int c, int virus) {
			this.r = r;
			this.c = c;
			this.virus = virus;
		}

		// num 내림차순으로 정렬하기 위함
		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.virus, o.virus);
		}
	}
}
