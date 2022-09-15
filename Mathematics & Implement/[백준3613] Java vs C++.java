import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		char flag = '?'; // E : 에러, C : C++, J : Java
		// 첫 글자가 대문자 or _이거나 마지막 글자가 _이거나 _가 연속으로 나올 경우 flag = E
		if (str.charAt(0) < 'a' || str.charAt(0) == '_' || str.charAt(str.length() - 1) == '_' || str.contains("__")) {
			flag = 'E';
		}
		// _가 존재하지만 대문자가 존재하면 flag = E
		// _가 존재하지만 대문자가 존재하지 않으면 flag = C
		// _가 존재하지 않으면 flag = J;
		else {
			if (str.contains("_")) {
				for (int i = 0; i < str.length(); i++) {
					char ch = str.charAt(i);
					if (Character.isUpperCase(ch)) {
						flag = 'E';
						break;
					}
					flag = 'C';
				}
			} else {
				flag = 'J';
			}
		}

		// 변수명이 C++이라면 Java의 형태로 변환
		if (flag == 'C') {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '_') {
					i++;
					sb.append((char) (str.charAt(i) - 32));
				} else {
					sb.append(str.charAt(i));
				}
			}
		}
		// 변수명이 Java이라면 C++의 형태로 변환
		else if (flag == 'J') {
			for (int i = 0; i < str.length(); i++) {
				if (Character.isUpperCase(str.charAt(i))) {
					sb.append('_').append((char) (str.charAt(i) + 32));
				} else {
					sb.append(str.charAt(i));
				}
			}
		}
		// Error
		else if (flag == 'E') {
			sb.append("Error!");
		}

		System.out.println(sb);

	}
}
