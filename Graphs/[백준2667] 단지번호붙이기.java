import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int n; // 지도의 크기
	static int[][] arr; // 지도
	static boolean[][] visited; // 방문 확인
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] cnt; // 각 단지 아파트의 수
	static int total = 0; // 총 단지의 수

	// dfs 구현
	// 해당 인덱스의 visited 배열의 방문여부 true로 하며 4방탐색
	// dfs가 재귀로 호출될 때마다단지의 아파트 수를 ++
	static void dfs(int x, int y) {
		visited[x][y] = true;
		cnt[total]++;

		// 델타를 이용한 4방탐색
		for (int cur = 0; cur < 4; cur++) {
			int nr = x + dr[cur];
			int nc = y + dc[cur];

			// 배열의 경계값을 넘어가면 continue
			// 방문하지 않았으며(false) 집이 있는 곳(1)이면 dfs 함수 호출 (재귀)
			if (nr < 0 || nr >= n || nc < 0 || nc >= n)
				continue;
			if (!visited[nr][nc] && arr[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n][n];
		cnt = new int[n * n];

		// 입력부
		// String으로 받아서 하나씩 쪼개서 이차원 배열에 넣기
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		// arr의 크기만큼 dfs를 돌릴 것.
		// 방문하지 않았으며(false) 집이 있는 곳(1)이면 dfs 함수 호출
		// 호출하며 total 단지 수를 ++
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {
					total++;
					dfs(i, j);
				}
			}
		}

		// 오름차순으로 출력하기 위해 정렬
		Arrays.sort(cnt);

		System.out.println(total);
		for (int x : cnt) {
			if (x != 0)
				System.out.println(x);
		}
	}
}
