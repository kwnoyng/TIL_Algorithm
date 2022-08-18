import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int num = str.length(); // 사람의 수
		int cnt = 1; // 컵홀더의 개수
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'S') {
				cnt++;
			}
			// 커플석이라면 사이에 놓이지 않으므로 i++
			else {
				cnt++;
				i++;
			}
		}

		// 컵홀더를 가장 많이 사용할 수 있는 사람 수
		// 사람 숫자가 많으면 컵홀더의 개수만큼 사용 가능
		if (num > cnt)
			System.out.println(cnt);
		// 컵홀더가 더 많으면 모든 사람이 컵홀더 사용 가능
		else
			System.out.println(num);
	}
}