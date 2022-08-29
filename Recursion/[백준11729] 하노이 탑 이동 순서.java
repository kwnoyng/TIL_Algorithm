import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb = new StringBuilder();

	// a : 시작, b : 도착
	static void rec(int a, int b, int n) {

		// base condition
		if (n == 1) {
			sb.append(a).append(" ").append(b).append("\n");
			return;
		}

		// n-1개의 원판을 a에서 6-a-b로 옮긴다
		// n번 원판을 a에서 b로 옮긴다
		// n-1개의 원판을 6-a-b에서 b로 옮긴다
		rec(a, 6 - a - b, n - 1);
		sb.append(a).append(" ").append(b).append("\n");
		rec(6 - a - b, b, n - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sb.append((1 << N) - 1).append("\n");
		rec(1, 3, N);
		System.out.println(sb);
	}
}
