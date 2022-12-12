import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	static int R, C;
	static char[][] grid;
	static boolean[][] vis;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cnt;

	// dfs 함수 구현
	static void dfs(int r, int c) {
		// 현재 위치를 방문처리
		vis[r][c] = true;

		// 사방탐색을 하며
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			// 경계값 벗어났으면 continue
			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;
			// 방문하지 않았으며 양이 존재한다면 재귀호출
			if (!vis[nr][nc] && grid[nr][nc] == '#')
				dfs(nr, nc);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		// Testcase만큼 반복
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			grid = new char[R][C];
			vis = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					grid[i][j] = str.charAt(j);
				}
			}

			// 양의 무리 개수 초기화
			cnt = 0;
			// grid를 돌며 양의 무리 개수 세어주기.
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (!vis[i][j] && grid[i][j] == '#') {
						dfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
	}
}
