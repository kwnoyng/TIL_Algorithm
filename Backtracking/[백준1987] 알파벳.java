import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] arr;
	static boolean[] vis;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans;

	static void dfs(int r, int c, int dist) {

		// 최대 이동한 거리를 갱신
		ans = Math.max(ans, dist);

		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			// 경계값을 벗어나면 continue
			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;
			// 다음으로 이동할 곳의 알파벳이 지금까지 이동한 알파벳과 다르다면
			// dist를 1 증가 후 이동
			if (!vis[arr[nr][nc] - 65]) {
				vis[arr[nr][nc] - 65] = true;
				dfs(nr, nc, dist + 1);
				vis[arr[nr][nc] - 65] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		// 알파벳이 사용되었는지 확인하는 배열
		vis = new boolean[26];
		// 초기 좌측 상단부터 이동을 시작하므로 true로 변경 후 dfs함수 호출
		vis[arr[0][0] - 65] = true;
		dfs(0, 0, 1);

		System.out.println(ans);
	}
}
