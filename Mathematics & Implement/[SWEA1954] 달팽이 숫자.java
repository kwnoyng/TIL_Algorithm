import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			// dir : 0 - 오른쪽, 1 - 아래, 2- 왼쪽, 3 - 위
			int dir = 0;
			// 1부터 넣어줄 숫자
			int cnt = 0;
			// 시작 위치
			int r = 0;
			int c = 0;
			// cnt가 n^2이 될 때까지 반복해서 2차원 배열에 숫자를 넣어준다
			while (cnt != n * n) {
				if (dir == 0) {
					if (c >= n || arr[r][c] != 0) {
						dir = (dir + 5) % 4;
						r++;
						c--;
						continue;
					}
					arr[r][c++] = ++cnt;
				} else if (dir == 1) {
					if (r >= n || arr[r][c] != 0) {
						dir = (dir + 5) % 4;
						r--;
						c--;
						continue;
					}
					arr[r++][c] = ++cnt;
				} else if (dir == 2) {
					if (c < 0 || arr[r][c] != 0) {
						dir = (dir + 5) % 4;
						r--;
						c++;
						continue;
					}
					arr[r][c--] = ++cnt;
				} else if (dir == 3) {
					if (r < 0 || arr[r][c] != 0) {
						dir = (dir + 5) % 4;
						r++;
						c++;
						continue;
					}
					arr[r--][c] = ++cnt;
				}
			}

			// 출력부
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append("\n");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}

			sb.delete(sb.length() - 1, sb.length());

			System.out.println(sb);
		}
	}
}
