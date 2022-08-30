import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		boolean[] prime = new boolean[b + 1];
		for (int i = 2; i <= b; i++)
			prime[i] = true;

		// 에라토스테네스의 체를 활용하여 소수를 구한다 (소수 : true)
		for (int i = 2; i * i <= b; i++) {
			if (!prime[i])
				continue;
			for (int j = i * i; j <= b; j += i) {
				prime[j] = false;
			}
		}

		// a ~ b 범위까지 소수이면서 팰린드롬수를 찾는다
		for (int i = a; i <= b; i++) {
			// 소수가 아니면 컷
			if (!prime[i])
				continue;
			// 소수라면 문자열로 바꿔주고 팰린드롬인지 검사
			String str = Integer.toString(i);
			boolean flag = true;
			for (int j = 0; j < str.length() / 2; j++) {
				if (str.charAt(j) != str.charAt(str.length() - 1 - j))
					flag = false;
			}
			// flag가 true라면 소수이면서 팰린드롬수, 스트링빌더에 i 저장
			if (flag)
				sb.append(i).append("\n");
		}
		// 마지막 출력
		sb.append(-1);

		System.out.println(sb);
	}
}
