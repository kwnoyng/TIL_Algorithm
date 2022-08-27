import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] arr = new int[N + M + 1];

			// N+1 ~ M+1까지의 카드가 가장 높은 확률
			int min = Math.min(1 + N, 1 + M);
			int max = Math.max(1 + N, 1 + M);

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for (int i = min; i <= max; i++)
				sb.append(i).append(" ");

			System.out.println(sb);
		}
	}
}
