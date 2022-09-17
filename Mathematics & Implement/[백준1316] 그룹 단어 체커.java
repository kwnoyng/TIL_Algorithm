import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		// N번만큼 반복
		while (N-- > 0) {
			// 알파벳을 확인할 배열(0 ~ 25), 그룹단어인지 확인할 flag
			boolean[] alp = new boolean[26];
			boolean flag = true;
			String str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				// 알파벳에 해당하는 숫자의 idx 배열이 false라면 true로
				if (!alp[str.charAt(i) - 'a'])
					alp[str.charAt(i) - 'a'] = true;
				// true일 경우
				else {
					// 전의 문자랑 동일하다면 continue
					if (str.charAt(i) == str.charAt(i - 1))
						continue;
					// 전의 문자와 동일하지 않다면 그룹단어가 아니므로 false
					else
						flag = false;
				}
			}
			// 그룹단어이면 cnt++
			if (flag)
				cnt++;
		}
		System.out.println(cnt);
	}
}
