import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());

			int[][] arr = new int[n][n];

			// 처음에 1을 저장
			arr[0][0] = 1;
			for (int i = 1; i < n; i++) {
				// 첫 번째 숫자는 1
				arr[i][0] = 1;

				// 문자열의 좌우를 표시해줄 변수
				int left = 0;
				int right = 1;
				// 처음과 끝을 제외하고 값을 추가
				// 이전과 그 다음 숫자를 더하고 left와 right를 ++
				for (int j = 1; j <= i - 1; j++) {
					arr[i][j] = arr[i - 1][left++] + arr[i - 1][right++];
				}
				// 마지막 숫자는 1
				arr[i][i] = 1;
			}

			// 출력부
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append("\n");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] != 0) {
						sb.append(arr[i][j]).append(" ");
					}
				}
				sb.append("\n");
			}
			sb.delete(sb.length() - 1, sb.length());

			System.out.println(sb);
		}
	}
}
