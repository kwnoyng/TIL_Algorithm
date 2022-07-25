import java.util.Scanner;

public class Main {
	static int n; // 정점의 개수
	static int[][] arr;  // 간선을 연결하는 2차원 배열
	static boolean[] visited ; // 방문여부 체크!
	static int cnt = 0; // 연결 요소의 개수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt(); // 간선의 개수
		arr = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		
		// 간선이 연결되어있다면 1을 대입
		for(int i = 1; i <= m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			arr[u][v] = 1;
			arr[v][u] = 1;
		}
		
		// 1부터 dfs 메서드 실행
		// 1이랑 연결되어있는 것들은 모두 true (연결요소 1씩 증가)
		// visited배열값이 false면 연결되지 않은 것이므로 dfs 실행
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

	// dfs 구현 (Recursion)
	static void dfs(int x) {
		visited[x] = true;
		for(int i = 1; i <= n; i++) {
			if(!visited[i] && arr[x][i] == 1) {
				dfs(i);
			}
		}
	}
}
