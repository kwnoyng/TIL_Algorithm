import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		// dp배열 선언, idx번째를 마지막으로 하는 수열의 길이
		int[] dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int ans = 0;
		for (int i = 0; i < N; i++) {
			// 초기 dp의 값은 1로 설정
			dp[i] = 1;

			// i번째값과 i번째 이전값들을 모두 비교
			for (int j = 0; j < i; j++) {
				// 만약 arr[i]가 arr[j]보다 크다면 현재의 dp[i]값과 dp[j]+1의 최댓값으로 최신화
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ans = Math.max(ans, dp[i]);
		}

		// 수열을 확인하기 위한 스택 선언
		// 초기 value값은 최장길이(ans)의 값
		Stack<Integer> stack = new Stack<>();
		int val = ans;

		// 마지막부터 초기값까지 돌며 현재의 val와 dp의 값이 일치하다면 스택에 저장 후 val--
		for (int i = N - 1; i >= 0; i--) {
			if (dp[i] == val) {
				stack.push(arr[i]);
				val--;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(ans).append("\n");
		while (!stack.empty()) {
			sb.append(stack.pop()).append(" ");
		}

		System.out.println(sb);
	}
}