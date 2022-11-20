import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++)
			arr[i] = Integer.parseInt(br.readLine());

		int ans = 0;
		// 순서대로 10개의 버섯을 먹는다
		for (int i = 0; i < 10; i++) {
			ans += arr[i];
			// 만약 점수가 100을 넘었다면 현재까지 먹은 것과 이전까지 먹은 것을 비교
			if (ans > 100) {
				// 현재까지 먹은 점수와 100의 차이의 절댓값이 이전까지 먹은 점수와 100의 차이의 절댓값보다 작거나 같다면
				// 현재까지 먹은 것이 정답
				if (Math.abs(ans - 100) <= Math.abs(ans - arr[i] - 100)) {
					break;
				}
				// 이전까지 먹은 점수와 100의 차이의 절댓값이 더 작다면
				// 이전까지 먹은 것이 정답
				else {
					ans -= arr[i];
					break;
				}
			}
		}

		System.out.println(ans);
	}
}
