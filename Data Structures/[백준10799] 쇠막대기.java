import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> st = new Stack<>();
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			// '(' 라면 스택에 추가
			if (str.charAt(i) == '(') {
				st.push(str.charAt(i));
			} else {
				st.pop(); // 일단 스택에 저장된 것을 하나 제거
				// 이전 것이 '('라면 레이저이므로 사이즈만큼 cnt
				if (str.charAt(i - 1) == '(') {
					cnt += st.size();
				}
				// 이전 것이 ')'라면 쇠막대기의 끝이므로 마지막 조각을 cnt
				else {
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}
