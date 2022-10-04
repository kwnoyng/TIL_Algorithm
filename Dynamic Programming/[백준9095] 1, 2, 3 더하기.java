import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[11];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		// n을 1,2,3의 합으로 나타내는 방법의 수?
		// n = 1) 1
		// n = 2) 1+1, 2
		// n = 3) 1+1+1, 1+2, 2+1, 3
		// n = 4)
		// n = 1일 때 경우의 수에 3을 더한다) 1+3
		// n = 2일 때 경우의 수에 2를 더한다) 1+1+2, 2+2
		// n = 3일 때 경우의 수에 1을 더한다) 1+1+1+1, 1+2+1, 2+1+1, 3+1
		for (int i = 3; i <= 10; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}
}
