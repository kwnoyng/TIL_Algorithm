import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {

			int n = Integer.parseInt(br.readLine());

			int a, b; // 입력 커맨드, 가속도의 값
			int d = 0; // 이동 거리
			int v = 0; // 현재 속도

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());

				// 현재 속도 유지라면, 1초동안 현재 속도만큼 거리 이동
				if (a == 0) {
					d += v;
				}
				// 가속이라면, 현재 속도에서 1초동안 가속된 속도만큼 속도 향상
				// 향상된 속도만큼 거리 이동
				else if (a == 1) {
					b = Integer.parseInt(st.nextToken());
					v += b;
					d += v;
				}
				// 감속이라면, 현재 속도에서 1초동안 가속된 속도만큼 속도 감속
				// 향상된 속도만큼 거리 이동
				else if (a == 2) {
					b = Integer.parseInt(st.nextToken());
					// 현재 속도보다 감속할 속도가 더 크면 속도는 0
					if (v < b)
						v = 0;
					else
						v -= b;
					d += v;
				}
			}

			System.out.printf("#%d %d\n", t, d);
		}
	}
}
