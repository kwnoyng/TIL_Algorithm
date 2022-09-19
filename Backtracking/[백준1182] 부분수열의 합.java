import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, S;
	static int[] arr;
	static boolean[] chk;
	static int cnt, ans;

	static void dfs(int x, int cnt) {
		if (x == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (chk[i])
					sum += arr[i];
			}
			// 부분집합의 개수가 0이 아니면서 합이 S인 경우
			if (cnt != 0 && sum == S) {
				ans++;
			}
			return;
		}

		// 부분수열 집합 구현
		chk[x] = true;
		dfs(x + 1, cnt + 1);
		chk[x] = false;
		dfs(x + 1, cnt);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		chk = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);

		System.out.println(ans);
	}
}

/*	비트마스킹 구현
 * 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		int cnt = 0;
		for (int i = 1; i < (1 << N); i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0)
					sum += arr[j];
			}
			if (sum == S)
				cnt++;
		}
	
		System.out.println(cnt);
	}
*/