import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, L;
	static int[][] arr;
	static boolean[] chk;
	static int ans;

	static void dfs(int x) {

		// x가 N이라면 모두 순회한 것
		// 칼로리가 L이하이면서 최대를 ans에 저장
		if (x == N) {
			int cal = 0;
			int score = 0;
			for (int i = 0; i < N; i++) {
				if (chk[i]) {
					score += arr[i][0];
					cal += arr[i][1];
				}
			}
			if (cal <= L) {
				ans = Math.max(ans, score);
			}
			return;
		}

		// 모든 부분집합을 선택
		chk[x] = true;
		dfs(x + 1);
		chk[x] = false;
		dfs(x + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			arr = new int[N][2];
			chk = new boolean[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			ans = 0;
			dfs(0);

			System.out.printf("#%d %d\n", t, ans);
		}
	}
}