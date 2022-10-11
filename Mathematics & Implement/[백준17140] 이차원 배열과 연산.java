import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int r, c, k;
	static int R, C; // 행의 갯수, 열의 갯수
	static int[][] arr;
	static int t; // 시간

	// 행을 정렬하는 함수
	static void cmdR() {
		int[][] tmp = new int[100][100];
		// 행의 갯수만큼 반복
		for (int i = 0; i < R; i++) {
			// 카운트해줄 배열 생성, 정렬해줄 우선순위큐 생성
			int[] cnt = new int[101];
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			// 열의 갯수만큼 반복하며 카운트해준다
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 0)
					continue;
				cnt[arr[i][j]]++;
			}
			// 1부터 100까지 카운트 배열을 순서대로 반복하며 0이 아니면 pq에 저장
			// pq에 저장할 때, 숫자 그리고 갯수 순으로 저장
			for (int j = 1; j <= 100; j++) {
				if (cnt[j] != 0) {
					pq.offer(new Pair(j, cnt[j]));
				}
			}
			// 열이 늘어났으므로 기존 열과 pq의 사이즈*2의 최댓값으로 최신화
			// pq에 Pair(num, cnt)가 들어있으므로 2배로 설정
			C = Math.max(C, pq.size() * 2);
			// pq에서 하나씩 꺼내어 순서대로 tmp배열에 저장
			int idx = 0;
			while (!pq.isEmpty()) {
				Pair cur = pq.poll();
				tmp[i][idx++] = cur.num;
				tmp[i][idx++] = cur.cnt;
			}
		}
		// 원본 배열을 tmp배열에 복사
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				arr[i][j] = tmp[i][j];
			}
		}
	}

	// 열을 정렬하는 함수
	// 행을 정렬하는 함수와 로직 동일
	static void cmdC() {
		int[][] tmp = new int[100][100];
		for (int j = 0; j < C; j++) {
			int[] cnt = new int[101];
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			for (int i = 0; i < R; i++) {
				if (arr[i][j] == 0)
					continue;
				cnt[arr[i][j]]++;
			}
			for (int i = 1; i <= 100; i++) {
				if (cnt[i] != 0) {
					pq.offer(new Pair(i, cnt[i]));
				}
			}
			R = Math.max(R, pq.size() * 2);
			int idx = 0;
			while (!pq.isEmpty()) {
				Pair cur = pq.poll();
				tmp[idx++][j] = cur.num;
				tmp[idx++][j] = cur.cnt;
			}
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				arr[i][j] = tmp[i][j];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());

		arr = new int[100][100];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 초기 배열은 3x3
		R = 3;
		C = 3;
		while (true) {
			// arr[r][c] == k이면 t를 출력
			// 100초를 초과했다면 -1 출력
			if (arr[r][c] == k) {
				System.out.println(t);
				break;
			}
			if (t > 100) {
				System.out.println(-1);
				break;
			}

			// 행의 갯수가 열의 갯수보다 크거나 같다면 행 정렬
			// 아니라면 열 정렬
			if (R >= C) {
				cmdR();
			} else {
				cmdC();
			}
			// 시간 1초 증가
			t++;
		}
	}

	static class Pair implements Comparable<Pair> {
		int num;
		int cnt;

		Pair(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.cnt == o.cnt) {
				return this.num - o.num;
			}
			return this.cnt - o.cnt;
		}
	}
}