import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();

		Stack<Character> S = new Stack<>(); // S 사전기술 저장 스택
		Stack<Character> L = new Stack<>(); // L 사전기술 저장 스택
		int cnt = 0; // 기술 횟수
		for (int i = 0; i < n; i++) {
			// 사전기술이 들어올 경우 해당 스택에 저장
			if (str.charAt(i) == 'S') {
				S.push(str.charAt(i));
			} else if (str.charAt(i) == 'L') {
				L.push(str.charAt(i));
			}
			// R 본기술이 들어온다면 그전에 L사전기술이 저장되어있는 경우
			// L 사전기술 하나를 없애주고 기술 발동
			// 사전기술이 없는데 본 기술이 발동되면 이후 사용되는 기술 발동 불가, break
			else if (str.charAt(i) == 'R') {
				if (!L.empty() && L.peek() == 'L') {
					L.pop();
					cnt++;
				} else {
					break;
				}
			}

			// K 본기술이 들어온다면 그전에 S사전기술이 저장되어있는 경우
			// S 사전기술 하나를 없애주고 기술 발동
			// 사전기술이 없는데 본 기술이 발동되면 이후 사용되는 기술 발동 불가, break
			else if (str.charAt(i) == 'K') {
				if (!S.empty() && S.peek() == 'S') {
					S.pop();
					cnt++;
				} else {
					break;
				}
			}
			// 1 ~ 9의 기술이 들어올 경우 바로 사용하므로 cnt++
			else {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
