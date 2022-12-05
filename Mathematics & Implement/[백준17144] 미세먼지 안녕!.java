import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T;
	static int[][] map;
	static Queue<Pos> dust;
	static int top, bottom;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 맵을 돌면서 미세먼지가 존재하면 큐에 넣는다.
	static void chkDust() {
		dust = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					dust.offer(new Pos(i, j, map[i][j]));
				}
			}
		}
	}

	// 미세먼지를 사방으로 퍼트린다.
	static void spreadOfDust() {
		while (!dust.isEmpty()) {
			Pos cur = dust.poll();
			int cnt = 0;
			for (int dir = 0; dir < 4; dir++) {
				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];

				// 경계값이 벗어나거나 공기청정기가 있을 경우 continue
				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;
				if (map[nr][nc] == -1)
					continue;

				// 인접한 칸의 미세면지 양을 갱신 후 cnt++
				map[nr][nc] += cur.quantity / 5;
				cnt++;
			}

			// 현재 칸의 미세먼지 양을 갱신
			map[cur.r][cur.c] -= (cur.quantity / 5) * cnt;
		}
	}

	// 공기청정기를 가동시킨다.
	static void oprateAirCleaner() {
		// 공기청정기의 윗부분 : 반시계방향으로 작동
		for (int i = top - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i + 1];
		}
		for (int i = 0; i < top; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}
		for (int i = C - 1; i > 0; i--) {
			map[top][i] = map[top][i - 1];
		}
		map[top][1] = 0;

		// 공기청정기의 아래부분 : 시계방향으로 작동
		for (int i = bottom + 1; i < R - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		for (int i = 0; i < C - 1; i++) {
			map[R - 1][i] = map[R - 1][i + 1];
		}
		for (int i = R - 1; i > bottom; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}
		for (int i = C - 1; i > 0; i--) {
			map[bottom][i] = map[bottom][i - 1];
		}
		map[bottom][1] = 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 공기청정기의 좌표를 나타낼 top과 bottom을 저장해준다.
				if (map[i][j] == -1) {
					if (top == 0) {
						top = i;
					} else {
						bottom = i;
					}
				}
			}
		}

		// T초만큼 수행
		while (T-- > 0) {
			chkDust();
			spreadOfDust();
			oprateAirCleaner();
		}

		// T초가 지난 후 방에 남은 미세먼지를 합산
		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					ans += map[i][j];
			}
		}

		System.out.println(ans);

	}

	static class Pos {
		int r;
		int c;
		int quantity;

		Pos(int r, int c, int quantity) {
			this.r = r;
			this.c = c;
			this.quantity = quantity;
		}
	}
}
