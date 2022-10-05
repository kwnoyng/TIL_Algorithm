import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];

		dp[1] = arr[1];

		// N이 1인 경우 idx에러가 나므로 조건문으로 처리
		if (N >= 2)
			dp[2] = arr[1] + arr[2];

		// 마지막 계단은 무조건 밟아야 함
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
		}
		System.out.println(dp[N]);
	}
}