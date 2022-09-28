import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		Node[] edges = new Node[M];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			edges[i] = new Node(a, b, k);
		}

		// 가중치에 따른 오름차순 정렬
		Arrays.sort(edges);

		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			makeSet(i);
		}

		int ans = 0;
		int pick = 0;
		for (int i = 0; i < M; i++) {
			int px = findSet(edges[i].a);
			int py = findSet(edges[i].b);

			// 두 대표자가 서로 다른 집합이라면 union
			// ans에 비용을 누적 후 pick++
			if (px != py) {
				union(px, py);
				ans += edges[i].k;
				pick++;
			}

			// N-1개를 뽑았다면 최소스패닝트리를 구한 것
			if (pick == N - 1)
				break;
		}

		System.out.println(ans);
	}

	// makeSet 구현
	static void makeSet(int x) {
		p[x] = x;
	}

	// findSet 구현
	static int findSet(int x) {
		if (p[x] == x)
			return x;
		return p[x] = findSet(p[x]);
	}

	// union 구현
	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

	// Node 클래스 구현
	// a : 시작 정점, b : 도착 정점, k : 비용
	static class Node implements Comparable<Node> {
		int a;
		int b;
		int k;

		Node(int a, int b, int k) {
			this.a = a;
			this.b = b;
			this.k = k;
		}

		@Override
		public int compareTo(Node o) {
			return this.k - o.k;
		}
	}
}
