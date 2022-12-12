import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int G, P;
	static int[] parent;
	static int cnt;

	static void makeSet() {
		for (int i = 1; i <= G; i++) {
			parent[i] = i;
		}
	}

	static int findSet(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = findSet(parent[x]);
	}

	static void union(int x, int y) {
		parent[findSet(x)] = findSet(y);
	}

	/*
	 * g번 비행기는 g번 이하 게이트에만 도킹이 가능함. g번 비행기를 g번 게이트에 도킹하는 것이 최선.
	 * 만약, g번 비행기를 g번게이트에 도킹할 수 없다면, g-1번 게이트에 차선책으로 도킹시킴.
	 * g-1번도 안 된다면, g-2번, ... 0번까지 탐색.
	 * 차선책이 0번을 가리키고 있으면 도킹이 불가능한 상태임.
	 * 차선책을 찾는 과정에서 union-find 알고리즘을 사용함.
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.parseInt(br.readLine());
		parent = new int[G + 1];
		P = Integer.parseInt(br.readLine());

		makeSet();

		while (P-- > 0) {
			int g = Integer.parseInt(br.readLine());
			int gate = findSet(g);
			if (gate == 0)
				break;
			union(gate, gate - 1);
			cnt++;
		}

		System.out.println(cnt);
	}
}
