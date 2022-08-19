import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int l = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		boolean[] cake = new boolean[l + 1];
		int max = 0; // 가장 많이 받을 것으로 기대한 양
		int realMax = 0; // 실제로 가장 많이 받은 양
		int idx1 = 0; // 가장 많이 받을 것으로 기대한 사람의 번호
		int idx2 = 0; // 실제로 가장 많이 받은 사람의 번호
		int cnt = 0; // 실제로 받은 양
		for (int i = 0; i < n; i++) {
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			// 이론적으로는 k-p+1의 양이 가장 많이 받을 것으로 기대됨
			// k-p+1이 가장 큰 값을 구하고 해당 사람의 번호를 idx1에 저장
			if (k - p + 1 > max) {
				max = k - p + 1;
				idx1 = i + 1;
			}

			// 나눠주지 않은 케이크 조각 = false, 나눠준 케이크 조각 = true
			// 해당 범위에서의 false의 개수가 실제로 받은 케이크 조각의 양
			for (int j = p; j <= k; j++) {
				if (cake[j] == false) {
					cake[j] = true;
					cnt++;
				}
			}
			// cnt가 가장 클 때의 값을 구하고 해당 사람의 번호를 idx2에 저장
			if (realMax < cnt) {
				realMax = cnt;
				idx2 = i + 1;
			}
		}

		System.out.println(idx1);
		System.out.println(idx2);
	}
}
