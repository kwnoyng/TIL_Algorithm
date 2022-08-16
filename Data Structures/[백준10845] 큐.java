import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] queue = new int[10000];
	static int front = -1;
	static int rear = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if (str.equals("push")) {
				int k = Integer.parseInt(st.nextToken());
				push(k);
			} else if (str.equals("pop")) {
				System.out.println(pop());
			} else if (str.equals("size")) {
				System.out.println(size());
			} else if (str.equals("empty")) {
				System.out.println(empty());
			} else if (str.equals("front")) {
				System.out.println(front());
			} else if (str.equals("back")) {
				System.out.println(back());
			}
		}
	}

	static void push(int x) {
		rear++;
		queue[rear] = x;
	}

	static int pop() {
		if (rear == front) {
			return -1;
		} else {
			front++;
			return queue[front];
		}
	}

	static int size() {
		return rear - front;
	}

	static int empty() {
		if (rear == front) {
			return 1;
		} else {
			return 0;
		}
	}

	static int front() {
		if (rear == front) {
			return -1;
		} else {
			return queue[front + 1];
		}
	}

	static int back() {
		if (rear == front) {
			return -1;
		} else {
			return queue[rear];
		}
	}
}
