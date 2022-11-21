import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		// 현재 봉우리 활잡이
		// 최대 적 처치 수
		// 현재의 적 처치 수
		int now = arr[0];
		int max = 0;
		int cnt = 0;

		for (int i = 1; i < N; i++) {
			// 현재의 활잡이가 다음 봉우리의 적을 처치할 수 있으면 cnt++, max값 갱신
			if (now > arr[i]) {
				cnt++;
				max = Math.max(max, cnt);
			}
			// 현재의 활잡이가 다음 봉우리의 적을 처치할 수 없다면
			// 다음 봉우리의 활잡이를 현재의 활잡이로 교체 후 cnt = 0
			else {
				now = arr[i];
				cnt = 0;
			}
		}

		System.out.println(max);
	}
}
