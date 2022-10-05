import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];

		dp[1] = arr[1];
		// n이 1이면 idx에러가 나므로 조건문으로 처리
		if (n >= 2)
			dp[2] = arr[1] + arr[2];

		// 마지막 포도주를 꼭 마시지 않아도 되므로
		// 이전의 최적해까지 포함하여 현재의 최적해를 구한다
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]));
		}

		System.out.println(dp[n]);
	}
}