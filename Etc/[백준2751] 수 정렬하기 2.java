import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int max = -1000001;
		int min = 1000001;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}

		// 숫자 범위 + 1의 크기의 카운트 배열을 만들고 카운트
		int[] num = new int[max - min + 1];
		for (int i = 0; i < n; i++) {
			num[arr[i] - min]++;
		}

		// 누적합 구하기
		for (int i = 1; i < num.length; i++) {
			num[i] += num[i - 1];
		}

		// 카운팅 정렬 (min만큼 다시 조정해주기)
		int[] tmp = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			tmp[--num[arr[i] - min]] = arr[i];
		}

		StringBuilder sb = new StringBuilder();
		for (int x : tmp)
			sb.append(x).append("\n");

		System.out.println(sb);
	}
}
