import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	// 숫자가 뒤집어진 모습 함수 구현
	public static char mirror(int x) {
		if (x == 2) {
			return '5';
		} else if (x == 5) {
			return '2';
		} else if (x == 1) {
			return '1';
		} else if (x == 8) {
			return '8';
		}
		return '?';

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char W = st.nextToken().charAt(0);
		int N = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();
		// 왼쪽 혹은 오른쪽으로 뒤집어졌을 때
		if (W == 'L' || W == 'R') {
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					sb.append(mirror(arr[i][j])).append(" ");
				}
				sb.append("\n");
			}
		} 
		// 위 혹은 아래로 뒤집어졌을 때
		else {
			for (int i = N - 1; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					sb.append(mirror(arr[i][j])).append(" ");
				}
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}
}