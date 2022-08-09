import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] arr;

	static void binarySearch(int st, int end) {
		int mid = 0;
		// tmp를 m으로 지정
		// arr가 mid보다 작으면 해당 예산값(arr)을 tmp에서 빼준다
		// arr가 mid보다 크면 상한값(mid)을 tmp에서 빼준다
		while (st <= end) {
			int tmp = m;
			mid = (st + end) / 2;
			for (int i = 0; i < n; i++) {
				if (arr[i] <= mid) {
					tmp -= arr[i];
				} else {
					tmp -= mid;
				}

			}

			// 최종적으로 tmp < 0이면 예산의 상한값(mid)이 크다는 의미
			// -> mid를 낮춰준다.
			// tmp >= 0 이면 예산의 상한값(mid)이 작다는 의미
			// -> mid를 올려주며 m을 초과하지 않는 가장 큰 값을 찾아야 한다.
			if (tmp < 0) {
				end = mid - 1;
			} else {
				st = mid + 1;
			}
		}
		System.out.println(end);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}

		m = Integer.parseInt(br.readLine());

		// st = 0, end = max 로 이분탐색 시작
		// end값이 max인 이유 : max면 모든 지방의 요청된 예산만큼 모두 나눠줄 수 있음
		binarySearch(0, max);
	}
}
