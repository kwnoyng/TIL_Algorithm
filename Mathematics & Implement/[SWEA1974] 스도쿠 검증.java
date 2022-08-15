import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int[][] arr = new int[9][9];
			int[] num1; // 행을 확인할 배열
			int[] num2; // 열을 확인할 배열
			int[] num3; // 격자를 확인할 배열
			boolean chk = true;
			StringTokenizer st;
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 행과 열을 동시에 확인
			for (int i = 0; i < 9; i++) {
				num1 = new int[9];
				num2 = new int[9];
				// 행과 열에 해당값의 인덱스를 ++시킴
				// 예를 들면 arr[][]의 값이 5이면 num[5]를 추가함
				for (int j = 0; j < 9; j++) {
					num1[arr[i][j] - 1]++;
					num2[arr[j][i] - 1]++;
				}
				// 만약 1~9가 모두 들어있다고 하면 num 배열의 값은 모두 1이겠죠
				// 1이 아니면(숫자가 두 개 들어있거나 안 들어있거나)하면 false
				for (int k = 0; k < 9; k++) {
					if (num1[k] != 1 || num2[k] != 1) {
						chk = false;
						break;
					}
				}
			}

			// 격자 확인, 행열과 로직은 동일
			for (int i = 0; i < 9; i += 3) {
				for (int j = 0; j < 9; j += 3) {
					num3 = new int[9];
					for (int x = 0; x < 3; x++) {
						for (int y = 0; y < 3; y++) {
							num3[arr[i + x][j + y] - 1]++;
						}
					}
					for (int k = 0; k < 9; k++) {
						if (num3[k] != 1) {
							chk = false;
							break;
						}
					}
				}
			}
			if (chk == true)
				System.out.printf("#%d 1\n", t);
			else
				System.out.printf("#%d 0\n", t);

		}
	}
}