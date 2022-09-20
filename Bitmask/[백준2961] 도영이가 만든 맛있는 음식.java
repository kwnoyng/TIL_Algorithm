import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][2];

		// 0 : 신 맛, 1 : 쓴 맛
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		int min = Integer.MAX_VALUE;
		// 비트마스킹 구현
		// 적어도 1개의 재료를 사용해야하므로 i는 1부터 시작
		for (int i = 1; i < (1 << N); i++) {
			int x = 1; // 신 맛의 곱
			int y = 0; // 쓴 맛의 합

			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					x *= arr[j][0];
					y += arr[j][1];
				}
			}
			// 신 맛과 쓴 맛의 차이가 최소가 되어야 함
			int diff = Math.abs(x - y);
			min = Math.min(min, diff);
		}

		System.out.println(min);
	}
}
