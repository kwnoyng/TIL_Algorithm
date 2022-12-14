import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		final int MAX = 1_000_000_000;
		// dp[a의 개수][z의 개수]로 만들 수 있는 모든 문자열 수를 구해준다.
		int[][] dp = new int[N + 1][M + 1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				// a만 존재할 경우, z만 존재할 경우 모두 만들 수 있는 문자열은 1개로 초기화
				if (i == 0 || j == 0) {
					dp[i][j] = 1;
					continue;
				}
				// dp[i][j]는 맨 앞 글자가 a일 경우 dp[i-1][j]와 맨 앞 글자가 z일 경우 dp[i][j-1]의 합
				// 점화식 : dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

				// dp[i][j]가 MAX를 초과할 경우 MAX로 초기화
				if (dp[i][j] > MAX)
					dp[i][j] = MAX;
			}
		}

		// 사전에 수록되어 있는 문자열의 개수가 K보다 작으면 -1출력
		if (dp[N][M] < K) {
			System.out.println(-1);
			return;
		}

		int a = N;
		int z = M;

		StringBuilder sb = new StringBuilder();
		// N+M번 반복하며 문자를 하나씩 추가해준다.
		for (int i = 0; i < N + M; i++) {
			// a의 개수가 0이면 z를 추가, z의 개수가 0이면 a를 추가
			if (a == 0) {
				sb.append('z');
				z--;
				continue;
			} else if (z == 0) {
				sb.append('a');
				a--;
				continue;
			}

			// x : 현재 dp[a의 개수][z의 개수]에서 맨 앞 글자가 a가 올 경우의 문자열 개수
			int x = dp[a - 1][z];

			// 맨 앞의 글자가 a일 때 dp[a의 개수][z의 개수]로 만들 수 있는 문자열의 개수가 K 이상이라면
			// 맨 앞의 글자가 a의 경우의 수 안에 포함되므로 맨 앞 글자는 a로 지정 후 a--
			if (x >= K) {
				sb.append('a');
				a--;
			}
			// 맨 앞의 글자가 a의 경우의 수 안에 포함되지 않는다면
			// 맨 앞의 글자는 z이므로 z--
			// K에서 맨 앞의 글자가 a인 경우(x)를 빼준다.
			else {
				sb.append('z');
				K -= x;
				z--;
			}
		}

		System.out.println(sb);
	}
}
