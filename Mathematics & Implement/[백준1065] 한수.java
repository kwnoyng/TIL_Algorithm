import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		// 1부터 N까지 한수인지 비교
		for (int i = 1; i <= N; i++) {
			int tmp = i;
			boolean flag = true;
			// 일의자리와 십의자리 숫자의 차이를 저장
			int diff = tmp % 10 - (tmp / 10) % 10;
			// tmp가 일의자리일 경우 십의자리와 비교할 수 없으므로 10 이상까지만 비교
			while (tmp >= 10) {
				// 일의자리와 십의자리 숫자의 차이를 계속 비교해서 diff가 아니면 등차수열이 아님
				if (tmp % 10 - (tmp / 10) % 10 != diff) {
					flag = false;
					break;
				}
				// tmp를 10으로 나눠줌
				tmp /= 10;
			}
			if (flag)
				cnt++;
		}

		System.out.println(cnt);
	}
}
