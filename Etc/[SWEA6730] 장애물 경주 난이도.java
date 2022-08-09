import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max = 0; // 오르막 난이도
			int min = 0; // 내리막 난이도
			// i와 i+1의 값 차이를 반복문을 통해 비교하면서 난이도를 구한다
			// 차이가 음수이면 오르막, 최댓값으로 최신화
			// 차이가 양수이면 내리막, 최댓값으로 최신화
			for (int i = 0; i < n - 1; i++) {
				if (arr[i] - arr[i + 1] <= 0) {
					max = Math.max(max, -(arr[i] - arr[i + 1]));
				} else if (arr[i] - arr[i + 1] > 0) {
					min = Math.max(min, arr[i] - arr[i + 1]);
				}
			}

			System.out.printf("#%d %d %d\n", t, max, min);
		}
	}
}
