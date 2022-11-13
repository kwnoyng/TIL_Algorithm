import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Long[] arr = new Long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		// 내림차순 정렬
		Arrays.sort(arr, Comparator.reverseOrder());

		long res = 0;
		// 배열을 순회하며 1등부터 순서대로 줄 수 있는 팁을 계산
		// 줄 수 있는 팁이 음수라면 continue
		for (int i = 0; i < N; i++) {
			long tip = arr[i] - i;
			if (tip < 0)
				continue;
			res += tip;
		}

		System.out.println(res);
	}
}
