import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, k; // 노드 갯수, 삭제할 노드
	static int[] tree; // 트리 배열
	static boolean[] visited; // 방문여부 배열
	static boolean leaf; // 리프노드인지
	static int cnt; // 리프노드 갯수

	// dfs 구현
	static void dfs(int x) {
		// 방문여부 true, 리프노드라고 일단 체크
		leaf = true;
		visited[x] = true;

		// 만약 x가 지워야 할 노드이면 탐색할 필요가 없으므로 return
		if (x == k)
			return;

		// 방문하지 않았으며 연결요소이고 해당 idx가 지워야 할 노드가 아니라면,
		// dfs탐색, 자식이 있으므로 리프노드가 아님 (false)
		for (int i = 0; i < n; i++) {
			if (!visited[i] && tree[i] == x && i != k) {
				dfs(i);
				leaf = false;
			}
		}
		// for문을 거치지 않았으면 자식이 없음, 곧 리프노드이므로 cnt++
		if (leaf)
			cnt++;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		tree = new int[n];

		// 트리를 구현, idx와 tree[idx]가 연결됨.
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}

		k = Integer.parseInt(br.readLine());

		// root(-1)면 dfs탐색 시작
		for (int i = 0; i < n; i++) {
			if (tree[i] == -1)
				dfs(i);
		}

		System.out.println(cnt);
	}
}
