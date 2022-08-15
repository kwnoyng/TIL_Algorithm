import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 세로축 확인
			int total = 0;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - m + 1; j++) {
					// 0 이면 지나갑니다 총총
					if (arr[i][j] == 0)
						continue;
					// 1이면...
					else {
						// m개의 칸 바로 상하 혹은 좌우를 확인한다 (딱 m개의 칸이어야하므로 상하 혹은 좌우는 0이거나 배열 범위를 벗어나야함)
						if ((j - 1 < 0 || arr[i][j - 1] == 0) && (j + m >= n || arr[i][j + m] == 0)) {
							// 상하 혹은 좌우를 닫은 채로 m개의 칸을 확보한 후 m번만큼 돌아서 모두 값이 1이면 cnt++
							for (int k = 0; k < m; k++) {
								if (arr[i][j + k] == 1)
									cnt++;
							}
						}
					}
					if (cnt == m)
						total++;
					cnt = 0;
				}
			}

			// 가로축 확인
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - m + 1; j++) {
					if (arr[j][i] == 0)
						continue;
					else {
						if ((j - 1 < 0 || arr[j - 1][i] == 0) && (j + m >= n || arr[j + m][i] == 0)) {
							for (int k = 0; k < m; k++) {
								if (arr[j + k][i] == 1)
									cnt++;
							}
						}
					}
					if (cnt == m)
						total++;
					cnt = 0;
				}
			}

			System.out.printf("#%d %d\n", t, total);
		}
	}
}
