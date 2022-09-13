import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static boolean flag;

	static void dfs(int x, int y, int cnt) {

		// flag == true면 return;
		if (flag)
			return;

		// cnt == 0 이면 스도쿠 완성이므로 스트링 빌더에 저장 후 출력
		// flag = true
		if (cnt == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			flag = true;
			return;
		}

		// 마지막 열까지 채웠으면 다음 행으로
		if (y == 9) {
			dfs(x + 1, 0, cnt);
			return;
		}

		// (x, y)가 0이라면
		// 1 ~ 9까지 순서대로 확인해서 값이 들어갈 수 있는지
		// chk해주고 가능(true)하다면 해당 값을 넣고
		// 다음 열, cnt는 하나 줄여준다
		if (arr[x][y] == 0) {
			for (int k = 1; k <= 9; k++) {
				if (chk(x, y, k)) {
					arr[x][y] = k;
					dfs(x, y + 1, cnt - 1);
					arr[x][y] = 0;
				}
			}
		} else {
			dfs(x, y + 1, cnt);
		}
	}

	// 해당 숫자를 넣는 것이 가능한지 확인하는 함수
	static boolean chk(int x, int y, int k) {
		// 해당 행과 열 확인, 같은 값이 있다면 false
		for (int i = 0; i < 9; i++) {
			if (arr[x][i] == k) {
				return false;
			}
			if (arr[i][y] == k) {
				return false;
			}
		}

		// 해당 3x3격자 확인, 같은 값이 있다면 false
		int r = 3 * (x / 3);
		int c = 3 * (y / 3);
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (arr[i][j] == k) {
					return false;
				}
			}
		}
		// 해당 행, 열, 3x3격자에 같은 숫자가 없다면 true
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9][9];
		int cnt = 0;
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0)
					cnt++;
			}
		}
		// 0, 0부터 dfs함수 시작
		dfs(0, 0, cnt);
	}
}
