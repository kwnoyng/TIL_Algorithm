import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final int P = 1234567891;

	// 페르마의 소정리에 의하면
	// nCr === n! * (r!(n-r)!)^(p-2)를 만족
	// 분할정복을 통한 거듭제곱을 계산
	static long rec(long N, long R) {
		if (R == 1)
			return N;

		long res = rec(N, R / 2) % P;

		if (R % 2 == 0)
			return (res * res) % P;
		else
			return ((res * res) % P * N) % P;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			// 팩토리얼을 저장할 배열 구현
			long[] factorial = new long[N + 1];
			factorial[1] = 1;
			for (int i = 2; i <= N; i++) {
				factorial[i] = (factorial[i - 1] * i) % P;
			}
			long ans = factorial[N] * rec(factorial[R] * factorial[N - R] % P, P - 2) % P;
			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
