import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] chess;
	static boolean[][] visited;
	// 현재 나이트 위치 (a, b), 이동하려는 위치(c, d)
	static int n, a, b, c, d;
	// 나이트가 이동할 수 있는 행과 열
	static int[] dr = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dc = { -1, 1, -2, 2, -2, 2, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine());
			chess = new int[n][n];
			visited = new boolean[n][n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			Point start = new Point(a, b, 0);

			bfs(start);
		}
	}

	// bfs 구현
	static void bfs(Point p) {
		// Queue 선언 및 배개변수 p 큐에 저장 후 방문처리
		Queue<Point> q = new LinkedList<>();
		q.offer(p);
		visited[p.x][p.y] = true;

		// 큐가 빌 때까지 반복
		// 큐의 front값을 꺼내고 해당 값을 기준으로 8방탐색
		// 만약 꺼낸 큐의 좌표가 목표로 할 좌표라면, point.cnt 출력 후 return;
		while (!q.isEmpty()) {
			Point point = q.poll();
			if (point.x == c && point.y == d) {
				System.out.println(point.cnt);
				return;
			}

			// 8방탐색 실시
			// 경계값이 넘어가면 continue
			// 방문하지 않았으면 큐에 넣고 방문처리
			for (int dir = 0; dir < 8; dir++) {
				int nr = point.x + dr[dir];
				int nc = point.y + dc[dir];
				int cnt = point.cnt;
				if (nr < 0 || nr >= n || nc < 0 || nc >= n)
					continue;
				if (!visited[nr][nc]) {
					q.offer(new Point(nr, nc, cnt + 1));
					visited[nr][nc] = true;
				}
			}
		}
	}

	// 좌표와 cnt를 사용할 Point Class
	static class Point {
		int x, y, cnt;

		Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
