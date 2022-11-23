import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] vis;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int R, C;
	static int time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		Queue<Pos> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// (i, j)에 아기상어가 존재한다면 q에 넣어주고 해당 맵을 0으로 빈 공간으로 바꿔준다.
				if (map[i][j] == 9) {
					R = i;
					C = j;
					q.offer(new Pos(R, C, 0));
					map[R][C] = 0;
				}
			}
		}

		// 초기 사이즈 = 2, 먹은 갯수 = 0
		int size = 2;
		int eat = 0;

		while (true) {
			// 먹을 수 있는 물고기를 넣어주는 우선순위큐
			// vis 배열 선언 후 현재 상어의 위치를 방문처리
			PriorityQueue<Pos> fish = new PriorityQueue<>();
			vis = new boolean[N][N];
			vis[R][C] = true;

			// 큐가 빌 때까지 맵 전체를 돌면서 먹을 수 있는 물고기 찾기
			while (!q.isEmpty()) {
				// 아기상어를 큐에서 한 마리 폭 꺼낸다
				Pos cur = q.poll();

				// 사방탐색하여 체크
				for (int dir = 0; dir < 4; dir++) {
					int nr = cur.r + dr[dir];
					int nc = cur.c + dc[dir];
					int dist = cur.dist;

					// 경계값을 벗어나거나 이미 방문했거나 현재 내 사이즈보다 커서 이동할 수 없는 경우continue
					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;
					if (vis[nr][nc])
						continue;
					if (map[nr][nc] > size)
						continue;

					// 이외의 상황에서는 이동이 가능하므로 거리를 +1하여 상어를 큐에 넣어주고 방문처리
					q.offer(new Pos(nr, nc, dist + 1));
					vis[nr][nc] = true;

					// 만약 먹을 수 있는 먹이가 존재한다면
					// fish 우선순위 큐에 넣어준다
					if (map[nr][nc] != 0 && map[nr][nc] < size)
						fish.offer(new Pos(nr, nc, dist + 1));
				}
			}

			// 만약 먹을 수 있는 물고기가 없다면 break
			if (fish.isEmpty())
				break;

			// 현재 먹을 물고기이자 상어의 위치
			Pos target = fish.poll();
			R = target.r;
			C = target.c;
			int dist = target.dist;

			// ans에 물고기의 거리를 더해주고
			// 물고기가 있던 자리를 0으로 바꿔주고 eat++
			time += dist;
			map[R][C] = 0;
			eat++;

			// size의 갯수만큼 먹었다면 size++, eat = 0
			if (eat == size) {
				size++;
				eat = 0;
			}

			// 상어의 위치는 방금 먹은 물고기의 위치이므로 q에 넣어준다
			q.offer(new Pos(R, C, 0));
		}

		System.out.println(time);

	}

	// 좌표와 거리를 표시해줄 클래스
	static class Pos implements Comparable<Pos> {
		int r;
		int c;
		int dist;

		public Pos(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		// 거리순 오름차순
		// 거리가 같다면
		@Override
		public int compareTo(Pos o) {
			if (this.dist == o.dist) {
				if (this.r == o.r) {
					return Integer.compare(this.c, o.c);
				}
				return Integer.compare(this.r, o.r);
			}
			return Integer.compare(this.dist, o.dist);
		}
	}
}
