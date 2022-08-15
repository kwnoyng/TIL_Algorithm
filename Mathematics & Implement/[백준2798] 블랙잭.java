import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;
		// 3중 포문으로 숫자 3개를 하나씩 차례차례 비교
		// sum이 m 이하면 ans를 지속적으로 최신화하면서
		// sum == m 혹은 m에 가장 가까운 값을 구하자
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					int sum = 0;
					sum += arr[i] + arr[j] + arr[k];
					if (sum <= m) {
						ans = Math.max(sum, ans);
					}
				}
			}
		}
		System.out.println(ans);
	}
}
