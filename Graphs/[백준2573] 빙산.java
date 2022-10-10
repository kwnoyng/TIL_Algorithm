import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] arr;
	static int[][] map;
	static boolean[][] vis;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int split;
	static int year;

	// 빙산이 몇 개로 분리되었는지 확인하는 dfs함수
	static void dfs(int r, int c) {
		vis[r][c] = true;

		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;
			if (!vis[nr][nc] && map[nr][nc] != 0)
				dfs(nr, nc);
		}
	}

	// 빙산을 녹이는 melt함수
	static void melt() {
		// 2중포문을 돌면서 빙산이 존재한다면(0이 아니라면)
		// arr배열을 4방탐색하여 0을 cnt해주고 map에 cnt값을 빼줌
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					int cnt = 0;
					for (int dir = 0; dir < 4; dir++) {
						int nr = i + dr[dir];
						int nc = j + dc[dir];

						if (nr < 0 || nr >= N || nc < 0 || nc >= M)
							continue;
						if (arr[nr][nc] == 0)
							cnt++;
					}
					map[i][j] -= cnt;
					// map이 음수가 되면 0으로 바꿔주기
					if (map[i][j] < 0)
						map[i][j] = 0;
				}
			}
		}

		// 빙산을 녹이고 난 후 arr배열을 map배열로 복사해준다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = map[i][j];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		map = new int[N][M];

		// arr에 입력을 받아주고 초기 map에 arr배열의 값을 넣어준다
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = arr[i][j];
			}
		}

		while (true) {
			// 새로운 vis배열, split 초기화
			// dfs 돌면서 나누어진 구역이 몇 구역인지 확인
			vis = new boolean[N][M];
			split = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!vis[i][j] && map[i][j] != 0) {
						split++;
						dfs(i, j);
					}
				}
			}

			// 나누어진 구역이 0이라면 break
			// 나누어진 구역이 1이라면 melt함수 호출, 빙산이 녹으며 year++
			// 나누어진 구역이 2 이상이라면 break
			if (split == 0) {
				System.out.println(0);
				break;
			} else if (split == 1) {
				melt();
				year++;
			} else {
				System.out.println(year);
				break;
			}
		}
	}
}