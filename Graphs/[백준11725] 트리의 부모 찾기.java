import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static ArrayList<Integer>[] tree;
	static boolean[] vis;
	static int[] p;

	// bfs로 트리의 부모를 찾는다
	static void bfs() {
		// 큐 만들고 루트가 1이므로 1을 처음에 넣어주고 방문처리
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		vis[1] = true;

		// 큐에서 값을 하나 빼고 해당 연결요소를 확인하며 p배열에 cur값을 넣어준다
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int x : tree[cur]) {
				if (!vis[x]) {
					vis[x] = true;
					p[x] = cur;
					q.offer(x);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			tree[i] = new ArrayList<>();
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			tree[x].add(y);
			tree[y].add(x);
		}

		vis = new boolean[N + 1];
		p = new int[N + 1];

		bfs();

		// 2번 노드부터 순서대로 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++)
			sb.append(p[i]).append("\n");
		System.out.println(sb);
	}
}
