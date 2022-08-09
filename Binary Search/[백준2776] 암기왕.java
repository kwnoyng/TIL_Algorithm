import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static int n, m;
	static int[] arr1;
	static int[] arr2;

	// Binary Search 구현
	static void binarySearch(int x) {
		int st = 0;
		int end = n - 1;
		int mid = 0;
		// arr2 원소의 값이 arr1배열에 존재하면 1
		while (st <= end) {
			mid = (st + end) / 2;
			if (arr1[mid] == x) {
				sb.append("1\n");
				return;
			} else if (arr1[mid] > x) {
				end = mid - 1;
			} else {
				st = mid + 1;
			}
		}
		// arr2 원소의 값이 arr1배열에 존재하지 않으면 0
		sb.append("0\n");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// TestCase 안에서 StringBuilder를 초기화시켜줘야함 (값이 계속 누적되는 걸 방지)
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			sb = new StringBuilder();
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr1 = new int[n];
			for (int i = 0; i < n; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}

			// arr1 정렬
			Arrays.sort(arr1);

			m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr2 = new int[m];
			for (int i = 0; i < m; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}

			// arr2배열의 원소를 하나씩 arr1배열 속에서 이분탐색 실시
			for (int i = 0; i < m; i++) {
				binarySearch(arr2[i]);
			}
			System.out.print(sb);
		}
	}

}

/**
 * Hash Set을 이용한 풀이
 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// Hash Set에 n개만큼 숫자를 저장
			HashSet<Integer> set = new HashSet<>();
			for (int i = 0; i < n; i++) {
				int x = Integer.parseInt(st.nextToken());
				set.add(x);
			}

			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			// 만약 입력된 값이 Set에 이미 저장된 원소라면 1 아니라면 0;
			for (int i = 0; i < m; i++) {
				int y = Integer.parseInt(st.nextToken());
				if (set.contains(y)) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			}
			System.out.print(sb);
		}
	}