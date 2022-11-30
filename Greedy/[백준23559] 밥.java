import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		// menu[맛][코스]
		int[][] menu = new int[N][2];
		int sum = 0;

		// 먼저 매일 1000원짜리 식사를 한다고 가정
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			menu[i][0] = Integer.parseInt(st.nextToken());
			menu[i][1] = Integer.parseInt(st.nextToken());
			sum += menu[i][1];
			X -= 1000;
		}

		// menu 배열을 정렬한다
		// 정렬 기준 : 오천원짜리 식사와 천원짜리 식사의 차이가 가장 큰 순서대로
		Arrays.sort(menu, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o2[0] - o2[1], o1[0] - o1[1]);
			}

		});

		// 남은 돈을 확인했을 때 오천원짜리 메뉴를 먹을 수 있으면 메뉴를 바꿔준다.
		for (int i = 0; i < N; i++) {
			// 천원짜리 메뉴가 더 비싸거나 돈을 더이상 사용할 수 없다면 break
			if (menu[i][1] > menu[i][0] || X < 0)
				break;
			// 사천원 이상 갖고있다면 오천원짜리 메뉴를 먹을 수 있음. (천원은 이미 지불)
			// 배열 정렬 순서대로 천원짜리 맛을 빼주고 오천원짜리 맛을 더해주고 사천원 추가 지불
			if (X >= 4000) {
				sum -= menu[i][1];
				sum += menu[i][0];
				X -= 4000;
			}
		}

		// 고른 메뉴의 맛의 최대 합
		System.out.println(sum);
	}
}
