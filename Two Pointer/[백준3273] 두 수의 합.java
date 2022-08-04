import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());

		Arrays.parallelSort(arr);

		// 양쪽 끝부터 연산 시작
		int left = 0;
		int right = n - 1;
		int sum = 0; // 두 수의 합
		int cnt = 0; // 갯수
		while (left < right) {
			sum = arr[left] + arr[right];
			// 한 칸씩 좁혀가면서 연산, 값이 같으면 cnt++
			if (sum == x) {
				cnt++;
				left++;
				right--;
			} else if (sum < x) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println(cnt);

	}

}
