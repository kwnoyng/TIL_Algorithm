import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	/*
	 * O(N)의 풀이
	 * an = (-1)^d1 + (-1)^d2 + ... + (-1)^dk
	 * a1 + a2 + ... + an = (-1)^i*(n/i) (i : 1 ~ n까지)의 합
	 */
	static int func(int x) {
		int sum = 0;
		for (int i = 1; i <= x; i++) {
			if (i % 2 == 1) {
				sum -= x / i;
			} else {
				sum += x / i;
			}
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int ans = func(T) - func(S - 1);

		System.out.println(ans);
	}
}
