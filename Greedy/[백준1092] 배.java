import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		// 크레인 입력부 및 내림차순 정렬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> crane = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(crane, Collections.reverseOrder());

		// 박스 입력부 및 내림차순 정렬
		int m = Integer.parseInt(br.readLine());
		ArrayList<Integer> box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(box, Collections.reverseOrder());

		// 가장 무거운 박스를 들 수 있는 크레인이 없다면 박스를 옮기지 못하므로 -1
		if (crane.get(0) < box.get(0)) {
			System.out.println(-1);
			return;
		}

		int time = 0;
		// 박스가 빌 때까지
		while (!box.isEmpty()) {
			int idx = 0;

			for (int i = 0; i < n;) {
				// idx가 box.size에 도달하면 해당 크레인으로 박스를 들 수 없으므로 for문을 빠져나온다
				if (idx == box.size())
					break;
				// 가장 무거운 크레인과 가장 무거운 박스를 비교, 들 수 있다면 박스 remove, i증가시키며 다음 크레인과 박스를 확인
				// 그 다음 크레인과 그 다음 무거운 박스 비교, 들 수 없다면 무거운 순으로 계속 비교하며 idx증가
				if (crane.get(i) >= box.get(idx)) {
					box.remove(idx);
					i++;
				} else {
					idx++;
				}
			}
			// for문이 끝나면 n개의 크레인이 각각 들 수 있는 무거운 박스를 동시에 든다. = 1분
			time++;
		}
		System.out.println(time);
	}
}
