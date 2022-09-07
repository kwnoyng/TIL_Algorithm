import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static boolean[] vis1; // 열 확인 배열
	static boolean[] vis2; // 좌방향 대각선 확인 배열
	static boolean[] vis3; // 우방향 대각선 확인 배열
	static int cnt; // 퀸을 놓는 경우의 수

	// 매개변수 x는 행(depth)을 의미
	static void dfs(int x) {
		// x가 N이라면(모든 행에 퀸을 놓았다면) cnt++
		if (x == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			// 해당 열, 좌방향 대각선, 우방향 대각선이 true라면 continue 후 다음 열을 탐색
			if (vis1[i] || vis2[x + i] || vis3[x - i + N - 1])
				continue;
			// 빈 곳을 찾았다면 해당 열, 좌방향 대각선, 우방향 대각선을 true로
			vis1[i] = true;
			vis2[x + i] = true;
			vis3[x - i + N - 1] = true;
			// 후에 x+1행에 퀸을 놓을 공간을 찾으러 간다
			dfs(x + 1);
			// return되어 돌아왔으면 해당 위치를 false로 변경 후 다음 열을 탐색하러 간다
			vis1[i] = false;
			vis2[x + i] = false;
			vis3[x - i + N - 1] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		vis1 = new boolean[N];
		vis2 = new boolean[2 * N - 1];
		vis3 = new boolean[2 * N - 1];
		dfs(0);

		System.out.println(cnt);
	}
}
