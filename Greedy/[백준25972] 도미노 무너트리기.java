import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] domino = new int[N][2];
		// 0 : 도미노의 좌표, 1 : 도미노의 길이
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			domino[i][0] = Integer.parseInt(st.nextToken());
			domino[i][1] = Integer.parseInt(st.nextToken());
		}

		// 도미노를 좌표 기준 오름차순으로 정렬
		Arrays.sort(domino, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		// 일단 첫 번째 도미노를 쓰러뜨리므로 cnt = 1
		// k : 현재 도미노가 쓰러지면 도달하는 좌표
		int cnt = 1;
		int k = domino[0][0] + domino[0][1];
		for (int i = 1; i < N; i++) {
			// 현재 도미노를 쓰러뜨리고 도달하는 좌표가 다음 도미노(i번째)의 좌표보다 작다면
			// i번째 도미노를 다시 쓰러뜨려야하므로 cnt++
			if (domino[i][0] > k) {
				cnt++;
			}
			// i번째 도미노가 쓰러지면 도달하는 좌표 최신화
			k = domino[i][0] + domino[i][1];
		}

		System.out.println(cnt);
	}
}
