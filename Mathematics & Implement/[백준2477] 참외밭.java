import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());

		// 행 : 동서남북 방향, 열 : 거리
		int[][] arr = new int[6][2];
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		int X = 0; // 최대 가로 길이
		int Y = 0; // 최대 세로 길이
		int idxX = 0; // 최대 가로 길이의 인덱스
		int idxY = 0; // 최대 세로 길이의 인덱스
		for (int i = 0; i < 6; i++) {
			if (arr[i][0] == 1 || arr[i][0] == 2) {
				if (X < arr[i][1]) {
					X = arr[i][1];
					idxX = i;
				}
			} else {
				if (Y < arr[i][1]) {
					Y = arr[i][1];
					idxY = i;
				}
			}
		}

		int minX = 0; // 빼줘야 할 밭의 가로 길이
		int minY = 0; // 빼줘야 할 밭의 세로 길이

		// 최대 가로 길이의 양 옆 세로 길이의 차이가 빼줘야 할 가로 길이
		// 동일하게 최대 세로 길이의 양 옆 가로 길이의 차이가 빼줘야 할 세로 길이
		// 반시계방향으로 순차적으로 입력되므로 idxX idxY의 바로 좌우 길이의 차이를 구해주면 됨
		if (idxX - 1 < 0) {
			minX = Math.abs(arr[idxX + 1][1] - arr[idxX + 6 - 1][1]);
		} else if (idxX + 1 >= 6) {
			minX = Math.abs(arr[idxX - 1][1] - arr[idxX + 1 - 6][1]);
		} else {
			minX = Math.abs(arr[idxX - 1][1] - arr[idxX + 1][1]);
		}
		if (idxY - 1 < 0) {
			minY = Math.abs(arr[idxY + 1][1] - arr[idxY + 6 - 1][1]);
		} else if (idxY + 1 >= 6) {
			minY = Math.abs(arr[idxY - 1][1] - arr[idxY + 1 - 6][1]);
		} else {
			minY = Math.abs(arr[idxY - 1][1] - arr[idxY + 1][1]);
		}

		int ans = ((X * Y) - (minX * minY)) * k;

		System.out.println(ans);
	}
}
