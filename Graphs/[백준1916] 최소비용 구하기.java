import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, start, end;
	static ArrayList<Edge>[] edges;
	static int[] dist;
	static boolean[] vis;
	static final int INF = Integer.MAX_VALUE;

	// 다익스트라
	static void dijkstra(int start) {
		dist[start] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (vis[cur.v])
				continue;
			vis[cur.v] = true;
			for (Edge nxt : edges[cur.v]) {
				if (dist[nxt.v] > dist[cur.v] + nxt.weight) {
					dist[nxt.v] = dist[cur.v] + nxt.weight;
					pq.offer(new Edge(nxt.v, dist[nxt.v]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		edges = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			edges[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			edges[x].add(new Edge(y, k));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		vis = new boolean[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, INF);

		dijkstra(start);

		System.out.println(dist[end]);
	}

	static class Edge implements Comparable<Edge> {
		int v;
		int weight;

		Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}
