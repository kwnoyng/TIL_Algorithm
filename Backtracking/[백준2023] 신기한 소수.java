import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static boolean[] prime;
	static boolean[] vis;
	static StringBuilder sb;

	static void dfs(int x, int num) {
		// 소수를 N자리까지 구했으면 스트링빌더에 저장
		if (x == N) {
			sb.append(num).append("\n");
			return;
		}

		// 1부터 9까지 뒤에 숫자를 이어붙인다
		for (int i = 1; i < 10; i++) {
			// 뒤에 이어붙일 숫자가 소수이면
			// 한 자리 늘려주고 dfs 재귀 호출
			if (isPrime(num * 10 + i)) {
				dfs(x + 1, num * 10 + i);
			}
		}
	}

	// num이 소수인지 판별
	// 2부터 제곱근까지 돌며 나누어지면 소수가 아니므로 false
	static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		sb = new StringBuilder();

		// 처음 올 수 있는 수는 2, 3, 5, 7이므로
		// 각 수를 첫 자리로 하는 dfs 함수 호출
		dfs(1, 2);
		dfs(1, 3);
		dfs(1, 5);
		dfs(1, 7);

		System.out.println(sb);
	}
}