import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st;
		boolean flag;
		while (true) {
			String str = br.readLine();
			if (str.equals(".")) {
				break;
			} else {
				st = new Stack<>();
				flag = true;
				for (int i = 0; i < str.length(); i++) {

					// '(' 혹은 '['이면 스택에 push
					if (str.charAt(i) == '(') {
						st.push(str.charAt(i));
					} else if (str.charAt(i) == '[') {
						st.push(str.charAt(i));
					}

					// ')' 혹은 ']'라면 스택이 비어있지 않으면서 top이 '(' 혹은 '['라면 pop
					else if (str.charAt(i) == ')') {
						if (!st.isEmpty() && st.peek() == '(') {
							st.pop();
						}
						// 아니면 flag == false.
						else {
							flag = false;
							break;
						}
					} else if (str.charAt(i) == ']') {
						if (!st.isEmpty() && st.peek() == '[') {
							st.pop();
						} else {
							flag = false;
							break;
						}
					}
				}
			}

			// 최종적으로 flag가 true이면서 스택이 비어있지 않다면 == 균형잡힌 세상
			if (flag == true && st.isEmpty())
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
}
