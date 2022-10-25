import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		// dp배열 선언, idx번째를 마지막으로 하는 수열의 합
		int[] dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int ans = 0;
		for (int i = 0; i < N; i++) {

			// 초기값을 arr[i]로 초기화
			dp[i] = arr[i];

			// i번째값과 i번째 이전값들을 모두 비교
			for (int j = 0; j < i; j++) {
				// 만약 arr[i]가 arr[j]보다 크다면 dp[i]값과 dp[j]+arr[j]의 최댓값으로 최신화
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
			ans = Math.max(ans, dp[i]);
		}

		System.out.println(ans);
	}
}