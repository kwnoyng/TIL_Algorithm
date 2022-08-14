import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			boolean chk = true;
			String str = br.readLine();
			Stack<Character> st = new Stack<>();

			// 문자를 하나씩 비교하면서 '('라면 스택에 추가, ')'라면 스택에서 '('를 비워주며 쌍을 확인한다.
			// 만약 스택이 비워져있는데 ')'가 들어왔으면 chk = false
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '(') {
					st.push(str.charAt(j));
				} else {
					if (!st.empty()) {
						st.pop();
					} else {
						chk = false;
						break;
					}
				}
			}

			// 최종적으로 chk와 스택이 비었는지 여부를 확인하며 답을 출력
			if (st.empty() && chk == true) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
