import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static char[][] board;
	static int n, cnt;
	// 좌하 하 우하 우 탐색할 배열
	static int[] dr = { 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1 };

	static boolean chk(int x, int y) {
		// 4방탐색 시작
		for (int dir = 0; dir < 4; dir++) {
			cnt = 1;
			int nr = x + dr[dir];
			int nc = y + dc[dir];

			// 경계 밖이거나 o가 아니면 break
			// 아니면 cnt 증가 후 nr nc 갱신
			while (true) {
				if (nr < 0 || nr >= n || nc < 0 || nc >= n || board[nr][nc] != 'o')
					break;

				cnt++;
				nr += dr[dir];
				nc += dc[dir];
			}
			// 오목 이상이면 true
			if (cnt >= 5)
				return true;
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			board = new char[n][n];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					board[i][j] = str.charAt(j);
				}
			}

			String ans = "NO";
			loop: for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {

					// o면 chk함수 호출, true반환되면 오목이므로 YES
					if (board[i][j] == 'o') {
						if (chk(i, j)) {
							ans = "YES";
							break loop;
						}
					}
				}
			}

			System.out.printf("#%d %s\n", t, ans);
		}
	}
}
