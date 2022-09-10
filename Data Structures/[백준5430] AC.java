import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arr = br.readLine();

			Deque<Integer> dq = new LinkedList<>();
			boolean dir = true; // true : 정방향, false : 역방향
			boolean flag = true; // 에러인지 아닌지 판별

			// 문자열 분리 후 숫자를 덱에 넣어준다
			StringTokenizer st = new StringTokenizer(arr, "[],");
			for (int i = 0; i < n; i++) {
				dq.offer(Integer.parseInt(st.nextToken()));
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < p.length(); i++) {
				char ch = p.charAt(i);
				// 수행할 함수 p가 R이면 방향을 반대로
				if (ch == 'R') {
					dir = !dir;
				}
				// D이면 첫 번째 수를 버린다
				else {
					// 비어있는데 버리는 함수를 실행할 경우 error, flag = false
					if (dq.isEmpty()) {
						sb.append("error");
						flag = false;
						break;
					}
					// 정방향일경우 앞에서 삭제
					// 역방향일경우 뒤에서 삭제
					if (dir) {
						dq.pollFirst();
					} else {
						dq.pollLast();
					}
				}
			}
			// error가 아니라면 스트링빌더에 하나씩 저장
			if (flag) {
				sb.append("[");
				if (dq.size() > 0) {
					// 정방향이면 앞에서부터 저장
					// 역방향이면 뒤에서부터 저장
					if (dir) {
						while (!dq.isEmpty()) {
							sb.append(dq.pollFirst()).append(",");
						}
					} else {
						while (!dq.isEmpty()) {
							sb.append(dq.pollLast()).append(",");
						}
					}
					// 마지막 , 빼주기
					sb.delete(sb.length() - 1, sb.length());
				}
				sb.append("]");
			}
			// 스트링빌더 출력
			System.out.println(sb);
		}
	}
}
