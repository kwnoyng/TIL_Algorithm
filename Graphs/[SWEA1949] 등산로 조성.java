import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, K;
	static int[][] arr;
	static boolean[][] vis;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans;

	// dfs(행, 열, 등산로 길이, 깍았는지 여부)
	static void dfs(int r, int c, int cnt, boolean isCutted) {

		// 정답을 등산로 길이의 최댓값으로 갱신
		ans = Math.max(ans, cnt);

		// 4방탐색
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			// 경계값을 넘어가거나 이미 방문했다면 continue
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			if (vis[nr][nc])
				continue;
			// 산을 깎았던 깎지 않았던 다음으로 갈 곳이 현재 내 높이보다 낮으면
			// 그대로 dfs함수 재귀호출
			if (arr[r][c] > arr[nr][nc]) {
				vis[nr][nc] = true;
				dfs(nr, nc, cnt + 1, isCutted);
				vis[nr][nc] = false;
			}
			// 다음으로 갈 경로가 현재 내 높이와 같거나 더 높다면
			// 동시에 이미 깎은 적이 없으면서 다음 경로를 최대 K만큼 깎았을 때 내 위치보다 낮아진다면
			else if (!isCutted && arr[nr][nc] - K < arr[r][c]) {
				// 다음 경로의 높이를 잠시 저장
				// 다음 경로의 높이를 내 위치보다 1만 낮게 만들어주고 dfs함수 재귀호출, return시 원레 높이로
				int height = arr[nr][nc];
				vis[nr][nc] = true;
				arr[nr][nc] = arr[r][c] - 1;
				dfs(nr, nc, cnt + 1, !isCutted);
				vis[nr][nc] = false;
				arr[nr][nc] = height;

			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			vis = new boolean[N][N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, arr[i][j]);
				}
			}

			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 정상이라면 등산로를 조성한다
					// 현재 위치를 true로 바꿔주고 dfs함수 호출 후 리턴되면 다시 false로
					if (arr[i][j] == max) {
						vis[i][j] = true;
						dfs(i, j, 1, false);
						vis[i][j] = false;
					}
				}
			}
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}