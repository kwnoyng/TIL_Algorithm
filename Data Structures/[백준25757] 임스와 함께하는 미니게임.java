import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		char game = st.nextToken().charAt(0);

		HashSet<String> list = new HashSet<>();
		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		
		// 게임에 따라 플레이할 수 있는 최대 횟수를 출력
		switch (game) {
		case 'Y':
			System.out.println(list.size());
			break;
		case 'F':
			System.out.println(list.size() / 2);
			break;
		case 'O':
			System.out.println(list.size() / 3);
			break;
		}
	}
}