import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// Test case만큼 반복
		while (T-- > 0) {
			int K = Integer.parseInt(br.readLine());
			// 파일을 오름차순으로 정렬해줄 우선순위 큐
			PriorityQueue<Long> file = new PriorityQueue<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 파일을 하나씩 큐에 넣어준다
			for (int i = 0; i < K; i++)
				file.offer(Long.parseLong(st.nextToken()));

			long cnt = 0;
			// 큐의 크기가 2 이상이면 (파일을 합칠 수 있다면)
			// 정렬된 파일에서 가장 크기가 작은 파일 두 개부터 계속 합쳐나간다
			while (file.size() != 1) {
				long x = file.poll();
				long y = file.poll();
				file.offer(x + y);
				cnt += x + y;
			}
			System.out.println(cnt);
		}
	}
}
