import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int a, b; // A, B 배열의 크기

			// n이 홀수일 경우를 고려한 배열의 크기 설정
			if (n % 2 == 1) {
				a = n / 2 + 1;
				b = n / 2;
			} else {
				a = n / 2;
				b = n / 2;

			}
			String[] A = new String[a];
			String[] B = new String[b];

			// 절반은 A배열에 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < a; i++) {
				A[i] = st.nextToken();
			}
			// 나머지 절반은 B배열에 입력
			for (int i = 0; i < b; i++) {
				B[i] = st.nextToken();
			}

			// n/2번만큼 번갈아서 스트링빌더에 저장
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n / 2; i++) {
				sb.append(A[i]).append(" ");
				sb.append(B[i]).append(" ");
			}
			// 홀수라면 A배열의 마지막값까지 저장
			if (n % 2 == 1)
				sb.append(A[a - 1]);

			System.out.printf("#%d %s\n", t, sb);
		}
	}
}
