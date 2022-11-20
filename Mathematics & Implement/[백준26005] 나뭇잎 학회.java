import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int ans = 0;

		// 스위치가 1개라면 연결되어있는 눌러볼 필요 없이 해당 스위치가 전구랑 연결되어있다. 
		if (N == 1)
			ans = 0;
		// 스위치가 홀수개라면  N*N/2 + 1번 눌러보면 어느 전구와 연결되어있는지 알 수 있다.
		else if (N % 2 == 1)
			ans = N * N / 2 + 1;
		// 스위치가 짝수개라면 N*N/2번 눌러보면 어느 전구와 연결되어있는지 알 수 있다.
		else
			ans = N * N / 2;

		System.out.println(ans);
	}
}
