import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean chk = true;
		int cnt = 0;

		// 최대한 5원을 많이 사용해서 돈을 거슬러줘야한다
		
		// 5로 나눈 나머지가 0이 아니라면 5로 나눈 나머지가 0이 될 때까지
		// n에서 2를 빼주고 cnt++ (2원으로 거슬러줌)
		while (n % 5 != 0) {
			n -= 2;
			cnt++;
			// 만약 n이 음수가 되면 거스름돈을 나눠줄 수 없음, chk = false
			if (n < 0) {
				chk = false;
				break;
			}
		}
		// cnt에 n을 5로 나눈 몫을 더함(5원으로 거슬러줌)
		cnt += n / 5;

		// 거스름돈 나눠줄 수 없다면 -1 출력
		if (chk)
			System.out.println(cnt);
		else
			System.out.println(-1);
	}
}
