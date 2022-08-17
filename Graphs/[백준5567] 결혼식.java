import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] arr;
	static boolean[] visited;

	// 상근이의 친구 => cnt = 1, 상근이의 친구의 친구 => cnt = 2
	// cnt가 2가 될 때까지만 true 후 더이상 dfs 탐색 멈춤
	static void dfs(int x, int cnt) {
		visited[x] = true;
		if (cnt == 2)
			return;

		// n명의 사람 순서대로 탐색
		// visited가 true여도 탐색해야함 (cnt = 2만 맞추면 된다)
		for (int i = 1; i <= n; i++) {
			if (arr[x][i] == 1) {
				dfs(i, cnt + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		arr = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		// 친구관계를 인접행렬로 연결
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		// 상근이에서 dfs 호출
		dfs(1, 0);

		// 총 visited배열에서 true로 된 사람들 = 상근이 친구, 친구의 친구 (cnt = 2까지)
		// true로 된 사람들을 모두 더하고 상근이 본인은 빼준 후 출력
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			if (visited[i] == true)
				sum++;
		}

		System.out.println(sum - 1);
	}
}
