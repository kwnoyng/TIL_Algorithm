import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static char[][] arr;
	static int cnt;
	static int ans;

	// 행과 열에서 연속된 최대의 사탕 개수 구하기
	static void chk() {
		// 행 비고
		for (int i = 0; i < N; i++) {
			cnt = 1;
			for (int j = 0; j < N - 1; j++) {
				if (arr[i][j] == arr[i][j + 1])
					cnt++;
				else
					cnt = 1;
				ans = Math.max(ans, cnt);
			}
		}
		// 열 비교
		for (int i = 0; i < N; i++) {
			cnt = 1;
			for (int j = 0; j < N - 1; j++) {
				if (arr[j][i] == arr[j + 1][i])
					cnt++;
				else
					cnt = 1;
				ans = Math.max(ans, cnt);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 오른쪽 교환
				if (j + 1 < N) {
					char tmp = arr[i][j + 1];
					arr[i][j + 1] = arr[i][j];
					arr[i][j] = tmp;
					chk();
					tmp = arr[i][j + 1];
					arr[i][j + 1] = arr[i][j];
					arr[i][j] = tmp;
				}
				// 아래 교환
				if (i + 1 < N) {
					char tmp = arr[i + 1][j];
					arr[i + 1][j] = arr[i][j];
					arr[i][j] = tmp;
					chk();
					tmp = arr[i + 1][j];
					arr[i + 1][j] = arr[i][j];
					arr[i][j] = tmp;
				}
			}
		}

		System.out.println(ans);
	}
}
