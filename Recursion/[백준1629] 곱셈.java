import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long A, B, C;

	static long rec(long a, long b, long m) {
		// base condition
		if (b == 1)
			return a % m;
		// n/2제곱을 계산하고 val을 제곱
		long val = rec(a, b / 2, m);
		val = val * val % m;

		// 만약 b가 짝수이면 val을 반환
		// 홀수이면 a를 한번 더 곱하고 mod m을 반환
		if (b % 2 == 0)
			return val;
		return val * a % m;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		System.out.println(rec(A, B, C));
	}
}
