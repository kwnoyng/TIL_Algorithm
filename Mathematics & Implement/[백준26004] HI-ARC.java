import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();

		// index순으로 H I A R C의 cnt개수
		int[] arr = new int[5];
		int ans = 987654321;
		for (int i = 0; i < N; i++) {
			char ch = str.charAt(i);
			switch (ch) {
			case 'H':
				arr[0]++;
				break;
			case 'I':
				arr[1]++;
				break;
			case 'A':
				arr[2]++;
				break;
			case 'R':
				arr[3]++;
				break;
			case 'C':
				arr[4]++;
				break;
			}
		}

		// H I A R C의 최솟값의 답
		for (int i = 0; i < 5; i++)
			ans = Math.min(ans, arr[i]);
		System.out.println(ans);
	}
}
