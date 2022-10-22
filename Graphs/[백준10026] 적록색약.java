import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	static int N;
	static char[][] arr1, arr2;
	static boolean[][] vis1, vis2;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cnt1, cnt2;

	// 적록색약이 아닌 사람 dfs
	static void dfs1(int r, int c, char k) {
		vis1[r][c] = true;

		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			if (!vis1[nr][nc] && arr1[nr][nc] == k) {
				dfs1(nr, nc, k);
			}
		}
	}

	// 적록색약인 사람 dfs
	static void dfs2(int r, int c, char k) {
		vis2[r][c] = true;

		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			if (!vis2[nr][nc] && arr2[nr][nc] == k) {
				dfs2(nr, nc, k);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr1 = new char[N][N];
		arr2 = new char[N][N];
		// arr1 : 적록색약이 아닌 사람이 보는 그림
		// arr2 : 적록색약인 사람이 보는 그림
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr1[i][j] = str.charAt(j);
				// 적록색약은 R과 G를 같은 색으로 보기 때문에 arr2에 R과 G를 모두 R로 저장
				if (arr1[i][j] == 'R' || arr1[i][j] == 'G')
					arr2[i][j] = 'R';
				else
					arr2[i][j] = 'B';
			}
		}

		vis1 = new boolean[N][N];
		vis2 = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 적록색약이 아닌 경우의 cnt 구하기
				if (!vis1[i][j]) {
					cnt1++;
					dfs1(i, j, arr1[i][j]);
				}
				// 적록색약인 경우의 cnt 구하기
				if (!vis2[i][j]) {
					cnt2++;
					dfs2(i, j, arr2[i][j]);
				}
			}
		}

		System.out.println(cnt1 + " " + cnt2);
	}
}