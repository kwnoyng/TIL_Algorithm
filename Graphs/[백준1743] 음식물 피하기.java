import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static int[][] map;
	static boolean[][] vis;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cnt;
	static int ans;

	// dfs함수 구현
	static void dfs(int r, int c) {
		// 방문처리 및 cnt크기 하나 늘려주기
		vis[r][c] = true;
		cnt++;

		// 사방탐색
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			// 경계값을 벗어났으면 continue
			if (nr <= 0 || nr > N || nc <= 0 || nc > M)
				continue;
			// 음식물을 발견했으면서 방문하지 않았으면 dfs함수 재귀호출
			if (map[nr][nc] == 1 && !vis[nr][nc])
				dfs(nr, nc);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		vis = new boolean[N + 1][M + 1];

		// K번 반복하며 음식물이 들어있는 공간은 1로 초기화
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}

		// 2차원배열을 순회
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				// 음식물을 발견했으면서 이미 체크하지 않은 음식물이라면
				// cnt초기화 후 dfs함수 호출 및 ans값 갱신
				if (map[i][j] == 1 && !vis[i][j]) {
					cnt = 0;
					dfs(i, j);
					ans = Math.max(ans, cnt);
				}
			}
		}

		System.out.println(ans);
	}
}
