import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 0행 : 이전의 최적해, 1행 : 현재의 최적해
		int[][] dp = new int[2][3];
		for (int i = 0; i < N; i++) {
			// 각각의 집을 R G B로 칠하는 비용 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			// 현재 행에서 각각의 최적해 : 이전의 최적해 + 현재의 값
			dp[1][0] = Math.min(dp[0][1], dp[0][2]) + R;
			dp[1][1] = Math.min(dp[0][0], dp[0][2]) + G;
			dp[1][2] = Math.min(dp[0][0], dp[0][1]) + B;

			// 다음으로 넘어가기 전 현재의 최적해를 이전의 최적해로 보내주기
			dp[0][0] = dp[1][0];
			dp[0][1] = dp[1][1];
			dp[0][2] = dp[1][2];
		}

		System.out.println(Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]));
	}
}
