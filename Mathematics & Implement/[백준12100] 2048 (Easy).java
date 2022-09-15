import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] arr1;
	static int[][] arr2;

	// 시계방향으로 90도 회전
	static void rotate() {
		int[][] tmp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = arr2[N - 1 - j][i];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr2[i][j] = tmp[i][j];
			}
		}
	}

	// dir이 0이면 왼쪽으로 기울이기
	// dir이 1이면 시계방향 90도 회전 후 왼쪽으로 기울이기 => 아래로 기울인 것과 동일
	// dir이 2이면 시계방향 180도 회전 후 왼쪽으로 기울이기 => 오른쪽으로 기울인 것과 동일
	// dir이 3이면 시계방향 270도 회전 후 왼쪽으로 기울이기 => 위로 기울인 것과 동일

	// 왼쪽으로 밀어 기울이기
	static void tilt(int dir) {
		// dir값만큼 시계방향으로 90도 회전
		while (dir-- > 0)
			rotate();
		// 각 행마다 왼쪽으로 기울임 구현
		for (int i = 0; i < N; i++) {
			int[] tilted = new int[N]; // 기울어진 값을 저장할 배열
			int idx = 0; // 기울어진 배열에 값을 저장할 idx

			for (int j = 0; j < N; j++) {
				// arr2값이 0이면 continue
				if (arr2[i][j] == 0)
					continue;
				// idx번째의 값이 0이면 arr2값 채우기
				// 값이 같다면 값을 합친 후 idx 증가
				// 값이 다르다면 idx 증가 후 arr2값 채우기
				if (tilted[idx] == 0)
					tilted[idx] = arr2[i][j];
				else if (tilted[idx] == arr2[i][j])
					tilted[idx++] *= 2;
				else
					tilted[++idx] = arr2[i][j];
			}
			// arr2의 i행에 기울어진 배열 복사
			for (int j = 0; j < N; j++)
				arr2[i][j] = tilted[j];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr1 = new int[N][N];
		arr2 = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr1[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0; // 최댓값 찾기
		// 4방향을 5번 기울이므로 4^5 = 1024만큼 반복
		for (int tmp = 0; tmp < 1024; tmp++) {
			
			// arr2에 원본 배열 복사
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr2[i][j] = arr1[i][j];
				}
			}

			// dir의 변화
			// 00000 - 10000 - 20000 - 30000 - 01000 - 11000 - 21000 - 31000 - ...
			int k = tmp;
			for (int i = 0; i < 5; i++) {
				int dir = k % 4;
				k /= 4;
				tilt(dir);
			}

			// 5번 기울인 후 max값 찾기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					max = Math.max(max, arr2[i][j]);
				}
			}
		}

		System.out.println(max);
	}
}
