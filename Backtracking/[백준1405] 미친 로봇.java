import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int K;
	static boolean[][] vis;
	static double[] heading;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static double sum;

	static void dfs(int r, int c, int x, double per) {

		// K번 이동했을 경우 해당 퍼센트를 누적해서 더해준다
		if (x == K) {
			sum += per;
			return;
		}

		// 동 서 남 북, 이동할 곳을 탐색
		for (int dir = 0; dir < 4; dir++) {
			// 이동할 곳의 확률이 %라면 continue
			if (heading[dir] == 0) {
				continue;
			}
			// 다음 좌표 설정
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			// 방문한 곳이 아니라면 true
			// 다음 좌표로 dfs함수 재귀호출, 이동횟수 증가, per에 이동할 확률을 누적
			// return되면 false로 바꿔주기
			if (!vis[nr][nc]) {
				vis[nr][nc] = true;
				dfs(nr, nc, x + 1, per * heading[dir]);
				vis[nr][nc] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		heading = new double[4];
		K = Integer.parseInt(st.nextToken());
		// 동 서 남 북으로 이동할 확률 입력 미 소숫점으로 변경
		for (int i = 0; i < 4; i++) {
			heading[i] = Integer.parseInt(st.nextToken());
			heading[i] /= 100;
		}

		// 좌표 설정 K의 최댓값이 14이므로 30크기의 배열 설정 후
		// 정중앙에서 이동 시작하므로 vis[15][15] = true
		// dfs함수 호출
		vis = new boolean[30][30];
		vis[15][15] = true;
		dfs(15, 15, 0, 1);

		System.out.println(sum);
	}
}
