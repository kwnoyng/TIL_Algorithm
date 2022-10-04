import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int mod = 1_000_000_009;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[][] dp = new long[100001][4];

		// [idx][마지믹에 오는 숫자]

		// n = 1) 1
		// n = 2) 2
		// n = 3) 2+1, 1+2, 3
		// n = 4)
		// n = 4인데 마지막 수가 1일 때) 1이 연속이 되면 안 됨 : 1+2+1, 3+1
		// n = 4인데 마지막 수가 2일 때) 2이 연속이 되면 안 됨 : X
		// n = 4인데 마지막 수가 3일 때) 3이 연속이 되면 안 됨 : 1+3
		// dp[i][1] = dp[i - 1][2] + dp[i - 1][3]
		// dp[i][2] = dp[i - 2][1] + dp[i - 2][3]
		// dp[i][3] = dp[i - 3][1] + dp[i - 3][2]
		dp[1][1] = 1;
		dp[1][2] = 0;
		dp[1][3] = 0;

		dp[2][1] = 0;
		dp[2][2] = 1;
		dp[2][3] = 0;

		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		for (int i = 4; i <= 100000; i++) {
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod;
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod;
		}
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % mod);
		}
	}
}
