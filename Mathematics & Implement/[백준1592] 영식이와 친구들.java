import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] arr = new int[n + 1];
		int idx = 1;
		arr[idx]++;
		int cnt = 0;

		while (true) {
			if (arr[idx] == m) {
				System.out.println(cnt);
				break;
			}
			// 공 받은 횟수가 홀수번 = 시계방향으로 L
			if (arr[idx] % 2 != 0) {
				if (idx + l > n) {
					idx = idx + l - n;
					arr[idx]++;

				} else {
					idx = idx + l;
					arr[idx]++;
				}
			}
			// 공 받은 횟수가 짝수번 = 반시계방향으로 L
			else {
				if (idx - l < 1) {
					idx = idx - l + n;
					arr[idx]++;
				} else {
					idx = idx - l;
					arr[idx]++;
				}
			}

			cnt++;
		}
	}

}
