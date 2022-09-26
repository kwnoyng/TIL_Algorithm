import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int odd = 0; // 홀수의 개수
		int even = 0; // 짝수의 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			if (x % 2 == 0)
				even++;
			else
				odd++;
		}

		// 수열의 길이가 짝수이면
		// 홀수의 개수와 짝수의 개수가 동일해야함
		if (N % 2 == 0) {
			if (even == N / 2 && odd == N / 2)
				System.out.println(1);
			else
				System.out.println(0);
		} 
		// 수열의 길이가 홀수이면
		// 홀수의 개수가 짝수의 개수보다 1개 더 많아야함
		else {
			if (even == N / 2 && odd == N / 2 + 1)
				System.out.println(1);
			else
				System.out.println(0);
		}
		
		// 결국 홀수의 개수와 짝수의 개수만 맞추면 됨, 정렬하면 알아서 수열은 완성
	}
}
