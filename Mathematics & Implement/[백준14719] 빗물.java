import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] height = new int[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		// 가장 왼쪽과 오른쪽 벽에는 물이 고일 수 없으므로 양쪽을 제외한 열을 탐색
		for (int i = 1; i < C - 1; i++) {
			int cur = height[i]; // 현재 벽 높이
			int left = cur; // 현재 기준 왼쪽 벽 최대 높이
			int right = cur; // 현재 기준 오른쪽 벽 최대 높이

			// 왼쪽과 오른쪽 벽 최대 높이 탐색
			for (int j = i - 1; j >= 0; j--) {
				left = Math.max(left, height[j]);
			}
			for (int j = i + 1; j < C; j++) {
				right = Math.max(right, height[j]);
			}

			// 현재 벽 보다 양쪽 벽이 더 높다면
			// 양쪽 벽의 최소 벽 높이에서 현재 벽 높이를 뺀 값만큼 빗물이 고인다.
			if (Math.min(left, right) > cur)
				cnt += Math.min(left, right) - cur;
		}

		System.out.println(cnt);
	}
}
