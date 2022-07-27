import java.util.Scanner;

public class Main {
	static int dp[][] = new int[31][31]; // MEMOIZATION

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 경우의 수 = nCr 조합의 개수와 동일
		// dp의 초깃값 설정
		for (int i = 1; i <= 30; i++) {
			dp[i][1] = i;
		}

		// 반복문으로 dp의 값을 채움 
		// nCr == dp[n][r]
		for (int i = 2; i <= 30; i++) {
			for (int j = 2; j <= i; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}

		int t = sc.nextInt(); // 테스트 케이스의 개수

		while (t-- > 0) {
			int a = sc.nextInt(); // 강 서쪽 == r
			int b = sc.nextInt(); // 강 동쪽 == n

			System.out.println(dp[b][a]);
		}
	}
}