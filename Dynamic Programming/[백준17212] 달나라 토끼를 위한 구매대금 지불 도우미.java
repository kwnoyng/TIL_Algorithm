import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// N이 최대 100,000이므로 100,001 크기의 최대 배열 생성
		int[] dp = new int[100_001];

		// 1원 ~ 7원까지 지불할 때 최소 동전 개수
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 2;
		dp[5] = 1;
		dp[6] = 2;
		dp[7] = 1;

		// 8원 이상의 x원을 지불할 경우
		// x-1원에서 1원을 추가 지불할 경우
		// x-2원에서 2원을 추가 지불할 경우
		// x-5원에서 5원을 추가 지불할 경우
		// x-7원에서 7원을 추가 지불할 경우
		// 위 네 경우의 최솟값
		for (int i = 8; i <= N; i++)
			dp[i] = Math.min(Math.min(Math.min(dp[i - 1], dp[i - 2]), dp[i - 5]), dp[i - 7]) + 1;

		System.out.println(dp[N]);
	}
}
