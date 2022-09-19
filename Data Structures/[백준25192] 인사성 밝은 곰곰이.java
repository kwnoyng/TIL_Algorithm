import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			// ENTER, 채팅방에 새로운 사람이 입장했다면 set을 클리어
			if (str.equals("ENTER")) {
				set.clear();
			} 
			// 채팅을 쳤는데 처음으로 입력한 채팅이라면(set에 저장되어있지 않다면)
			// cnt++후 셋에 저장
			else {
				if (!set.contains(str)) {
					cnt++;
					set.add(str);
				}
			}
		}

		System.out.println(cnt);
	}
}
