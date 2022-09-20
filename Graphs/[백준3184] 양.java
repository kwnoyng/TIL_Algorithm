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
	static int sheepCnt, wolfCnt;
	static int SHEEP, WOLF;

	static void dfs(int r, int c) {
		vis[r][c] = true;
		// o면 양 cnt++, v면 늑대 cnt++
		if (arr[r][c] == 'o')
			sheepCnt++;
		if (arr[r][c] == 'v')
			wolfCnt++;

		// 사방탐색으로 해당 영역을 모두 확인
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			// 경계 넘어가면 continue
			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;
			// 방문하지 않았으며 울타리(#)가 아니면 dfs 재귀 호출
			if (!vis[nr][nc] && arr[nr][nc] != '#')
				dfs(nr, nc);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		vis = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		// 울타리(#)가 아니라면 (양, 늑대, 빈 필드), 해당 영역 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!vis[i][j] && arr[i][j] != '#') {
					sheepCnt = 0;
					wolfCnt = 0;
					dfs(i, j);
					// 해당 영역 확인 후 늑대가 더 많으면 양은 다 죽었으므로 WOLF에 늑대cnt 누적
					if (wolfCnt >= sheepCnt) {
						WOLF += wolfCnt;
					} 
					// 양이 더 많으면 늑대는  쫒겨나므로 SHEEP에 양cnt 누적
					else {
						SHEEP += sheepCnt;
					}
				}
			}
		}

		System.out.println(SHEEP + " " + WOLF);
	}
}
