import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int rec(int N, int r, int c) {
		// base condition
		if (N == 0)
			return 0;

		/*
		  1122
		  1122
		  3344
		  3344 ...
		  
		  half : 한 변 길이(N)의 절반
		*/
		int half = 1 << (N - 1);
		
		// r, c가 1, 2, 3, 4번 사각형일 때 각각 재귀함수 호출
		if (r < half && c < half)
			return rec(N - 1, r, c);
		else if (r < half && c >= half)
			return half * half + rec(N - 1, r, c - half);
		else if (r >= half && c < half)
			return half * half * 2 + rec(N - 1, r - half, c);
		else
			return half * half * 3 + rec(N - 1, r - half, c - half);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		System.out.println(rec(N, r, c));
	}
}
