import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long R = Long.parseLong(st.nextToken());

		/*
		 * 비둘기집 원리 : n+1개의 물건을 n개의 상자에 넣을 때 적어도 어느 한 상자에는 두 개 이상의 물건이 들어 있다는 원리 
		 * N+1: 1세트가 완성됨, 1세트가 완성되었기 때문에 앞으로 (R-1)세트를 더 만들어야 함
		 * 2*(R-1): (R-1)세트를 만들기 위해서는 총 2*(R-1)개의 젓가락이 필요
		 */

		long ans = 0;
		ans = N + 1;
		ans += (R - 1) * 2;

		System.out.println(ans);
	}
}
