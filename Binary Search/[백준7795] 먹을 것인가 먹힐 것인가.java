import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] arrN;
	static int[] arrM;

	// arrN배열의 원소값을 하나씩 arrM배열에서 이분탐색을 실시
	// arrN배열의 원소가 arrM의 원소보다 크면 cnt = mid+1로 최신화
	static int binarySearch() {
		int res = 0; // 먹을 수 있는 총 쌍의 개수

		// arrN의 원소갯수(n번)만큼 순회
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			int st = 0;
			int end = m - 1;
			int mid = (st + end) / 2;
			while (st <= end) {
				mid = (st + end) / 2;
				if (arrN[i] > arrM[mid]) {
					cnt = mid + 1; // mid+1개가 arrN[i]의 원소보다 작으므로.
					st = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			res += cnt;
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arrN = new int[n];
			arrM = new int[m];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arrN[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				arrM[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arrM); // arrM 배열 오름차순 정렬

			System.out.println(binarySearch());
		}
	}
}