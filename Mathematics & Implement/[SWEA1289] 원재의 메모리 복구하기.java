import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String memory = br.readLine();
			boolean chk = false; // 0이면 false, 1이면 true, 초기값은 0임
			int cnt = 0; // 최소 조정 횟수

			for (int i = 0; i < memory.length(); i++) {
				// 0이 들어왔는데 기존에 들어온 값이 1이었을 경우 = 바꿔주고(cnt++) 0이 들어왔음을 표시(false)
				// 0이 들어왔는데 기존에 들어온 값이 0이었을 경우 = continue
				if (memory.charAt(i) == '0') {
					if (chk) {
						cnt++;
						chk = false;
					} else {
						continue;
					}
				}

				// 1이 들어왔는데 기존에 들어온 값이 1이었을 경우 = continue
				// 1이 들어왔는데 기존에 들어온 값이 0이었을 경우 = 바꿔주고(cnt++) 1이 들어왔음을 표시(true)
				else {
					if (chk) {
						continue;
					} else {
						cnt++;
						chk = true;
					}
				}
			}

			// 최소 조정 횟수 cnt 출력
			System.out.printf("#%d %d\n", t, cnt);
		}
	}
}
