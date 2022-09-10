import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 진짜 약수(1과 자신(N)을 제외한 약수)들이 입력으로 들어옴.
		// 즉 주어진 진짜약수에서 최솟값, 최댓값을 구하면 해결
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		int min = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		System.out.println(max * min);
	}
}
