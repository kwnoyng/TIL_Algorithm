import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());

			// 분리된 직사각형
			if (x2 > p1 || x1 > p2 || y1 > q2 || y2 > q1) {
				System.out.println('d');
			}
			// 꼭지점을 공유하는 걸친 직사각형
			else if ((x2 == p1 && (y2 == q1 || y1 == q2)) || (x1 == p2 && (y1 == q2 || y2 == q1))) {
				System.out.println('c');
			}
			// 변을 공유하는 직사각형
			else if (x2 == p1 || x1 == p2 || y1 == q2 || y2 == q1) {
				System.out.println('b');
			}
			// 공간을 공유하는 직사각형
			else {
				System.out.println('a');
			}
		}
	}
}
