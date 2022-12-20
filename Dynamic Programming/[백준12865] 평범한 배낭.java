import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 0/1 knapsack Algorithm
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// W : 물건의 무게, V : 물건의 가치
		int[] W = new int[N + 1];
		int[] V = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N + 1][K + 1];
		// 물건을 하나씩 고려해서 최적의 가치를 구한다.
		for (int i = 1; i <= N; i++) {
			for (int w = 1; w <= K; w++) {
				// 현재 고려하는 물건이 임시 무게보다 클 경우 (담을 수 없음)
				if (W[i] > w) {
					dp[i][w] = dp[i - 1][w];
				}
				// 현재 고려하는 물건이 임시무게보다 작을 경우 (담을 수 있음)
				else {
					dp[i][w] = Math.max(dp[i - 1][w - W[i]] + V[i], dp[i - 1][w]);
				}
			}
		}

		System.out.println(dp[N][K]);
	}
}