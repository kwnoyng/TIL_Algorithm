import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	static int N, M;
	static int[] p;

	// makeSet 함수 구현
	static void makeSet() {
		for (int i = 1; i <= N; i++)
			p[i] = i;
	}

	// findSet 함수 구현
	static int findSet(int x) {
		if (p[x] == x)
			return x;
		return p[x] = findSet(p[x]);
	}

	// union 함수 구현
	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 간선을 가중치의 오름차순으로 정렬하기 위해 우선순위 큐를 만듬
		PriorityQueue<Edge> edges = new PriorityQueue<>();

		// 입력을 받으며 우선순위 큐에 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges.offer(new Edge(x, y, weight));
		}

		p = new int[N + 1];
		// 각각의 도시별로 부분집합을 만들어준다
		makeSet();

		int ans = 0;
		int pick = 0;
		for (int i = 0; i < M; i++) {

			// 우선순위 큐에서 하나를 꺼낸다
			Edge edge = edges.poll();
			int px = edge.x;
			int py = edge.y;
			// px와 py가 서로 다른 부분집합이라면
			// 두 집합을 union해주고 ans에 해당 가중치를 누적해서 더하고 뽑은 간선을 pick++
			if (findSet(px) != findSet(py)) {
				union(px, py);
				ans += edge.weight;
				pick++;
			}
			// 간선을 N-2개 뽑았으면 break
			// N-1개까지 뽑는다면 도시가 모두 연결되므로 한 마을이 된다.
			// 두 마을로 나누려면 N-2까지 뽑아야한다.
			if (pick == N - 2)
				break;
		}

		System.out.println(ans);
	}

	// 간선을 나타내는 클래스
	// 가중치를 오름차순으로 정렬하기 위해 Comparable을 상속
	static class Edge implements Comparable<Edge> {
		int x;
		int y;
		int weight;

		Edge(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}