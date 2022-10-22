import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] arr;
	static boolean[][] vis;
	static int[][] cnt;
	static Queue<Pos> water;
	static Queue<Pos> hedgehog;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int size;
	static int ans;

	// bfs함수 구현
	static void bfs() {
		// 고슴도치가 이동할 수 있을 때까지 반복
		while (!hedgehog.isEmpty()) {

			// 현재 water큐에 저장된 사이즈만큼 반복
			size = water.size();
			for (int i = 0; i < size; i++) {

				Pos cur = water.poll();

				for (int dir = 0; dir < 4; dir++) {
					int nr = cur.r + dr[dir];
					int nc = cur.c + dc[dir];

					// 다음으로 물이 퍼질 좌표가 경계값 벗어났으면 continue
					if (nr < 0 || nr >= R || nc < 0 || nc >= C)
						continue;

					// 물이 다음으로 퍼질 곳이 방문하지 않을 곳이며 평지라면
					// 해당 좌표를 큐에 넣어주고 배열을 물로 변경 후 방문처리
					if (!vis[nr][nc] && arr[nr][nc] == '.') {
						water.offer(new Pos(nr, nc));
						arr[nr][nc] = '*';
						vis[nr][nc] = true;
					}
				}
			}

			// 물을 한 번 이동시켰다면 고슴도치를 이동시킬 차례
			// 현재 hedgehog큐에 저장된 사이즈만큼 반복
			size = hedgehog.size();
			for (int i = 0; i < size; i++) {

				Pos cur = hedgehog.poll();

				for (int dir = 0; dir < 4; dir++) {
					int nr = cur.r + dr[dir];
					int nc = cur.c + dc[dir];
					int time = cnt[cur.r][cur.c];

					// 다음으로 고슴도치가 이동할 곳이 경계값 벗어났으면 continue
					if (nr < 0 || nr >= R || nc < 0 || nc >= C)
						continue;

					// 다음으로 고슴도치가 이동할 곳이 비버의 굴이라면
					// ans = 현재까지 이동한 시간 + 1
					if (arr[nr][nc] == 'D') {
						ans = time + 1;
						return;
					}

					// 이동하지 않아서 cnt값이 0이며 평지라면
					// 해당 좌표를 큐에 넣어주고 배열을 고슴도치로 변경 후 cnt배열에 이동한 시간을 저장
					if (cnt[nr][nc] == 0 && arr[nr][nc] == '.') {
						hedgehog.offer(new Pos(nr, nc));
						arr[nr][nc] = 'S';
						cnt[nr][nc] = time + 1;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C]; // 지도에 저장된 배열
		vis = new boolean[R][C]; // 물이 퍼졌는지 방문체크하는 배열
		cnt = new int[R][C]; // 고슴도치가 해당 좌표로 이동한 시간을 저장하는 배열
		water = new LinkedList<>(); // 물이 퍼진 좌표를 저장할 큐
		hedgehog = new LinkedList<>(); // 고슴도치가 이동한 좌표를 저장할 큐

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
				// 입력값이 물이라면 water큐에 넣어주고 이미 차있으므로 방문처리
				if (arr[i][j] == '*') {
					water.offer(new Pos(i, j));
					vis[i][j] = true;
				}
				// 입력값이 고슴도치라면 hedgehog큐에 넣어주기
				else if (arr[i][j] == 'S') {
					hedgehog.offer(new Pos(i, j));
				}
			}
		}

		bfs();

		// 고슴도치가 비버의 굴에 도착하지 못했다면 KAKTUS 출력
		// 도착했다면 ans값 출력
		if (ans == 0)
			System.out.println("KAKTUS");
		else
			System.out.println(ans);
	}

	// 좌표를 나타낼 클래스
	static class Pos {
		int r;
		int c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}