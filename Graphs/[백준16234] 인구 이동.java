import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, L, R;
	static int[][] arr;
	static boolean[][] vis1;
	static boolean[][] vis2; // 복사해줄 boolean 배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cnt, sum; // 인구가 이동해야할 지역, 인구의 총 수
	static int ans; // 총 인구 이동한 수
	static boolean flag;

	// dfs구현부
	// 상하좌우를 탐색해서 국경선이 열리는 지역을 true
	// 지역의 수(cnt)와 총 인구수(sum를 구해준다
	static void dfs(int x, int y) {
		vis1[x][y] = true;
		cnt++;
		sum += arr[x][y];
		for (int dir = 0; dir < 4; dir++) {
			int nr = x + dr[dir];
			int nc = y + dc[dir];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;

			// 인구의 차이가 L이상 R이하이면서 vis1이 false이면 dfs 재귀호출
			int diff = Math.abs(arr[x][y] - arr[nr][nc]);
			if (!vis1[nr][nc] && diff >= L && diff <= R) {
				dfs(nr, nc);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) {

			// 탈출조건 flag 초기화, vis1, vis2배열 생성
			flag = false;
			vis1 = new boolean[N][N];
			vis2 = new boolean[N][N];

			// 2중포문을 모두 탐색해야 하루동안 인구 이동이 진행된 것
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// vis1 = false라면 sum, cnt 초기화 후 dfs 호출
					if (!vis1[i][j]) {
						sum = 0;
						cnt = 0;
						dfs(i, j);

						// 이동해야할 지역이 1개라면 인구 이동을 할 필요가 없으므로
						// vis1을 다시 false로 바꿔주고 continue;
						if (cnt == 1) {
							vis1[i][j] = false;
							continue;
						}

						// 아니라면 인구가 이동하기 시작한다.
						else {
							for (int a = 0; a < N; a++) {
								for (int b = 0; b < N; b++) {

									// vis1 != vis2일 때 해당 지역에 인구를 적절히 배치
									// 다음 연합을 구할 때 겹치지 않게 하기 위해 vis2를 vis1과 같게 만들어준다
									if (vis1[a][b] != vis2[a][b]) {
										arr[a][b] = sum / cnt;
										vis2[a][b] = true;
									}
								}
							}
							flag = true; // 인구 이동이 됐으면 true
						}
					}
				}
			}

			// true이면 ans++
			// false 인구가 이동하지 않았으므로 종료
			if (flag)
				ans++;
			else
				break;
		}

		System.out.println(ans);
	}
}