import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] list = new String[N];
		// N 크기의 list에 비밀번호 목록을 저장
		for (int i = 0; i < N; i++) {
			list[i] = br.readLine();
		}

		String password = "";
		// 각각의 비밀번호를 비교해야하므로 N번만큼 반복
		for (int i = 0; i < N; i++) {
			String str1 = list[i];
			// i번째 비밀번호와 j번째 비밀번호를 뒤집은 문자열이 동일하다면, i번째 문자열이 진짜 비밀번호
			for (int j = i; j < N; j++) {
				String str2 = new StringBuilder(list[j]).reverse().toString();
				if (str1.equals(str2)) {
					password = str1;
					break;
				}
			}
		}
		
		System.out.println(password.length() + " " + password.charAt(password.length() / 2));
	}
}
