import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static Student[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new Student[N][N];
		Queue<Student> q = new LinkedList<>();
		// N*N명의 학생을 입력받고 큐에 저장한다. (입력받은 순서대로 자리에 앉히기 위함)
		for (int i = 0; i < N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());

			int[] like = new int[4];
			for (int j = 0; j < 4; j++)
				like[j] = Integer.parseInt(st.nextToken());

			q.offer(new Student(num, like));
		}

		// 큐에서 하나씩 꺼내어 학생 순서대로 자리를 배치한다
		while (!q.isEmpty()) {
			Student cur = q.poll();

			// 앉을 자리를 지정하기 위한 우선순위 큐 생성
			PriorityQueue<Pos> pq = new PriorityQueue<>();

			// map을 모두 돌면서 빈 자리가 있다면(map이 null이라면) 앉을 수 있는 자리의 후보가 된다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 빈 자리라면 이제 빈 자리와 인접한 자리를 확인한다
					if (map[i][j] == null) {
						int cnt = 0;
						int space = 0;
						for (int dir = 0; dir < 4; dir++) {
							int nr = i + dr[dir];
							int nc = j + dc[dir];

							// 주변의 자리가 경계값을 벗어났다면 continue
							if (nr < 0 || nr >= N || nc < 0 || nc >= N)
								continue;

							// 주변의 자리가 빈 공간이라면 space++ 후 continue
							if (map[nr][nc] == null) {
								space++;
								continue;
							}
							// 주변의 자리에 학생들이 앉아있는데 내가 좋아하는 학생이라면 cnt++
							for (int k = 0; k < 4; k++) {
								if (map[nr][nc].num == cur.like[k])
									cnt++;
							}
						}

						// 빈 자리의 주변을 모두 확인한 후 pq에 넣는다.
						pq.offer(new Pos(i, j, space, cnt));
					}
				}
			}

			// 우선순위 큐에 정렬되어 앉아야 하는 자리를 뽑은 후 그 자리에 현재 학생을 앉힌다.
			Pos seat = pq.poll();
			map[seat.r][seat.c] = cur;
		}

		// 학생들을 자리에 모두 앉힌 후 각각의 학생들을 모두 확인하며 만족도를 구해준다.
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Student cur = map[i][j];
				int cnt = 0;

				// 현재 학생의 인접 자리를 확인하며 좋아하는 친구가 앉아있다면 cnt++
				for (int dir = 0; dir < 4; dir++) {
					int nr = i + dr[dir];
					int nc = j + dc[dir];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;
					for (int k = 0; k < 4; k++) {
						if (map[nr][nc].num == cur.like[k])
							cnt++;
					}
				}

				// 인접한 자리에 좋아하는 친구가 0명 앉아있다면 만족도 +0
				// 1명 앉아있다면 만족도 +1, 2명 앉아있다면 만족도 +10, 3명 앉아있다면 만족도 +100, 4명 앉아있다면 만족도 +1000
				if (cnt == 1) {
					ans++;
				} else if (cnt == 2) {
					ans += 10;
				} else if (cnt == 3) {
					ans += 100;
				} else if (cnt == 4) {
					ans += 1000;
				}
			}
		}

		// 만족도의 총합
		System.out.println(ans);
	}

	// 학생을 나타낼 클래스
	static class Student {
		int num;
		int[] like;

		Student(int num, int[] like) {
			this.num = num;
			this.like = like;
		}
	}

	// 자리의 상태를 나타낼 클래스
	static class Pos implements Comparable<Pos> {
		int r, c, space, cnt;

		Pos(int r, int c, int space, int cnt) {
			this.r = r;
			this.c = c;
			this.space = space;
			this.cnt = cnt;
		}

		// 앉을 자리를 정렬하기 위한 CompareTo
		// 1순위 : 인접한 자리에 좋아하는 학생이 가장 많은 자리
		// 2순위 : 1순위를 만족하는 자리가 여러 자리라면, 인접한 자리 중 비어있는 자리가 가장 많은 자리
		// 3순위 : 2순위를 만족하는 자리가 여러 자리라면, 행의 번호가 가장 작은 자리
		// 4순위 : 3순위를 만족하는 자리가 여러 자리라면, 열의 번호가 가장 작은 자리
		@Override
		public int compareTo(Pos o) {
			if (this.cnt == o.cnt) {
				if (this.space == o.space) {
					if (this.r == o.r) {
						return Integer.compare(this.c, o.c);
					}
					return Integer.compare(this.r, o.r);
				}
				return Integer.compare(o.space, this.space);
			}
			return Integer.compare(o.cnt, this.cnt);
		}
	}
}
