import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static final int INF = Integer.MAX_VALUE;
	static int N, M, K, X;
	static ArrayList<Integer>[] list;
	static int[] dist;

	// Priority Queue를 이용한 Dijkstra 구현
	static void dijkstra() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		dist[X] = 0;
		pq.offer(X);

		while (!pq.isEmpty()) {
			int cur = pq.poll();

			for (int x : list[cur]) {
				if (dist[x] > dist[cur] + 1) {
					dist[x] = dist[cur] + 1;
					pq.offer(x);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
		}

		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		// 다익스트라 함수 호출
		dijkstra();

		// 다익스트라로 최단경로를 구한 후 거리가 K인 도시를 ans에 저장
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K)
				ans.add(i);
		}

		// 거리가 K인 도시가 없다면 -1 출력
		if (ans.size() == 0)
			System.out.println(-1);
		// ans의 원소를 차례로 출력
		else {
			for (int x : ans)
				System.out.println(x);
		}
	}
}
