import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N; // 고객의 수
	static int[][] arr; // 고객의 좌표
	static boolean[] vis; // 방문 여부
	static int x1, y1, x2, y2; // 회사 좌표, 집 좌표
	static int ans;

	// dfs 구현
	static void dfs(int x, int dist, int curX, int curY) {

		// 거리가 이미 최솟값을 넘어갔으면 return (가지치기)
		if (dist > ans)
			return;

		// 모든 고객을 들렸다면 마지막 좌표에서 집으로 가는 거리를 더해주고 최솟값을 ans에 저장
		if (x == N) {
			dist += Math.abs(curX - x2) + Math.abs(curY - y2);
			ans = Math.min(ans, dist);
			return;
		}

		// N명의 고객들에게 방문
		for (int i = 0; i < N; i++) {
			// 이미 방문했다면 continue
			if (vis[i])
				continue;
			// true로 바꿔준 후 depth를 하나 늘리고 거리를 구해주고 현재 방문한 고객의 좌표를 저장
			vis[i] = true;
			dfs(x + 1, dist + Math.abs(curX - arr[i][0]) + Math.abs(curY - arr[i][1]), arr[i][0], arr[i][1]);
			vis[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][2];
			vis = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			ans = Integer.MAX_VALUE;
			dfs(0, 0, x1, y1);
			System.out.printf("#%d %d\n", t, ans);

		}
	}
}
