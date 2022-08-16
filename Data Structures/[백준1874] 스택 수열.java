import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int top = 0;
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			// 들어온 k값이 기존 top보다 크면
			// k-top만큼 스택에 삽입, 스트링빌더에 + 저장
			for (int j = top; j < k; j++) {
				st.push(j + 1);
				sb.append("+\n");
				top = k;
			}
			// k값이 top보다 작으면서 k가 스택의 top과 같다면
			// 삭제 및 스트링빌더에 - 저장
			if (st.peek() == k) {
				st.pop();
				sb.append("-\n");
			}
			// k가 스택의 top과 같지 않으면
			// 해당 수열을 스택으로 처리할 수 없으므로 flag = flase
			else {
				flag = false;
				break;
			}
		}

		if (flag) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
	}
}
