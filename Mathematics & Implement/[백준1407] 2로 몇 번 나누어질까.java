import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	/*
	 * func : 1 ~ x까지 각 수의 약수 중 2의 거듭제곱 꼴이면서 가장 큰 약수들의 총 합
	 * func(10)이라면
	 * 초기에 10을 2로 나누었을 경우 그 몫 k = 5
	 * k개수만큼 2^0로 나누어진다.
	 * k개수만큼 재외한 갯수 5개를 2로 나누었을 때 몫 k = 3
	 * k개수만큼 2^1로 나누어진다.
	 * ...
	 * 즉 x가 10일 경우
	 * 2^0로 나누어지는 것은 5개
	 * 2^1로 나누어지는 것은 3개
	 * 2^2로 나누어지는 것은 1개
	 * 2^3로 나누어지는 것은 1개
	 */
	static long func(long x) {
		long sum = 0;
		long k = 0;
		long i = 1;
		while (x > 0) {
			if (x % 2 == 0)
				k = x / 2;
			else
				k = x / 2 + 1;

			sum += k * i;
			x -= k;
			i *= 2;
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		long ans = func(B) - func(A - 1);

		System.out.println(ans);
	}
}
