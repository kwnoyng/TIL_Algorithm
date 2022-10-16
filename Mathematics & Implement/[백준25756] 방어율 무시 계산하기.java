import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] A = new double[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		// 초기 방어율은 0
		double V = 0;
		StringBuilder sb = new StringBuilder();
		// 반복문을 돌며 N번만큼 방어율을 최신화
		for (int i = 0; i < N; i++) {
			V = 1 - (1 - V) * (1 - A[i] / 100);
			sb.append(100 * V).append(' ');
		}

		System.out.println(sb);
	}
}