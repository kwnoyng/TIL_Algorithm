import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int mod = 1234567891;
        long hash = 1;
		long ans = 0;
		// a ~ z : 1 ~ 26
		// 첫 번재 문자부터 비교하며 해시값을 곱해주고 해시값 갱신
		for (int i = 0; i < L; i++) {
			ans += (str.charAt(i) - 'a' + 1) * hash;
			hash = (hash * 31) % mod;
		}
		System.out.println(ans % mod);
	}
}