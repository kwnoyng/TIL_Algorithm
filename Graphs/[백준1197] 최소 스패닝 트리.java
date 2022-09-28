import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] edges = new int[E][3];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}

		// 간선의 가중치에 따른 오름차순 정렬
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		// 대표자 저장할 배열
		p = new int[V + 1];
		// makeSet을 통한 대표자 설정
		for (int i = 1; i <= V; i++) {
			makeSet(i);
		}

		int ans = 0;
		int pick = 0;
		for (int i = 0; i < E; i++) {
			// 두 정점의 대표자를 찾고
			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);
			// 두 대표자가 서로 다른 집합이라면 union
			// 가중치를 누적해서 더해주고 pick++
			if (px != py) {
				union(px, py);
				ans += edges[i][2];
				pick++;
			}
			// V-1개의 간선을 선택했다면 최소 스패닝 트리을 구한 것
			if (pick == V - 1)
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
}
