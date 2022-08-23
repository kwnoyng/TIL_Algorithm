import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			// (x mod y) = (y mod z) = (z mod x) = k라고 가정
			// k의 범위 : k < x, k < y, k < z
			// 따라서(x mod y) < x, (y mod z) < y, (z mod x) < z
			// (x mod y) < x는 x ≥ y와 동치, 같은 논리로 y ≥ z, z ≥ x
			// 종합하면, x ≥ y ≥ z ≥ x
			// 해당 조건이 성립할 경우, x=y=z min(x, y, z)가 정답
			int ans = Math.min(x, y);
			ans = Math.min(ans, z);

			System.out.println(ans);
		}
	}
}