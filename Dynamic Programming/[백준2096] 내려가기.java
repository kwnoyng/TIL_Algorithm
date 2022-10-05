import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dpMax = new int[2][3];
		int[][] dpMin = new int[2][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			// 최댓값 구하기
			dpMax[1][0] = Math.max(dpMax[0][0], dpMax[0][1]) + x;
			dpMax[1][1] = Math.max(Math.max(dpMax[0][0], dpMax[0][1]), dpMax[0][2]) + y;
			dpMax[1][2] = Math.max(dpMax[0][1], dpMax[0][2]) + z;

			dpMax[0][0] = dpMax[1][0];
			dpMax[0][1] = dpMax[1][1];
			dpMax[0][2] = dpMax[1][2];

			// 최솟값 구하기
			dpMin[1][0] = Math.min(dpMin[0][0], dpMin[0][1]) + x;
			dpMin[1][1] = Math.min(Math.min(dpMin[0][0], dpMin[0][1]), dpMin[0][2]) + y;
			dpMin[1][2] = Math.min(dpMin[0][1], dpMin[0][2]) + z;

			dpMin[0][0] = dpMin[1][0];
			dpMin[0][1] = dpMin[1][1];
			dpMin[0][2] = dpMin[1][2];
		}

		int max = Math.max(Math.max(dpMax[0][0], dpMax[0][1]), dpMax[0][2]);
		int min = Math.min(Math.min(dpMin[0][0], dpMin[0][1]), dpMin[0][2]);
		System.out.println(max + " " + min);
	}
}