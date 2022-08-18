import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			// 중요도의 인덱스를 따로 표기할 tmp 배열
			int[] tmp = new int[n];
			Queue<Integer> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				tmp[i] = Integer.parseInt(st.nextToken());
				q.offer(tmp[i]);
			}

			// 중요도 순서대로 문서를 출력할 것이므로 중요도 배열을 정렬
			Arrays.sort(tmp);

			int idx = m; // 출력할 문서의 중요도의 인덱스
			int cnt = 0; // 몇 번째로 문서를 출력했는지
			// 중요도가 큰 순서대로 출력을 할 건데
			for (int i = n - 1; i >= 0; i--) {

				// 큐의 peek값이 중요도가 가장 큰 것과 비교해서 다르다면 한 장씩 다시 뒤로 넘겨주고
				// 몇 번째로 출력되는지 궁금한 문서의 인덱스도 하나씩 앞으로 당겨준다
				while (q.peek() != tmp[i]) {
					q.offer(q.poll());
					idx = (idx + q.size() - 1) % q.size();
				}

				// peek값이 중요도가 가장 큰 것이면 출력해주고 cnt++.
				q.poll();
				cnt++;

				// 만약 출력한 문서의 idx가 0이라면(이번에 출력됐다면)
				// 몇 번째로 출력됐는지 cnt를 출력
				if (idx == 0) {
					System.out.println(cnt);
					break;
				}
				idx = (idx + q.size() - 1) % q.size();
			}
		}
	}
}