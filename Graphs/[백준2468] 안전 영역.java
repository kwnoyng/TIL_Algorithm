import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] arr;
	static boolean[][] visited;
	static int cnt = 0; // 안전 영역의 수
	static int maxCnt = 0; // 최대 안전 영역의 수
	static int k; // 비의 양
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 해당 지점을 true로 바꿔주고 4방탐색
	static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int cur = 0; cur < 4; cur++) {
			int nr = x + dr[cur];
			int nc = y + dc[cur];

			// 경계값 설정
			if (nr < 0 || nr >= n || nc < 0 || nc >= n)
				continue;

			// arr값이 k 이상이며 방문하지 않은(false) 곳을 탐색
			if (arr[nr][nc] > k && !visited[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n][n];

		StringTokenizer st;
		int min = 100;
		int max = 1;
		// 배열의 min과 max를 구함.
		// max만큼 비가 오면 모든 지점이 잠김, min-1만큼 비가 오면 모든 지점이 잠기지 않기 때문에요
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(arr[i][j], min);
				max = Math.max(arr[i][j], max);
			}
		}

		// min-1만큼 비가 오면 모든 지점이 물에 잠기지 않는다
		// max만큼 비가 오면 모든 지점이 물에 잠긴다
		// 그러므로 비의 양이 min-1 ~ max 사이일 때의 최대 안전 영역의 수를 구하면 됨
		for (k = min - 1; k <= max; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// arr값이 k보다 클 경우 물에 잠기지 않으므로(안전 영역이므로) dfs 함수 호출
					if (arr[i][j] > k && !visited[i][j]) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			// maxCnt를 지속해서 최신화
			maxCnt = Math.max(cnt, maxCnt);
			cnt = 0;
			// 한 번 돌고나서 visited배열을 모두 false로 바꿔줌 (다시 돌아야 하니까~)
			visited = new boolean[n][n];
		}
		System.out.println(maxCnt);

	}
}
