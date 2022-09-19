import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			for (int j = M - 1; j >= 0; j--) {
				arr[i][j] = num % 10;
				num /= 10;
			}
		}

		int ans = 0;
		// 0 : 가로
		// 1 : 세로
		for (int s = 0; s < (1 << (N * M)); s++) {
			int sum = 0;
			// 연속된 가로
			for (int i = 0; i < N; i++) {
				int cur = 0;
				for (int j = 0; j < M; j++) {
					int k = i * M + j;
					// 가로이면 값 누적
					if ((s & (1 << k)) == 0) {
						cur = cur * 10 + arr[i][j];
					}
					// 세로이면 sum에 누적된 cur값 더해주고 cur 초기화
					else {
						sum += cur;
						cur = 0;
					}
				}
				// 누적된 cur값 더해주기
				sum += cur;
			}
			// 연속된 세로
			for (int j = 0; j < M; j++) {
				int cur = 0;
				for (int i = 0; i < N; i++) {
					int k = i * M + j;
					// 세로이면 값 누적
					if ((s & (1 << k)) != 0) {
						cur = cur * 10 + arr[i][j];
					}
					// 가로이면 sum에 누적된 cur값 더해주고 cur 초기화
					else {
						sum += cur;
						cur = 0;
					}
				}
				// 누적된 cur값 더해주기
				sum += cur;
			}
			ans = Math.max(ans, sum);
		}
		// k : 2차원배열을 0 ~ N*M-1까지 순서대로 매칭한 번호
		// ex) 4 X 4 배열에서 2행 3열의 번호 : 1*4 + 3 = 7번

		System.out.println(ans);
	}
}
