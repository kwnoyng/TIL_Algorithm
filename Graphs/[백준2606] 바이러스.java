import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int arr[][];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		int m = Integer.parseInt(br.readLine()); // 간선의 개수

		arr = new int[n + 1][n + 1]; // 간선을 저장할 2차원 배열, 연결되어있으면 1
		visited = new boolean[n + 1]; // 방문했으면 true

		StringTokenizer st;
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}

		dfs(1); // 1번 컴퓨터부터 깊이 우선 탐색

		int cnt = 0; // 1번 컴퓨터와 연결된 컴퓨터의 개수 count

		// true면 연결되었다는 것, true의 개수를 count하자
		for (int i = 1; i <= n; i++) {
			if (visited[i] == true)
				cnt++;
		}

		System.out.println(--cnt); // 1번 컴퓨터는 제외이므로 -1 해주기

	}

	// dfs 구현(Recursion)
	static void dfs(int x) {
		visited[x] = true;
		for (int i = 1; i <= n; i++) {
			if (!visited[i] && arr[i][x] == 1) {
				dfs(i);
			}
		}
	}
}

/* Scanner 사용해서 푼 방법
import java.util.Scanner;

public class Main {
	static int n;
	static int arr[][];
	static boolean visited[];

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 컴퓨터의 수
		int m = sc.nextInt(); // 간선의 개수

		arr = new int[n + 1][n + 1]; // 간선을 저장할 2차원 배열, 연결되어있으면 1
		visited = new boolean[n + 1]; // 방문했으면 true

		for (int i = 1; i <= m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		dfs(1); // 1번 컴퓨터부터 깊이 우선 탐색
		
		int cnt = 0; // 1번 컴퓨터와 연결된 컴퓨터의 개수 count

		// true면 연결되었다는 것, true의 개수를 count하자
		for(int i = 1; i <= n; i++) {
			if(visited[i] == true) cnt++;
		}
		
		System.out.println(--cnt); // 1번 컴퓨터는 제외이므로 -1 해주기

	}

	//dfs 구현(Recursion)
	static void dfs(int x){
		visited[x] = true;
		for(int i = 1; i <= n; i++) {
			if(!visited[i] && arr[i][x] == 1) {
				dfs(i);
			}
		}
	}
}
*/
