import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, k;
	static int[] arr;
	static boolean[] chk;
	static int cnt;

	static void dfs(int x) {

		// x가 n이면 모두 순회한 것
		// 부분집합의 합이 k라면 cnt++
		if (x == n) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (chk[i])
					sum += arr[i];
			}
			if (sum == k) {
				cnt++;
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
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n];
			chk = new boolean[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			cnt = 0;
			dfs(0);
			System.out.printf("#%d %d\n", t, cnt);
		}
	}
}
