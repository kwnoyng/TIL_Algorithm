import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[1005][1005];
		int a, b, c, d, cnt;
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			// 색종이 번호로 해당 색종이의 면적을 표시
			for (int j = b; j < b + d; j++) {
				for (int k = a; k < a + c; k++) {
					arr[j][k] = i;
				}
			}
		}

		// 해당 색종이의 번호의 갯수가 곧 색종이가 보이는 면적
		for (int i = 1; i <= n; i++) {
			cnt = 0;
			for (int j = 0; j < 1005; j++) {
				for (int k = 0; k < 1005; k++) {
					if (arr[j][k] == i)
						cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
