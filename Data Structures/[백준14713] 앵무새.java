import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 큐 배열을 만들어서 i번 앵무새들이 하는 말을 모두 각각의 큐에 저장
		Queue<String>[] S = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			S[i] = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				S[i].offer(st.nextToken());
			}
		}

		// 주어진 문장을 Arraylist에 저장
		ArrayList<String> L = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			L.add(st.nextToken());
		}

		boolean flag = false;
		// 주어진 문장을 첫 단어부터 하나씩 확인
		// 해당 단어를 큐를 돌면서 앵무새가 말을 뱉을 수 있는지 확인
		for (int i = 0; i < L.size(); i++) {
			for (int j = 0; j < N; j++) {
				if (L.get(i).equals(S[j].peek())) {
					S[j].poll();
					flag = true;
					break;
				}
				// 한 단어라도 앵무새가 말할 수 없는 단어라면 flag = false
				else
					flag = false;
			}
			// 주어진 단어를 앵무새가 말할 수 없다면 break
			if (!flag)
				break;
		}

		// 앵무새가 모든 단어를 말하지 않았다면 Impossible 출력 후 종료
		for (int i = 0; i < N; i++) {
			if (!S[i].isEmpty()) {
				System.out.println("Impossible");
				return;
			}
		}

		// 앵무새가 모든 단어를 말했으면서 규칙에 맞게 잘 말했으면 Possible 출력
		// 아니라면 Impossible
		if (flag)
			System.out.println("Possible");
		else
			System.out.println("Impossible");
	}
}