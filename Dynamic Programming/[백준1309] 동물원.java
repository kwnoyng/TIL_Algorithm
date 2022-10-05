import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int MOD = 9901;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N + 1][3];
		// 1x2 우리에 사자를 배치하는 경우
		dp[1][0] = 1; // 사자를 배치하지 않는 경우
		dp[1][1] = 1; // 좌측 칸에 사자를 배치
		dp[1][2] = 1; // 우측 칸에 사자를 배치

		// 현재 사자를 배치하지 않을 경우) 이전에 사자를 어디애 베치하던, 배치하지 않았던 상관없음
		// 현재 사자를 좌측에 배치할 경우) 이전에 사자가 좌측에 있을 경우는 제외
		// 현재 사자를 우측에 배치할 경우) 이전에 사자가 우측에 있을 경우는 제외
		for (int i = 2; i <= N; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
		}

		System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % MOD);
	}
}