import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2644촌수 {
	static int n, m, a, b;
	static int[][] vil; // 촌수 연결요소
	static boolean[] visited; // 방문 여부 확인
	static int ans = -1; // 촌수의 초기값 = -1

	static void dfs(int k, int cnt) {
		// b에 도달하면 cnt가 ans
		if (k == b) {
			ans = cnt;
			return;
		}
		visited[k] = true;

		// 오름차순으로 dfs를 실시하며 cnt를 늘려줌
		for (int i = 1; i <= n; i++) {
			if (!visited[i] && vil[k][i] == 1) {
				dfs(i, cnt + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		vil = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		// x와 y가 연결되어있다면 1을 대입함으로서 연결을 표시
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			vil[x][y] = 1;
			vil[y][x] = 1;
		}

		// 시작점과 cnt를 매개변수에 넣는다
		dfs(a, 0);
		System.out.println(ans);
	}
}
