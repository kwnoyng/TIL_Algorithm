import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<>();

		int cnt = 0; // 듣도 보도 못한 사람의 명 수
		ArrayList<String> list = new ArrayList<>();
		// 듣도 못한 사람 set에 저장
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			set.add(str);
		}
		// 보도 못한 사람이 set에 포함이 되어있으면 cnt++, list에 저장
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (set.contains(str)) {
				cnt++;
				list.add(str);
			}
		}
		// 사전순으로 출력하기 위한 정렬
		Collections.sort(list);

		System.out.println(cnt);
		for (String str : list) {
			System.out.println(str);
		}
	}
}
