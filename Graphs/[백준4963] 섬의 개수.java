import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int w; // 너비, 열
	static int h; // 높이, 행
	static boolean[][] visited;
	static int[][] arr;
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	// dfs 구현
	// 해당 인덱스의 visited 배열의 방문 여부를 true로 하며 8방탐색
	static void dfs(int x, int y) {
		visited[x][y] = true;

		// 델타를 이용한 8방탐색
		for (int cur = 0; cur < 8; cur++) {
			int nr = x + dr[cur];
			int nc = y + dc[cur];

			// 배열의 경계값을 넘어가면 continue
			// 방문하지 않았으며(false) 섬이 있는 곳(1)이면 dfs 함수 호출
			if (nr < 0 || nr >= h || nc < 0 || nc >= w)
				continue;
			if (!visited[nr][nc] && arr[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			// 너비와 높이의 입력이 0이면 종료
			if (w == 0 && h == 0)
				return;

			visited = new boolean[h][w];
			arr = new int[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// while문을 1번 돌 때마다 cnt를 0으로 초기화
			// 2차원 배열을 순회하며 dfs를 돌릴 것
			// 방문하지 않았으며(false) 섬이 있는 곳(1)이면 dfs 함수 호출
			// 호출하며 섬의 개수를 ++
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && arr[i][j] == 1) {
						dfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);

		}
	}
}
