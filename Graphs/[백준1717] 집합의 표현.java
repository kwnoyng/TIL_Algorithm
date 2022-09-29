import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		p = new int[n + 1];
		for (int i = 0; i <= n; i++)
			makeSet(i);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 합집합이라면 union
			if (cmd == 0) {
				union(a, b);
			}
			// 같은 집합에 포함되어있는지 확인한다면
			else {
				// 대표자가 같은지 확인하고 같다면 같은 집합
				if (findSet(a) == findSet(b)) {
					sb.append("YES\n");
				}
				// 대표자가 다르다면 다른 집합
				else {
					sb.append("NO\n");
				}
			}
		}
		System.out.println(sb);
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
}
