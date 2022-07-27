import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Stack<Integer> st = new Stack<>();

		// 정수가 0이 아니면 push, 0이면 pop
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0) {
				st.push(x);
			} else {
				st.pop();
			}
		}

		int sum = 0;
		// 스택이 빌 때까지 누적합 구하기
		while (!st.empty()) {
			sum += st.peek();
			st.pop();
		}

		System.out.println(sum);
	}
}
