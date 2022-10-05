import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] dist = new int[n][n];

		// 먼저 거리를 무한대로 채워준다
		for (int i = 0; i < n; i++)
			Arrays.fill(dist[i], INF);

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int k = Integer.parseInt(st.nextToken());
			// 시작 도시와 도착 도시의 노선이 하나가 아닐 수 있으므로 기존의 가중치와 입력된 가중치의 최솟값을 저장
			dist[a][b] = Math.min(dist[a][b], k);
		}
		// 시작 도시와 도착 도시가 같은 경우는 거리가 0
		for (int i = 0; i < n; i++)
			dist[i][i] = 0;

		// 플로이드-워셜
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 현재 경로와 k번재 정점을 거쳐가는 경로 중 최단거리를 비교해서 갱신
					if (dist[i][j] > dist[i][k] + dist[k][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}

		// 출력부
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dist[i][j] == INF)
					sb.append(0).append(" ");
				else
					sb.append(dist[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
