import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		// 삼각형의 결정 조건 x, y, z (z가 가장 큰 변)
		// z < x+y 일 경우 삼각형이 완성된다
		for (int i = N - 1; i >= 2; i--) {
			if (arr[i] < arr[i - 1] + arr[i - 2]) {
				System.out.println(arr[i] + arr[i - 1] + arr[i - 2]);
				return;
			}
		}
		System.out.println(-1);
	}
}
