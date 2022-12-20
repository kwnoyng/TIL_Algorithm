import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 슬라임을 크기 내림차순으로 우선순위 큐에 넣는다.
		PriorityQueue<Integer> slime = new PriorityQueue<>(Collections.reverseOrder());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int size = Integer.parseInt(st.nextToken());
			slime.offer(size);
		}

		int cnt = 0;
		// 우선순위 큐의 사이즈가 1이 될 때까지 반복
		while (slime.size() != 1) {
			// 크기가 가장 큰 슬라임 두 개를 꺼내서 합친다.
			int x = slime.poll();
			int y = slime.poll();
			// 합친 후 점수를 누적
			cnt += x * y;
			// 합쳐진 슬라임을 우선수위 큐에 삽입
			slime.offer(x + y);
		}

		System.out.println(cnt);

	}
}
