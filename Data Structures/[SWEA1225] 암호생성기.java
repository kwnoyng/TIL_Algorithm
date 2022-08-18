import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			Integer.parseInt(br.readLine());
			Queue<Integer> q = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}

			int idx = 1;
			while (true) {
				// idx는 1에서 5까지가 한 사이클, 점차 증가하며 5를 초과하면 1로 다시 초기화
				if (idx > 5)
					idx = 1;

				// peek값에서 idx를 빼준 게 0 이하면, 0을 큐에 추가하고 종료
				if (q.peek() - idx <= 0) {
					q.offer(0);
					q.poll();
					break;
				}
				// 0 이하가 아니라면, idx만큼 빼주고 뒤에 추가 반복
				q.offer(q.peek() - idx);
				q.poll();
				idx++;
			}

			StringBuilder sb = new StringBuilder();
			while (!q.isEmpty()) {
				sb.append(q.poll()).append(" ");
			}

			System.out.printf("#%d %s\n", t, sb);
		}
	}
}
