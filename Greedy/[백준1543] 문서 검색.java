import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String word = br.readLine();
		int ans = 0;
		for (int i = 0; i <= str.length() - word.length(); i++) {
			// 첫 글자가 동일하면 word문자열인지 확인
			if (str.charAt(i) == word.charAt(0)) {
				// word문자열이 맞는지 확인할 chk
				boolean chk = true;
				for (int j = 0; j < word.length(); j++) {
					// 만약 글자가 하나라도 다르다면 false
					if (str.charAt(i + j) != word.charAt(j)) {
						chk = false;
					}
				}
				// chk == ture라면 ans++이후 해당 word 문자열 길이만큼 건너뛴다
				if (chk) {
					ans++;
					i += word.length() - 1;
				}
			}
		}

		/*	replace 함수 사용한 풀이
		
		str안의 word문자열을 모두 K로 바꿔준 후 K의 갯수를 센다
		str = str.replace(word, "K");
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'K') {
				ans++;
			}
		}
		*/
		System.out.println(ans);
	}
}
