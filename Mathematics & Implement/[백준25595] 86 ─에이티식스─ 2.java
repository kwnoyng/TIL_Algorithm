import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][N];
		// 현재 신에이 노우젠의 위치
		int r = 0;
		int c = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					r = i;
					c = j;
				}
			}
		}

		// 대각선으로밖에 움직이지 못하므로
		// 같은 대각선에 레기온이 있다면 해치울 수 없음
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ((i + j) % 2 == (r + c) % 2 && arr[i][j] == 1) {
					System.out.println("Kiriya");
					return;
				}
			}
		}
		System.out.println("Lena");
	}
}
