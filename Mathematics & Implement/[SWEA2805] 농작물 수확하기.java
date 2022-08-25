import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int n;
	static int[][] arr;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}

			cnt = 0;
			// 위 삼각형 탐색
			for (int i = 0; i < n / 2; i++) {
				cnt += arr[i][n / 2];
				for (int j = 0; j < i; j++) {
					cnt += arr[i][n / 2 + j + 1];
				}
				for (int j = 0; j > -i; j--) {
					cnt += arr[i][n / 2 + j - 1];
				}
			}

			// 중앙 포함 아래 삼각형 탐색
			for (int i = n - 1; i >= n / 2; i--) {
				cnt += arr[i][n / 2];
				for (int j = 0; j < n - i - 1; j++) {
					cnt += arr[i][n / 2 + j + 1];
				}
				for (int j = 0; j > -(n - i - 1); j--) {
					cnt += arr[i][n / 2 + j - 1];
				}
			}

			System.out.printf("#%d %d\n", t, cnt);
		}
	}
}
