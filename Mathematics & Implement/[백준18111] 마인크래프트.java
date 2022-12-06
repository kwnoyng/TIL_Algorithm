import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		// 입력을 받음과 동시에 땅의 최소 높이와 최대 높이를 저장
		int min = 500;
		int max = 0;
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}

		// x의 높이로 맞춘다.
		int time = 987654321;
		int height = 0;
		// x를 min부터 max까지 돌며 x값으로 땅의 높이를 맞춰준다.
		for (int x = min; x <= max; x++) {
			int cnt = 0;
			int block = B;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 만약 현재 땅의 높이가 x라면 continue
					if (map[i][j] == x)
						continue;
					// 현재 땅의 높이가 x보다 크다면
					// 땅의 차이만큼 블록을 빼고 인벤토리에 저장
					// 시간은 블록 1개당 2초씩 소모
					else if (map[i][j] > x) {
						int diff = map[i][j] - x;
						cnt += 2 * diff;
						block += diff;
					}
					// 현재 땅의 높이가 x보다 작다면
					// 땅의 차이만큼 블록에서 빼서 채워주고
					// 시간은 블록 1개당 1초씩 소모
					else if (map[i][j] < x) {
						int diff = x - map[i][j];
						cnt += diff;
						block -= diff;
					}
				}
			}
			// 모두 수행한 결과 블록이 0개 이상이라면 x의 높이로 땅을 성공적으로 맞췄음
			if (block >= 0) {
				// 시간의 최솟값과 땅의 높이를 구해준다
				// 시간의 최솟값이 여러개라면 땅의 높이가 가장 높은 것을 출력
				if (time >= cnt) {
					time = cnt;
					height = x;
				}
			}
		}

		System.out.println(time + " " + height);
	}
}
