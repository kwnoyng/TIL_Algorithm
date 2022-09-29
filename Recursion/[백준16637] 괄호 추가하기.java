import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static int N;
	static ArrayList<Integer> number;
	static ArrayList<Character> operation;
	static int ans = Integer.MIN_VALUE;

	static void dfs(int x, int sum) {
		// 모두 연산했다면 정답을 최댓값으로 바꿔준 후 return
		if (x >= N / 2) {
			ans = Math.max(ans, sum);
			return;
		}

		// 괄호를 사용하지 않고 연산
		// x번째와 x+1번째를 연산한 후 dfs 재귀호출
		dfs(x + 1, cal(sum, number.get(x + 1), x));

		// 괄호를 사용하고 연산
		// x+1번째와 x+2번째를 먼저 연산 후 지금까지 계산한 것과 연산
		if (x < N / 2 - 1) {
			int num = cal(number.get(x + 1), number.get(x + 2), x + 1);
			dfs(x + 2, cal(sum, num, x));
		}
	}

	// calculator 함수
	static int cal(int a, int b, int idx) {
		if (operation.get(idx) == '+') {
			return a + b;
		} else if (operation.get(idx) == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		number = new ArrayList<>();
		operation = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			char ch = str.charAt(i);
			if (i % 2 == 0)
				number.add(ch - '0');
			else
				operation.add(ch);
		}
		dfs(0, number.get(0));
		System.out.println(ans);
	}
}
