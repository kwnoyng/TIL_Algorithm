import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 장신구를 만들 때 피로도를 오름차순 정렬
		Arrays.sort(arr);

		// 장신구를 만들 최대 개수
		int cnt = 0;

		// 현재의 피로도가 200이상이라면 장신구를 만들 수 없음
		// 199이하일 때까지 장신구를 만들 수 있음, 최대 n개만큼
		while (cnt < n && p <= 199) {
			p += arr[cnt++];
		}

		System.out.println(cnt);
	}
}
