import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, N;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Pos> bomb;

	// 모든 칸에 폭탄을 설치하는 setBomb함수
	static void setBomb() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '.') {
					map[i][j] = 'O';
				}
			}
		}
	}

	// 3초 전에 설치된 폭탄이 폭발하는 explosionBomb함수
	static void explosionBomb() {
		// bomb가 빌 때까지 반복
		while (!bomb.isEmpty()) {
			// 현재 칸의 폭탄을 폭발시킨다.
			Pos cur = bomb.poll();
			map[cur.r][cur.c] = '.';
			// 사방탐색
			for (int dir = 0; dir < 4; dir++) {
				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];

				// 경계값을 넘어갔다면 continue
				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;
				// 인접한 칸에 폭탄이 있다면 같이 폭발
				if (map[nr][nc] == 'O') {
					map[nr][nc] = '.';
				}
			}
		}
	}

	// 3초 전에 설치된 폭탄을 bomb 큐에 넣는 findBomb함수
	static void findBomb() {
		bomb = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'O') {
					bomb.offer(new Pos(i, j));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		bomb = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				// 가장 처음에 폭탄을 설치하므로 폭탄이 입력된다면 bomb에 추가 후 방문처리
				if (map[i][j] == 'O') {
					bomb.offer(new Pos(i, j));
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			// 처음 1초는 아무것도 하지 않는다.
			if (i == 1)
				continue;
			// 짝수 초가 되면 봄버맨은 모든 칸에 폭탄을 설치한다.
			else if (i % 2 == 0)
				setBomb();
			// 홀수 초가 되면 3초 전에 설치한 폭탄이 폭발
			else {
				explosionBomb();
				findBomb();
			}
		}

		// N초가 흐른 후 map 상태를 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static class Pos {
		int r;
		int c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
