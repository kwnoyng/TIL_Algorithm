import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		// n = 1) 1x2 타일링 한 개
		// n = 2) 1x2 타일링 두 개, 2x1 타일링 두 개
		// n = 3) 
		// n = 2인 타일링에서 우측에 1x2 타일링 하나 붙이기
		// n = 1인 타일링에서 우측에 2x1 타일링 두 개  이어붙이기
		// dp[i] = dp[i-1] + dp[i-2]
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
		System.out.println(dp[n]);
	}
}
