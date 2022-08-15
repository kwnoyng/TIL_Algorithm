import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] swc = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			swc[i] = Integer.parseInt(st.nextToken());
		}
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 남학생 : 받은 수의 배수면 바꾼다
			if (x == 1) {
				int k = 1;
				while (y * k <= n) {
					swc[y * k] = Math.abs(swc[y * k] - 1);
					k++;
				}
			}
			// 여학생 : 받은 수를 중심으로 좌우가 대칭이면 바꾼다
			else if (x == 2) {
				swc[y] = Math.abs(swc[y] - 1);
				int k = 1;
				while ((y - k >= 1) && (y + k <= n) && (swc[y + k] == swc[y - k])) {
					swc[y + k] = Math.abs(swc[y + k] - 1);
					swc[y - k] = Math.abs(swc[y - k] - 1);
					k++;
				}
			}
		}
		for (int k = 1; k <= n; k++) {
			System.out.print(swc[k] + " ");
			if (k % 20 == 0) {
				System.out.println();
			}
		}
	}
}