import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String str = br.readLine();
			String ans;
			int cnt = 0;
			// 이미 팔씨름을 이긴 횟수만큼 cnt
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'o')
					cnt++;
			}
			// 이미 8번을 이겼거나
			// 이긴 횟수 + 남은 경기가 8번 이상이라면
			// 가능성이 충분하다
			if (cnt >= 8 || cnt + (15 - str.length()) >= 8) {
				System.out.printf("#%d YES\n", t);
			} else {
				System.out.printf("#%d NO\n", t);
			}
		}
	}
}
