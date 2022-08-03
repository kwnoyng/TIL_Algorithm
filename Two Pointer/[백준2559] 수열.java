import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0; // 누적합
		int i = 0;
		// 첫 번째 누적합을 구한 후 max값으로 지정
		for (i = 0; i < k; i++) {
			sum += arr[i];
		}
		int max = sum;

		// index 가장 오른쪽의 값은 더하고 왼쪽의 값은 빼며 누적합을 반복적으로 최신화 
		// sum이 max보다 크면 max값을 최신화
		while (i < n) {
			sum += arr[i];
			sum -= arr[i - k];
			if (sum >= max) {
				max = sum;
			}
			i++;
		}

		// 누적합의 max값을 출력
		System.out.println(max);
	}
}