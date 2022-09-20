import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();

		// 0 : AND 연산
		// 1 : OR 연산
		// 2 : XOR 연산
		// 3 : NOT A
		// 4 : NOT B
		// 비트개수는 10만개
		int[][] arr = new int[5][100000];

		// 각각에 대한 연산 후 arr에 저장
		for (int i = 0; i < 100000; i++) {
			int x = a.charAt(i) - '0';
			int y = b.charAt(i) - '0';
			arr[0][i] = x & y;
			arr[1][i] = x | y;
			arr[2][i] = x ^ y;
			arr[3][i] = (x == 0) ? 1 : 0;
			arr[4][i] = (y == 0) ? 1 : 0;
		}
		
		// 스트링빌더에 저장
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 100000; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
