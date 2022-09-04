import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int k;
	static int[] arr;
	static int[] ans;

	static void dfs(int x, int idx) {
		// 6개를 뽑았다면 출력
		if (x == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
			return;
		}

		// 백트래킹 구현, S집합에서 숫자 6개를 뽑는 조합
		// 숫자를 뽑으면서 ans배열에 숫자를 넣어준다
		for (int i = idx; i < k; i++) {
			ans[x] = arr[i];
			dfs(x + 1, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 압력이 0일 때까지 반복
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0)
				return;
			arr = new int[k];
			ans = new int[k];
			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0);
			System.out.println();
		}
	}
}
