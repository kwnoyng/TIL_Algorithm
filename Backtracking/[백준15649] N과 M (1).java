import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] arr;
	static boolean[] chk;

	static void dfs(int x) {
		// Basecase, x = m이면 배열이 모두 찼으므로 출력 후 리턴
		if (x == m) {
			for (int a : arr) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		// n번 순회, false면 방문하지 않았으므로 arr배열에 값을 넣고 true로 변경
		// 이후 재귀함수 호출
		for (int i = 0; i < n; i++) {
			if (!chk[i]) {
				arr[x] = i + 1;
				chk[i] = true;
				dfs(x + 1);
				chk[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		chk = new boolean[n];
		dfs(0);
	}
}
