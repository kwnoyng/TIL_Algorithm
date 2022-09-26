import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][] arr;
	static boolean[][] vis;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int x, y; // 시작점의 좌표
	static boolean flag; // 사이클의 여부

	static void dfs(int r, int c, int cnt) {

		// 사이클이 이미 존재한다면 return
		if (flag)
			return;

		vis[r][c] = true;

		// 4방탐색
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			// 경계값이 벗어나면 continue
			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;
			// 다음 방문할 곳이 시작점이면서 서로 다른 점을 4번 이상 돌았으면 사이클 존재
			if (nr == x && nc == y && cnt >= 4) {
				flag = true;
				return;
			}

			// 방문하지 않았으며 똑같은 알파벳이라면 dfs함수 재귀 호출
			if (!vis[nr][nc] && arr[r][c] == arr[nr][nc]) {
				dfs(nr, nc, cnt + 1);
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		// 이중 포문을 돌며 flag가 아니라면 새로운 vis 배열을 만들고
		// 현재 시작점을 x, y에 표기한 후 dfs함수 호출
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!flag) {
					vis = new boolean[N][M];
					x = i;
					y = j;
					dfs(i, j, 1);
				}
			}
		}

		if (flag)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
