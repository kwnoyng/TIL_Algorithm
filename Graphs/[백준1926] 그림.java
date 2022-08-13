import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] arr;
	static boolean[][] visited;
	static int num; // 그림의 개수
	static int cnt; // 그림의 넓이
	static int max; // 가장 넓은 그림의 넓이
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void dfs(int x, int y) {
		visited[x][y] = true;
		cnt++;
		for (int cur = 0; cur < 4; cur++) {
			int nr = x + dr[cur];
			int nc = y + dc[cur];
			if (nr < 0 || nr >= n || nc < 0 || nc >= m)
				continue;
			if (!visited[nr][nc] && arr[nr][nc] == 1)
				dfs(nr, nc);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// arr를 순회하며 1이며 false이면 dfs호출
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				// 그림의 개수를 cnt++
				// 한 번의 dfs탐색이 끝나면 그림의 넓이를 max에 담는다.
				if (!visited[i][j] && arr[i][j] == 1) {
					dfs(i, j);
					num++;
					max = Math.max(max, cnt);
				}
				// 다른 그림의 넓이를 세기 위해 cnt를 초기화
				cnt = 0;
			}
		}
		System.out.println(num);
		System.out.println(max);
	}
}
