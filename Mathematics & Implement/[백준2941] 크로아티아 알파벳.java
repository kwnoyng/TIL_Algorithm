import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cnt = 0;

		// 크로아티아 문자를 만족할 경우 그 칸만큼 건너뛰고 cnt
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'c' && i < str.length() - 1
					&& (str.charAt(i + 1) == '-' || str.charAt(i + 1) == '=')) {
				i++;
			} else if (str.charAt(i) == 'd' && i < str.length() - 2
					&& (str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=')) {
				i += 2;
			} else if (str.charAt(i) == 'd' && i < str.length() - 1 && (str.charAt(i + 1) == '-')) {
				i++;
			} else if (str.charAt(i) == 'l' && i < str.length() - 1 && (str.charAt(i + 1) == 'j')) {
				i++;
			} else if (str.charAt(i) == 'n' && i < str.length() - 1 && (str.charAt(i + 1) == 'j')) {
				i++;
			} else if (str.charAt(i) == 's' && i < str.length() - 1 && (str.charAt(i + 1) == '=')) {
				i++;
			} else if (str.charAt(i) == 'z' && i < str.length() - 1 && (str.charAt(i + 1) == '=')) {
				i++;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}