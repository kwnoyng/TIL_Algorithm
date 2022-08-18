import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}

		// 큐의 사이즈가 1이 될 때까지 실행
		while (q.size() != 1) {
			q.poll(); // 한 장 버림
			q.offer(q.poll()); // 다음 한 장을 맨 뒤로
		}

		System.out.println(q.peek());
	}
}

/* 규칙을 찾고 수식을 활용한 풀이법
 * public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[1000000];

		int idx = 2;
		int cnt = 1;
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			if (cnt < idx) {
				cnt *= 2;
				idx = 2;
			}
			arr[i] = idx;
			idx += 2;
		}

		System.out.println(arr[n]);
	}
}
 */