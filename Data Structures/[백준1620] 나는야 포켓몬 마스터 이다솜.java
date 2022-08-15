import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			map1.put(i, str);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String poketmon = br.readLine();
			// 문자열로 입력을 받을 경우, 해당 키에 맞는 value값
			if (poketmon.charAt(0) >= 65) {
				sb.append(map2.get(poketmon)).append("\n");
			}
			// 숫자로 입력을 받을 경우, 입력받은 문자열을 숫자로 바꿔주고 해당 키에 맞는 value값
			else {
				sb.append(map1.get(Integer.parseInt(poketmon))).append("\n");
			}
		}
		System.out.println(sb);
	}
}