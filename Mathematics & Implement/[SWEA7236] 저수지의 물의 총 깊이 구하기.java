import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			char[][] arr = new char[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = st.nextToken().charAt(0);
				}
			}

			// 2차원 배열 8방탐색할 배열
			int[] dx = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
			int[] dy = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };

			int max = 1; // 주위가 모두 G이어도 최솟값은 1
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int cnt = 0;
					if (arr[i][j] == 'G')
						continue;
					// W라면 8방탐색을 실시.
					for (int k = 0; k < 8; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						// 배열의 범위를 넘어가면 continue
						if (nx < 0 || nx >= n || ny < 0 || ny >= n)
							continue;
						// 주위가 W라면 cnt++
						if (arr[nx][ny] == 'W')
							cnt++;
					}
					// 저수지의 깊이를 최신화해준다
					if (max < cnt)
						max = cnt;
				}
			}
			System.out.printf("#%d %d\n", t, max);
		}
	}
}