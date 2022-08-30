import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = 5000000;
		// 에라토스테네스의 체를 활용하여 소수 구하기(소수 : true)
		boolean[] prime = new boolean[max + 1];
		for (int i = 2; i <= max; i++)
			prime[i] = true;
		for (int i = 2; i * i <= max; i++) {
			if (!prime[i])
				continue;
			for (int j = i * i; j <= max; j += i) {
				prime[j] = false;
			}
		}

		// N 이상인 수를 구하면 되므로 시작점을 N으로
		for (int i = N; i <= max; i++) {
			if (!prime[i])
				continue;
			String str = Integer.toString(i);
			boolean flag = true;
			for (int j = 0; j < str.length() / 2; j++) {
				if (str.charAt(j) != str.charAt(str.length() - 1 - j))
					flag = false;
			}
			// N보다 크면서 소수이면서 팰린드롬이면서 가장 최솟값을 출력하고 break
			if (flag) {
				System.out.println(i);
				break;
			}
		}
	}
}
