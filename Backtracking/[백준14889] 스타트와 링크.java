import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[] vis;
	static int min = Integer.MAX_VALUE;

	static void dfs(int x, int idx) {

		// 사람들을 절반으로 나누었다면(팀을 구성했다면)
		if (x == N / 2) {
			int S = 0;
			int L = 0;
			// 스타트팀이라면 S에 팀의 능력치를 모두 더해주고
			// 링크팀이라면 L에 팀의 능력치를 모두 더해주고
			// 차이의 최솟값을 구한다
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (vis[i] && vis[j]) {
						S += arr[i][j];
					} else if (!vis[i] && !vis[j]) {
						L += arr[i][j];
					}
				}
			}
			min = Math.min(min, Math.abs(S - L));
			return;
		}

		// 백트래킹으로 팀의 조합을 구한다
		// true : 스타트팀, false : 링크팀
		for (int i = idx; i < N; i++) {
			vis[i] = true;
			dfs(x + 1, i + 1);
			vis[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		vis = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		System.out.println(min);
	}
}
