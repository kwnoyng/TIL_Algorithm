import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, m;
	static int[][] arr;
	static int max, cnt1, cnt2; // cnt1 : +스프레이 , cnt2 : x스프레이
	// +로 탐색
	static int[] dr1 = { -1, 1, 0, 0 };
	static int[] dc1 = { 0, 0, -1, 1 };
	// x로 탐색
	static int[] dr2 = { -1, -1, 1, 1 };
	static int[] dc2 = { -1, 1, -1, 1 };

	// +로 스프레이가 분사
	static int first(int x, int y) {
		// 스프레이를 뿌린 곳을 먼저 cnt
		cnt1 += arr[x][y];
		// +로 m의 범위만큼 탐색하며 cnt에 누적
		for (int i = 1; i < m; i++) {
			for (int dir = 0; dir < 4; dir++) {
				int nr = x + dr1[dir] * i;
				int nc = y + dc1[dir] * i;

				if (nr < 0 || nr >= n || nc < 0 || nc >= n)
					continue;
				cnt1 += arr[nr][nc];
			}
		}
		return cnt1;
	}

	// x로 스프레이가 분사
	static int second(int x, int y) {
		// 스프레이를 뿌린 곳을 먼저 cnt
		cnt2 += arr[x][y];
		// x로 m의 범위만큼 탐색하며 cnt에 누적
		for (int i = 1; i < m; i++) {
			for (int dir = 0; dir < 4; dir++) {
				int nr = x + dr2[dir] * i;
				int nc = y + dc2[dir] * i;

				if (nr < 0 || nr >= n || nc < 0 || nc >= n)
					continue;
				cnt2 += arr[nr][nc];
			}
		}

		return cnt2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 매 테스트케이스마다 max값 최신화
			max = 0;

			// 2차원배열을 순회하며 최댓값을 찾는다
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cnt1 = 0;
					cnt2 = 0;
					max = Math.max(max, first(i, j));
					max = Math.max(max, second(i, j));
				}
			}

			System.out.printf("#%d %d\n", t, max);
		}
	}
}
