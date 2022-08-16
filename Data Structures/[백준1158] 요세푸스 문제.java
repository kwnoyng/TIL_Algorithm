import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();

		// 1부터 순서대로 queue에 삽입
		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}

		StringBuilder sb = new StringBuilder();

		// queue가 빌 때까지
		while (!q.isEmpty()) {
			// k번째 사람을 찾아서 제거해야하므로 k-1번 가장 먼저 들어온 값을 뒤에 삽입하고 삭제
			for (int i = 0; i < k - 1; i++) {
				q.offer(q.peek());
				q.poll();
			}
			// k-1번 건너뛰고 k번째를 찾았으면 해당 번호를 순서대로 스트링빌더에 저장
			if (q.size() == 1) {
				sb.append(q.poll());
			} else {
				sb.append(q.poll()).append(", ");
			}
		}
		System.out.printf("<%s>", sb);
	}
}