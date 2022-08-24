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
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] time = new int[11112];
			st = new StringTokenizer(br.readLine());
			// 해당 시간에 온 사람 cnt
			for (int i = 1; i <= n; i++) {
				int num = Integer.parseInt(st.nextToken());
				time[num]++;
			}

			String ans = "Possible";
			int bread = 0;
			for (int i = 0; i < time.length; i++) {

				// 붕어빵을 m초당 k개 만든다, 0초에는 만들지 않음
				if (i != 0 && i % m == 0) {
					bread += k;
				}
				// 해당 시간에 온 사람만큼 붕어빵을 빼준다
				bread -= time[i];

				// 만약 붕어빵이 음수라면 손님이 못 먹은 것
				if (bread < 0) {
					ans = "Impossible";
					break;
				}
			}

			System.out.printf("#%d %s\n", t, ans);
		}
	}
}
/*  다른 방법의 풀이
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] person = new int[n];
			for (int i = 0; i < n; i++) {
				person[i] = Integer.parseInt(st.nextToken());
			}

			// 손님이 온 시간을 입력받고 시간순으로 정렬
			// 해당 시간에 m만큼 나누고 k를 곱해준 만큼 빵을 만든다
			// 지금까지 빵을 가져간 사람 수를 뺀 게 0 이하면 나는 못 먹는다

			Arrays.sort(person);
			String ans = "Possible";
			for (int i = 0; i < n; i++) {
				int bread = (person[i] / m) * k;
				if (bread - i <= 0) {
					ans = "Impossible";
				}
			}

			System.out.printf("#%d %s\n", t, ans);
		}
	}
	*/
