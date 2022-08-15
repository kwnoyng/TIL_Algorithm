import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] board = new int[100][100];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					board[j][k] = 1;
				}
			}

		}

		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				// 배열의 해당 원소가 1이면 사방탐색을 통해 0인 것들을 모두 cnt
				if (board[i][j] == 1) {
					for (int cur = 0; cur < 4; cur++) {
						int nr = i + dr[cur];
						int nc = j + dc[cur];

						// 경계에 도달했을 때도 길이를 측정해야함
						if (nr < 0 || nr >= 100 || nc < 0 || nc >= 100 || board[nr][nc] == 0) {
							cnt++;
						}
					}
				}
			}
		}

		System.out.println(cnt);

	}
}
