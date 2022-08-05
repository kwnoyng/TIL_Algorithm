import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int[] arr;
	static int max, total;

	// max값과 total값 사이에서 이분탐색
	static void binarySearch() {
		int st = max;
		int end = total;
		while (st <= end) {
			int mid = (st + end) / 2;
			int sum = 0;
			int cnt = 0;
			// cnt는 돈을 인출한 횟수, mid는 인출한 금액, sum은 사용한 금액
			// 배열값을 하나씩 더해주면서 cnt를 늘린다.
			// 만약 sum이 mid보다 크면 인출을 또 해야한다. 그러므로 cnt++, sum 0으로 초기화
			// 다시 sum을 구하며 반복.
			for (int i = 0; i < n; i++) {
				if (sum + arr[i] > mid) {
					cnt++;
					sum = 0;
				}
				sum += arr[i];
			}
			// for문이 끝나고 남아있는 sum이 0이 아니라면 마지막으로 한번 더 인출해야하므로 cnt++
			if (sum != 0)
				cnt++;

			// 돈을 인출한 횟수가 m보다 크면 인출한 금액이 적다는 것을 의미
			// 인출한 횟수를 무조건 m이 되어야하며, cnt == m 을 만족하는 범위 중 가장 최솟값을 찾아야 함.
			// 그러므로 cnt > m일 경우 인출한 금액(mid)을 늘려 cnt를 줄여줄 필요가 있다
			// cnt < m 이면 cnt값을 m으로 맞춰야함 => 인출한 금액을 줄이면 된다
			// cnt == m 이라면 cnt == m을 만족하는 금액의 범위중에서 가장 최솟값을 찾아야 하므로 인출할 금액을 줄여준다.
			if (cnt > m) {
				st = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(st);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (max < arr[i]) {
				max = arr[i];
			}
			total += arr[i];
		}

		binarySearch();
	}

	// 이분탐색의 st를 배열의 max값, end를 배열의 total값으로 잡은 이유.
	// 만약 인출할 금액이 해당 날짜에 사용할 금액보다 적으면 그 금액을 사용할 수 없음. 이에 따라 가장 이분탐색의 시작범위를 max로.
	// 만약 인출할 금액이 total값이면 1일만에 모두 사용 가능. 이에 따라 이분탐색의 종료범위를 total로.
}
