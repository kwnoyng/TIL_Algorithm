import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	static int n, m;
	static int[] arr;

	static int binarySearch(int st, int end) {
		while (st <= end) {
			int mid = (st + end) / 2;
			int sum = 0;
			int cnt = 0;
			// 배열을 하나씩 더해주고 mid값보다 크면 cnt 늘려주기, sum은 0으로 초기화
			for (int i = 0; i < n; i++) {
				if (sum + arr[i] > mid) {
					sum = 0;
					cnt++;
				}
				sum += arr[i];
			}
			if (sum > 0)
				cnt++;

			// cnt가 정해진 블루레이의 수인 m보다 크면 st를 늘리고 같거나 작으면 end를 줄인다
			// cnt == m이며 최소를 블루레이 크기를 찾기 위함
			if (cnt <= m) {
				end = mid - 1;
			} else {
				st = mid + 1;
			}
		}
		return st;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];

		int total = 0; // arr배열의 총 합계
		int max = 0; // arr배열의 max값
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
			if (arr[i] > max)
				max = arr[i];
		}

		// binaySearch를 진행할 범위, st = max, end = total
		int ans = binarySearch(max, total);
		System.out.println(ans);
	}
}
