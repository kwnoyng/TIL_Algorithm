import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n;
	static int[][] arr;
	static int[][] R90Arr;
	static int[][] R180Arr;
	static int[][] R270Arr;

	// 시게방향 90도 회전
	static void R90() {
		R90Arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				R90Arr[j][n - 1 - i] = arr[i][j];
			}
		}
	}

	// 시게방향 180도 회전
	static void R180() {
		R180Arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				R180Arr[n - 1 - i][n - 1 - j] = arr[i][j];
			}
		}
	}

	// 시게방향 270도 회전
	static void R270() {
		R270Arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				R270Arr[n - 1 - j][i] = arr[i][j];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			R90();
			R180();
			R270();
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append("\n");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(R90Arr[i][j]);
				}
				sb.append(" ");
				for (int j = 0; j < n; j++) {
					sb.append(R180Arr[i][j]);
				}
				sb.append(" ");
				for (int j = 0; j < n; j++) {
					sb.append(R270Arr[i][j]);
				}
				sb.append("\n");
			}
			sb.delete(sb.length() - 1, sb.length());
			System.out.println(sb);
		}
	}
}
