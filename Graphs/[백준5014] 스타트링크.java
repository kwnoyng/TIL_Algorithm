import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int F, S, G, U, D;
	static boolean[] vis;
	static int ans;

	static void bfs(int k, int cnt) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(k, cnt));
		vis[k] = true;

		while (!q.isEmpty()) {

			// 큐에서 front값 추출 후 목적지 G라면 ans = cur.cnt
			Pos cur = q.poll();
			if (cur.k == G) {
				ans = cur.cnt;
				break;
			}

			// dir이 0이면 UP, 1이면 DOWN
			for (int dir = 0; dir < 2; dir++) {
				int nk = (dir == 0) ? cur.k + U : cur.k - D;
				// 층 범위를 넘어가면 continue
				if (nk < 1 || nk > F)
					continue;
				// 방문하지 않았으면 true로 변경한 후 nk로 이동 후 버튼을 눌렀으니까 cur.cnr +1
				if (!vis[nk]) {
					vis[nk] = true;
					q.offer(new Pos(nk, cur.cnt + 1));
				}

			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken()); // 1 ~ F층까지 존재
		S = Integer.parseInt(st.nextToken()); // 현재 내가 있는 층
		G = Integer.parseInt(st.nextToken()); // 스타트링크가 위치한 층
		U = Integer.parseInt(st.nextToken()); // 위로 U층 이동
		D = Integer.parseInt(st.nextToken()); // 아래로 D층 이동
		
		// 층에 방문했는지 체크하는 boolean배열
		vis = new boolean[F + 1];
		// 현재 위치에서 bfs함수 호출
		bfs(S, 0);

		// 현재 내가 있는 곳이 G라면 버튼 0번 누름
		if (S == G) {
			System.out.println(0);
		} 
		// 현재 위치가 G가 아닌데 ans = 0이라면  엘레베이터로 불가능
		else if (ans == 0) {
			System.out.println("use the stairs");
		} 
		// 엘레베이터로 이동 가능하면 ans
		else {
			System.out.println(ans);
		}
	}
}

// BFS 구현하기 위한 클래스
class Pos {
	int k;
	int cnt;

	Pos(int k, int cnt) {
		this.k = k;
		this.cnt = cnt;
	}
}