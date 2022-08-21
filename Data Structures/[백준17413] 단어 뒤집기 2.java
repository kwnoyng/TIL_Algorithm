import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		Stack<Character> st = new Stack<>();
		StringBuilder sb = new StringBuilder();

		// 문자열의 각 문자를 차례로 순회
		for (int i = 0; i < str.length(); i++) {

			// 만약 문자가 < 라면 지금까지 저장되어있던 모든 스택의 원소를 pop하며 스트링빌더에 저장
			// 그리고 >가 나올 때까지 차례대로 스트링빌더에 저장
			if (str.charAt(i) == '<') {
				while (!st.empty()) {
					sb.append(st.pop());
				}
				while (str.charAt(i) != '>') {
					sb.append(str.charAt(i++));
				}
				// 마지막으로 >를 스트링빌더에 저장
				sb.append('>');
			}

			// 공백이 나온다면 지금까지 저장되어있던 모든 스택의 원소를 pop하며 스트링빌더에 저장
			else if (str.charAt(i) == ' ') {
				while (!st.empty()) {
					sb.append(st.pop());
				}
				sb.append(' ');
			}

			// 다른 문자라면 스택에 저장
			else {
				st.push(str.charAt(i));
			}
		}

		// 마지막으로 스택에 원소가 남아있다면 pop하며 스트링빌더에 저장
		while (!st.empty()) {
			sb.append(st.pop());
		}

		System.out.println(sb);
	}
}
