import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static boolean[] vis;
	static boolean flag;
	static ArrayList<ArrayList<Integer>> list;

	static void dfs(int x, int cnt) {
		vis[x] = true;
		// cnt == 5이면 ABCDE만족, flag = true
		if (cnt == 5) {
			flag = true;
			return;
		}
		// 인접리스트에 연결된 것들을 순차적으로 깊이우선탐색 실시
		for (int nxt : list.get(x)) {
			if (!vis[nxt]) {
				dfs(nxt, cnt + 1);
			}
		}
		// 방문처리를 바꿔준다
		vis[x] = false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		vis = new boolean[N];
		list = new ArrayList<>();

		// 인접리스트로 친구관계 저장
		for (int i = 0; i < N; i++)
			list.add(new ArrayList<>());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		// dfs 탐색
		for (int i = 0; i < N; i++) {
			dfs(i, 1);
			if (flag) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
}
