import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int startX, startY; // 시작 좌표
	static int x, y; // 현재 좌표
	static int prevX, prevY; // 이전 좌표

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] arr = new boolean[6][6];
		String str = br.readLine();
		// 시작 좌표를 true로 변경
		startX = str.charAt(1) - '0' - 1;
		startY = str.charAt(0) - 'A';
		arr[startX][startY] = true;
		// 이전 좌표를 갱신
		prevX = startX;
		prevY = startY;

		// 첫 번째 좌표는 이미 처리했으므로 35번만 수행
		for (int i = 0; i < 35; i++) {
			str = br.readLine();
			// x, y는 현재 좌표
			x = str.charAt(1) - '0' - 1;
			y = str.charAt(0) - 'A';
			// 이미 방문했다면 Invalid
			if (arr[x][y]) {
				System.out.println("Invalid");
				return;
			}
			// 나이트가 이동할 수 없는 곳이라면 Invalid
			if (!((Math.abs(x - prevX) == 2 && Math.abs(y - prevY) == 1)
					|| (Math.abs(x - prevX) == 1 && Math.abs(y - prevY) == 2))) {
				System.out.println("Invalid");
				return;
			}
			// 그게 아니라면 true로 변경해주고 이전 좌표를 갱신
			arr[x][y] = true;
			prevX = x;
			prevY = y;
		}
		// 마지막 좌표가 시작 좌표로 이동할 수 없다면 Invalid
		if (!((Math.abs(startX - prevX) == 2 && Math.abs(startY - prevY) == 1)
				|| (Math.abs(startX - prevX) == 1 && Math.abs(startY - prevY) == 2))) {
			System.out.println("Invalid");
			return;
		}
		System.out.println("Valid");
	}
}