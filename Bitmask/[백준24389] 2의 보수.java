import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// N 을 반대로 뒤집은 후 1을 더하여 2의 보수를 만듬
		int notN = ~N + 1;
		// XOR연산을 한 값을 이진문자열로 저장
		String str = Integer.toBinaryString(N ^ notN);

		int cnt = 0;
		// 값이 다른 것이 1이므로 1이라면 cnt++
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1')
				cnt++;
		}
		System.out.println(cnt);
	}
}
