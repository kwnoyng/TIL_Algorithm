import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n;
	static int[][] graph; // 간선 연결 그래프
	static boolean[] visited; // 방문 여부

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 정점의 개수
		int m = sc.nextInt(); // 간선의 개수
		int v = sc.nextInt(); // 정점의 번호

		graph = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x][y] = 1;
			graph[y][x] = 1;
		}

		dfs(v);
		// 방문 여부 초기화
		for (int i = 1; i <= n; i++) {
			visited[i] = false;
		}
		System.out.println();
		bfs(v);
	}

	// dfs 구현 (Recursion)
	static void dfs(int x) {
		visited[x] = true;
		System.out.print(x + " ");
		for (int i = 1; i <= n; i++) {
			if (visited[i] == false && graph[x][i] == 1) {
				dfs(i);
			}
		}
	}

	// bfs 구현 (Queue)
	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		visited[x] = true;
		q.offer(x);

		while (q.isEmpty() != true) {
			int node = q.poll();
			System.out.print(node + " ");

			for (int i = 1; i <= n; i++) {
				if (visited[i] == false && graph[node][i] == 1) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}