import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		StringTokenizer st;

		// n만큼 문자열에 따른 스택의 메서드 구현
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if (str.equals("push")) {
				int k = Integer.parseInt(st.nextToken());
				stack.push(k);
			} else if (str.equals("pop")) {
				if (stack.empty())
					System.out.println(-1);
				else {
					System.out.println(stack.peek());
					stack.pop();
				}
			} else if (str.equals("size")) {
				System.out.println(stack.size());
			} else if (str.equals("empty")) {
				if (stack.empty())
					System.out.println(1);
				else
					System.out.println(0);
			} else if (str.equals("top")) {
				if (stack.empty())
					System.out.println(-1);
				else
					System.out.println(stack.peek());
			}
		}
	}
}