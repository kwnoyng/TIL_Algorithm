import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger[] dp = new BigInteger[251];
		dp[0] = BigInteger.valueOf(1);
		dp[1] = BigInteger.valueOf(1);
		dp[2] = BigInteger.valueOf(3);
		for (int i = 3; i <= 250; i++) {
			dp[i] = dp[i - 1].add(dp[i - 2].multiply(new BigInteger("2")));
		}
		while (true) {
			// 입력이 들어오지 않을 경우를 통한 예외처리
			try {
				int n = Integer.parseInt(br.readLine());
				System.out.println(dp[n]);
			} catch (Exception e) {
				break;
			}
		}
	}
}