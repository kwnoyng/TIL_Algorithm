import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[100][100];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// board를 x ~ x+10까지 y ~ y+10까지 1로 만듬
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					board[j][k] = 1;
				}
			}

		}

		// 넓이 = board에 저장된 총 1의 갯수
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				sum += board[i][j];
			}
		}
		System.out.println(sum);
	}
}