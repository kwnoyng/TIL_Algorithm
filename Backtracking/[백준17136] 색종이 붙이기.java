import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int[] size = { 0, 5, 5, 5, 5, 5 }; // 1x1 ~ 5x5 까지 색종이의 개수
	static int ans;

	static void dfs(int r, int c) {
		// 마지막 행과 열을 모두 돌았으면 색종이를 모두 몇 장 사용했는지 구해준다
		if (r == 9 && c == 10) {
			int sum = 0;
			for (int i = 1; i <= 5; i++) {
				sum += 5 - size[i];
			}
			ans = Math.min(ans, sum);
			return;
		}
		// 마지막 열을 돌았으면 그 다음행 0열로 dfs함수 호출
		if (c == 10) {
			dfs(r + 1, 0);
			return;
		}
		// 1을 발견했다면
		if (arr[r][c] == 1) {
			// 1x1의 색종이부터 차례대로 덮어보기
			for (int k = 1; k <= 5; k++) {
				// 색종이를 붙일 수 있으면서, 해당 크기의 색종이가 개수가 남는다면
				if (isPossible(r, c, k) && size[k] != 0) {
					colorPaper(r, c, k);
					size[k]--;
					dfs(r, c + 1);
					colorPaper(r, c, k);
					size[k]++;
				}
			}
		} else {
			dfs(r, c + 1);
		}
	}

	// kxk의 색종이를 붙일 수 있는지 판단
	static boolean isPossible(int r, int c, int k) {
		for (int i = r; i < r + k; i++) {
			for (int j = c; j < c + k; j++) {
				if (i >= 10 || j >= 10 || arr[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	// 색종이를 붙였다면 0으로 바꿔주고
	// 붙인 색종이를 제거했으면 다시 1로 바꿔주기
	static void colorPaper(int r, int c, int k) {
		for (int i = r; i < r + k; i++) {
			for (int j = c; j < c + k; j++) {
				arr[i][j] = (arr[i][j] == 1) ? 0 : 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[10][10];
		int cnt = 0;
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 500;
		dfs(0, 0);
		if (ans == 500)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
}
