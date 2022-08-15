import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int sum = 0; // 조망권이 확보된 세데의 수
			for (int i = 2; i <= n - 3; i++) {
				int max = 0;
				// 양 옆 두 칸까지의 max층을 구한다
				for (int j = -2; j <= 2; j++) {
					if (j == 0)
						continue;
					if (arr[i + j] > max) {
						max = arr[i + j];
					}
				}
				// 해달 빌딩이 좌우의 max값보다 크면 조망권을 얻음
				if (arr[i] > max)
					sum += arr[i] - max;
			}
			System.out.printf("#%d %d\n", t, sum);
		}
	}
}