import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int V, E, K;
	static ArrayList<Edge>[] edges;
	static int[] dist;
	static boolean[] vis;
	static final int INF = Integer.MAX_VALUE;

	// 다익스트라
	static void dijkstra(int k) {
		dist[k] = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(k, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (vis[cur.v])
				continue;
			vis[cur.v] = true;

			for (Edge nxt : edges[cur.v]) {
				if (dist[nxt.v] > dist[cur.v] + nxt.w) {
					dist[nxt.v] = dist[cur.v] + nxt.w;
					pq.offer(new Edge(nxt.v, dist[nxt.v]));
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		edges = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++)
			edges[i] = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			edges[x].add(new Edge(y, k));
		}

		dist = new int[V + 1];
		vis = new boolean[V + 1];
		Arrays.fill(dist, INF);
		dijkstra(K);
		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}

	static class Edge implements Comparable<Edge> {
		int v;
		int w;

		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
}
