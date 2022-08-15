import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		int[][] arr = new int[k][2];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int dist1 = 0;
		int dist2 = 0;
		int ans = 0;
		for (int i = 0; i < k; i++) {
			int cnt = 0;

			// 원점에서 상점까지의 거리,
			if (arr[i][0] == 1) {
				dist1 = arr[i][1];
			} else if (arr[i][0] == 2) {
				dist1 = n + m + (n - arr[i][1]);
			} else if (arr[i][0] == 3) {
				dist1 = n + m + n + (m - arr[i][1]);
			} else if (arr[i][0] == 4) {
				dist1 = n + arr[i][1];
			}
			// 원점에서 내 거리다
			if (a == 1) {
				dist2 = b;
			} else if (a == 2) {
				dist2 = n + m + (n - b);
			} else if (a == 3) {
				dist2 = n + m + n + (m - b);
			} else if (a == 4) {
				dist2 = n + b;
			}

			// 차이의 절대값(시계방향 / 반시계방향)
			int clock = Math.abs(dist1 - dist2);
			int counterClock = 2 * (n + m) - clock;

			// 최솟값
			cnt = Math.min(clock, counterClock);
			ans += cnt;
		}

		System.out.println(ans);
	}
}
