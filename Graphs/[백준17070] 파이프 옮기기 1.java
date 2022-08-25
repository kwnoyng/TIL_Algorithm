import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int n;
	static int cnt;

	static void dfs(int x, int y, int k) {

		// 범위가 넘어가면 return
		if (x >= n || y >= n || arr[x][y] == 1)
			return;

		// k = 0 : 가로
		if (k == 0) {
			dfs(x, y + 1, 0); // 가로로 이동
			dfs(x + 1, y + 1, 2); // 대각선으로 이동
		}
		// k = 1 : 세로
		else if (k == 1) {
			dfs(x + 1, y, 1); // 세로로 이동
			dfs(x + 1, y + 1, 2); // 대각선으로 이동
		}
		// k = 2 : 대각선
		else if (k == 2) {
			// 대각선일 경우 현재 위치의 위쪽 혹은 왼쪽이 1일 경우 불가능하므로 return
			if (arr[x - 1][y] == 1 || arr[x][y - 1] == 1)
				return;
			dfs(x, y + 1, 0); // 가로로 이동
			dfs(x + 1, y, 1); // 세로로 이동
			dfs(x + 1, y + 1, 2); // 대각선으로 이동
		}

		// 파이프가 (n,n)으로 이동했을 경우 cnt++ 후 return
		if (x == n - 1 && y == n - 1) {
			cnt++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 1, 0);
		System.out.println(cnt);
	}
}

/*  초기 풀이..... 위에 풀이처럼 더 깔끔하게 풀 수 있잖아 오영아... 
  
public class Main {

	static int[][] arr;
	static boolean[][] vis;
	static int n;
	static int cnt;

	// 가로 세로 대각선
	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 0, 1 };

	static void dfs(int x, int y, int k) {
		if (x == n - 1 && y == n - 1) {
			cnt++;
			return;
		}

		// 현재 가로
		if (k == 0) {
			for (int i = 0; i < 3; i++) {
				if (i == 1)
					continue;
				int nr = x + dr[i];
				int nc = y + dc[i];

				if (i == 0) {
					if (nr >= n || nc >= n || arr[nr][nc] == 1)
						continue;
					dfs(nr, nc, 0);
				}

				if (i == 2) {
					if (nr >= n || nc >= n || arr[nr][nc] == 1 || arr[nr - 1][nc] == 1 || arr[nr][nc - 1] == 1)
						continue;
					dfs(nr, nc, 2);
				}
			}
		}

		// 현재 세로
		else if (k == 1) {
			for (int i = 0; i < 3; i++) {
				if (i == 0)
					continue;
				int nr = x + dr[i];
				int nc = y + dc[i];

				if (i == 1) {
					if (nr >= n || nc >= n || arr[nr][nc] == 1)
						continue;
					dfs(nr, nc, 1);
				}

				if (i == 2) {
					if (nr >= n || nc >= n || arr[nr][nc] == 1 || arr[nr - 1][nc] == 1 || arr[nr][nc - 1] == 1)
						continue;
					dfs(nr, nc, 2);
				}
			}
		}

		// 현재 대각선
		else if (k == 2) {
			for (int i = 0; i < 3; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];
				if (i == 0) {
					if (nr >= n || nc >= n || arr[nr][nc] == 1)
						continue;
					dfs(nr, nc, 0);
				}
				if (i == 1) {
					if (nr >= n || nc >= n || arr[nr][nc] == 1)
						continue;
					dfs(nr, nc, 1);
				}
				if (i == 2) {
					if (nr >= n || nc >= n || arr[nr][nc] == 1 || arr[nr - 1][nc] == 1 || arr[nr][nc - 1] == 1)
						continue;
					dfs(nr, nc, 2);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		vis = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					vis[i][j] = true;
			}
		}

		dfs(0, 1, 0);
		System.out.println(cnt);
	}
}
*/
