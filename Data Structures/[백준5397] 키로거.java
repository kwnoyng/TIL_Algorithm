import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			LinkedList<Character> list = new LinkedList<>();
			int pointer = 0; // 포인터 설정
			String str = br.readLine();

			for (int i = 0; i < str.length(); i++) {
				// <라면, 포인터를 하나씩 줄여준다 (가장 끝이라면 continue)
				if (str.charAt(i) == '<') {
					if (pointer <= 0)
						continue;
					pointer--;
				}
				// >라면, 포인터를 하나씩 늘려준다 (가장 끝이라면 continue)
				else if (str.charAt(i) == '>') {
					if (pointer >= list.size())
						continue;
					pointer++;
				}

				// -라면, 포인터 -1 인덱스의 값을 삭제하고 포인터는 줄여준다
				// 포인터가 0이라면 지울 게 없다
				else if (str.charAt(i) == '-') {
					if (pointer > 0) {
						list.remove(pointer - 1);
						pointer--;
					}
				}
				// 외의 문자라면, 해당 포인터 인덱스의 list에 추가, pointer++
				else {
					list.add(pointer, str.charAt(i));
					pointer++;
				}
			}

			StringBuilder sb = new StringBuilder();
			for (char x : list) {
				sb.append(x);
			}

			System.out.println(sb);
		}
	}
}
