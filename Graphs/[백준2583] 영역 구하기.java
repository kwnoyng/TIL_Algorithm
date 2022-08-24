import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int m, n, k;
	static boolean[][] arr;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cnt, area;
	static ArrayList<Integer> areaList = new ArrayList<>();

	// dfs 구현
	static void dfs(int x, int y) {

		// true로 방문처리 후 영역의 넓이를 cnt++
		arr[x][y] = true;
		area++;

		// 사방으로 탐색하며 false인 경우 dfs 재귀 호출
		for (int dir = 0; dir < 4; dir++) {
			int nr = x + dr[dir];
			int nc = y + dc[dir];
			if (nr < 0 || nr >= m || nc < 0 || nc >= n)
				continue;
			if (!arr[nr][nc]) {
				dfs(nr, nc);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new boolean[m][n];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int a = x1; a < x2; a++) {
				for (int b = y1; b < y2; b++) {
					arr[b][a] = true;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				// 방문하지 않았으면 dfs호출
				// 영역의 개수를 cnt++
				// 넓이를 리스트에 넣어주고 초기화
				if (!arr[i][j]) {
					dfs(i, j);
					cnt++;
					areaList.add(area);
					area = 0;
				}
			}
		}

		// 영역의 각 넓이를 오름차순으로 정렬
		Collections.sort(areaList);

		System.out.println(cnt);
		for (int x : areaList) {
			System.out.print(x + " ");
		}
	}
}
