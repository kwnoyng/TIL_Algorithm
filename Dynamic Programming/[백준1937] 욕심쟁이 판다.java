import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int[][] dp;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans;

	static int dfs(int r, int c) {

		// dp에 값이 저장되어있다면 해당 값을 반환
		if (dp[r][c] != 0)
			return dp[r][c];

		// 판다는 최소 한 칸은 이동하므로 dp값을 1로 초기화
		dp[r][c] = 1;

		// 사방탐색으로 주변 칸을 검사
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			// 다음 칸이 경계값을 넘어갔다면 continue
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			// 현재 칸보다 다음 칸의 대나무 수가 더 많다면
			// 기존의 칸과 다음 칸 중 최댓값으로 갱신
			if (map[r][c] < map[nr][nc]) {
				dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
			}
		}

		return dp[r][c];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 모든 맵을 돌며 각 칸에서 이동할 수 있는 최댓값을 갱신
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans = Math.max(ans, dfs(i, j));
			}
		}

		System.out.println(ans);
	}
}
