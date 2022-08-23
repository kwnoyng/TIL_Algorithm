import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 첫 번째로 핸드폰에 연결되면 배터리가 2 감소하므로 줄여주고 시작
		int battery = 98;
		int cnt = 2;
		for (int i = 1; i < arr.length; i++) {
			// 배터리가 100이라면 다시 처음으로 기기에 연결할 때 배터리 소모량은 2
			// 같은 기기랑 연결되면 소모량이 2배 증가
			// 다른 기기랑 연결되면 배터리 소모량은 2
			if (battery == 100) {
				cnt = 2;
				battery -= cnt;
			} else if (arr[i] == arr[i - 1]) {
				cnt *= 2;
				battery -= cnt;
			} else {
				cnt = 2;
				battery -= cnt;
			}

			// 배터리가 0이하로 떨어지면 충전시켜줘야 함
			if (battery <= 0) {
				battery = 100;
			}
		}

		// 현재의 배터리 소모량을 출력
		System.out.println(100 - battery);
	}
}
