import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n; // 상근이의 카드 갯수
	static int[] card; // 상근이의 카드 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		card = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(card); // 상근이 카드 오름차순 정렬

		// m번만큼 숫자를 입력받고 BinarySearch 진행
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			System.out.print(BinarySearch(num) + " ");
		}
	}

	// BinarySearch 구현
	static int BinarySearch(int x) {
		int st = 0;
		int end = n - 1;

		while (st <= end) {
			int mid = (st + end) / 2;

			if (x < card[mid]) {
				end = mid - 1;
			} else if (x > card[mid]) {
				st = mid + 1;
			} else
				return 1;
		}
		return 0;
	}
}
