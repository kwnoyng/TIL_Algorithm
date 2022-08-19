import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while (n-- > 0) {
			// A와 B 다섯 칸짜리 배열을 만들어서 1 ~ 4가 몇 번씩 들어왔는지 표시
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int[] A = new int[5];
			for (int i = 0; i < a; i++) {
				int x = Integer.parseInt(st.nextToken());
				A[x]++;
			}
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int[] B = new int[5];
			for (int i = 0; i < b; i++) {
				int x = Integer.parseInt(st.nextToken());
				B[x]++;
			}

			// 초기 답을 D로 설정, 4부터 하나씩 비교해가며 답을 최신화
			// 4의 갯수가 A가 더 많다면 ans = A, B가 더 많다면 ans = B, 동일하다면 3 2 1 순으로 내려감
			// 모든 것이 동일하면 최종 정답은 초깃값 D
			char ans = 'D';
			for (int i = 4; i >= 1; i--) {
				if (A[i] > B[i]) {
					ans = 'A';
					break;
				} else if (A[i] < B[i]) {
					ans = 'B';
					break;
				}
			}
			System.out.println(ans);
		}
	}
}
