import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] num;
	static int[] op;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	static void dfs(int n, int x) {
		// N번까지 연산을 수행했다면 연산의 최댓값, 최솟값을 갱신
		if (x == N) {
			max = Math.max(max, n);
			min = Math.min(min, n);
			return;
		}
		//
		for (int i = 0; i < 4; i++) {
			// op가 양수라면 연산할 수 있다
			if (op[i] > 0) {
				// 사용할 연산을 하나 줄여준다 op--
				op[i]--;
				switch (i) {
				// 0, 1, 2, 3 순으로 + - * /
				// 연산
				case 0:
					dfs(n + num[x], x + 1);
					break;
				case 1:
					dfs(n - num[x], x + 1);
					break;
				case 2:
					dfs(n * num[x], x + 1);
					break;
				case 3:
					dfs(n / num[x], x + 1);
					break;
				}
				// return되면 다시 op++
				op[i]++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		op = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		// 우선순위를 무시하므로 처음 숫자부터 차례로 연산
		dfs(num[0], 1);

		System.out.println(max);
		System.out.println(min);
	}
}
