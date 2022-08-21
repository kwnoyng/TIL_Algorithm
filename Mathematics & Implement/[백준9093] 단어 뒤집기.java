import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			String str = br.readLine();
			
			// 공백을 기준으로 각 문자열을 word배열에 저장
			String[] word = str.split(" ");

			StringBuilder sb = new StringBuilder();
			// word배열의 각 원소를 거꾸로 스트링빌더에 저장
			for (int i = 0; i < word.length; i++) {
				for (int j = word[i].length() - 1; j >= 0; j--) {
					sb.append(word[i].charAt(j));
				}
				sb.append(" ");
			}

			System.out.println(sb);
		}
	}
}

/* Stack 활용한 풀이
 * 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			String str = br.readLine();
			Stack<Character> st = new Stack<>();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == ' ') {
					while (!st.empty()) {
						sb.append(st.pop());
					}
					sb.append(' ');
				} else {
					st.push(str.charAt(i));
				}
			}
			while (!st.empty()) {
				sb.append(st.pop());
			}

			System.out.println(sb);
		}
	}
}
*/
