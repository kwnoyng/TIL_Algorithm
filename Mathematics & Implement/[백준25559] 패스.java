import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		// 1일때 예외처리
		if (N == 1) {
			System.out.println(1);
		}
		// 홀수라면 -1
		else if (N % 2 == 1) {
			System.out.println(-1);
		}
		// 짝수라면
		// N -> 1 -> N-2 -> 3 -> N-4 -> 5 ...
		// N이 중간에 올 경우 공을 받는 횟수는 2번이 되므로 N이 무조건 처음에 와야한다
		else {
			for (int i = N; i >= 1; i--) {
				if (i % 2 == 0) {
					sb.append(i).append(" ");
				} else {
					sb.append(N - i).append(" ");
				}
			}
			System.out.println(sb);
		}
	}
}
