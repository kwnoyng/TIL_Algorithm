import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][5];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			arr[i][3] = Integer.parseInt(st.nextToken());
			arr[i][4] = Integer.parseInt(st.nextToken());
		}

		// ans : 세 장의 카드를 골랐을 경우 합의 일의자리가 가장 큰 사람
		// max : 세 장의 카드를 골랐을 경우 합의 일의자리가 가장 큰 값
		int ans = 0;
		int max = 0;
		// 각 사람마다 반복하며
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			// 세 장의 카드를 모두 뽑는 경우의 수를 계산하며 cnt배열에 일의차리의 최댓값을 계산
			for (int x = 0; x < 3; x++) {
				for (int y = x + 1; y < 4; y++) {
					for (int z = y + 1; z < 5; z++) {
						int sum = arr[i][x] + arr[i][y] + arr[i][z];
						cnt = Math.max(cnt, sum % 10);
					}
				}
			}
			// cnt값이 기존 max값 이상이라면 max와 ans값 초기화
			if (max <= cnt) {
				max = cnt;
				ans = i;
			}
		}

		System.out.println(ans);
	}
}
