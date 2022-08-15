import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			String str = br.readLine();
			int ans = 0;
			int cnt = 0;
			// 문자열을 순회하며 연속적으로 O이면 cnt++ 해주며 ans에 누적
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'O') {
					cnt++;
					ans += cnt;
				}
				// O가 아니면 cnt는 0으로 초기화
				else {
					cnt = 0;
				}
			}
			System.out.println(ans);
		}
	}
}
