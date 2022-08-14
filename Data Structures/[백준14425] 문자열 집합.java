import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<>();
		// n개의 문자열을 HashSet에 저장
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			set.add(str);
		}
		int cnt = 0;
		// m개의 문자열을 확인, set에 저장되어있으면 cnt++
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (set.contains(str)) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
