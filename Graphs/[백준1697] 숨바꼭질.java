import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] arr; // 위치 좌표
	static int[] dist; // 해당 좌표로 이동하는데 걸리는 시간
	static boolean[] vis; // 방문여부
	static int[] dx = { 1, -1, 2 }; // 1초마다 이동할 수 있는 위치

	// bfs 구현
	static void bfs(int x) {
		// 시작 좌표 큐에 저장 후 방문처리
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		vis[x] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
			// 현재 위치가 K라면 이동하는데 소요된 시간 출력 후 return
			if (cur == K) {
				System.out.println(dist[cur]);
				return;
			}
			for (int dir = 0; dir < 3; dir++) {
				int nx = cur;
				// dir = 2라면 오른쪽으로 현재 거리의 2배만큼 순간이동
				if (dir == 2) {
					nx *= dx[dir];
				} 
				// dir = 0 혹은 1이라면 현재 거리에서 +1 혹은 -1
				else {
					nx += dx[dir];
				}
				// nx가 경계값을 벗어나면 continue
				if (nx < 0 || nx > 100000)
					continue;
				// 방문하지 않았다면 큐에 저장 후 방문처리
				// 현재 위치(cur)에서 다음위치(nx)로 이등하는데 1초 증가
				if (!vis[nx]) {
					q.offer(nx);
					vis[nx] = true;
					dist[nx] = dist[cur] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[100001];
		dist = new int[100001];
		vis = new boolean[100001];

		bfs(N);
	}

}
