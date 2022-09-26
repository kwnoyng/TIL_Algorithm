import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int s = 0;
		int t = 0;
		Stack<Character> st = new Stack<>();
		// 끝 수부터 차례대로 스택에 저장하며 s와 t를 카운트
		for (int i = str.length() - 1; i >= 0; i--) {
			st.push(str.charAt(i));
			if (str.charAt(i) == 's')
				s++;
			else if (str.charAt(i) == 't')
				t++;
		}
		// s와 t가 같다면 균형잡힌 소떡
		// 균형이 잡히지 않았다면 하나씩 pop한 후 균형잡힌 소떡이 되는지 확인
		for (int i = 0; i < str.length(); i++) {
			if (s == t)
				break;
			if (st.peek() == 's') {
				s--;
			} else {
				t--;
			}
			st.pop();
		}
		// 균형이 잡혔다면 스택에 저장된 소떡을 하나씩 출력
		while (!st.empty()) {
			System.out.print(st.pop());
		}
	}
}
