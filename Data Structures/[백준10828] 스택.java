import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] stack = new int[10000];
	static int top = -1;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if (str.equals("push")) {
				push();
			} else if (str.equals("pop")) {
				System.out.println(pop());
			} else if (str.equals("size")) {
				System.out.println(size());
			} else if (str.equals("empty")) {
				System.out.println(empty());
			} else if (str.equals("top")) {
				System.out.println(top());
			}
		}
	}

	static void push() {
		int k = Integer.parseInt(st.nextToken());
		top++;
		stack[top] = k;
	}

	static int pop() {
		if (top == -1) {
			return -1;
		} else {
			return stack[top--];
		}
	}

	static int size() {
		return top + 1;
	}

	static int empty() {
		if (top == -1) {
			return 1;
		} else {
			return 0;
		}
	}

	static int top() {
		if (top == -1) {
			return -1;
		} else {
			return stack[top];
		}
	}
}
