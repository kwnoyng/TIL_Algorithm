import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	// 컨베이어 벨트 위, 아래 배열
	static Pos[] top;
	static Pos[] bottom;

	// 컨베이어 벨트가 한 칸씩 이동한다.
	static void rotate() {

		Pos tmpTop = top[N - 1];
		Pos tmpBottom = bottom[0];
		for (int i = N - 1; i > 0; i--) {
			top[i] = top[i - 1];
		}
		for (int i = 0; i < N - 1; i++) {
			bottom[i] = bottom[i + 1];
		}
		top[0] = tmpBottom;
		bottom[N - 1] = tmpTop;

		// 한 칸씩 이동 후 내리는 위치에 로봇이 있다면 로봇을 내린다.
		if (top[N - 1].isRobot == 1)
			top[N - 1].isRobot = 0;

	}

	// 로봇이 한 칸씩 이동한다.
	static void moveRobot() {

		// 가장 먼저 올려진 로봇부터 이동
		for (int i = N - 2; i >= 0; i--) {
			// 현재 칸에 로봇이 없다면 continue
			if (top[i].isRobot == 0)
				continue;
			// 로봇이 있는데 로봇이 이동할 수 없다면 continue
			if (top[i + 1].isRobot == 1 || top[i + 1].durability == 0)
				continue;
			// 로봇이 이동
			top[i].isRobot = 0;
			top[i + 1].isRobot = 1;
			top[i + 1].durability--;
		}

		// 로봇이 모두 이동한 후 내리는 위치에 로봇이 있다면 로봇을 내린다.
		if (top[N - 1].isRobot == 1)
			top[N - 1].isRobot = 0;
	}

	// 로봇을 올려준다.
	static void pickUpRobot() {
		// 만약 올리는 위치의 내구성이 0이 아니라면 로봇을 올려준다.
		if (top[0].durability != 0) {
			top[0].durability--;
			top[0].isRobot = 1;
		}
	}

	// 총 내구성을 확인
	static boolean chkDurability() {
		int cnt = 0;
		// 컨베이어 벨트를 모두 탐색하며 내구성이 0이라면 cnt++
		for (int i = 0; i < N; i++) {
			if (top[i].durability == 0)
				cnt++;
			if (bottom[i].durability == 0)
				cnt++;
		}
		// 내구성이 0인 컨베이어 벨트 칸이 K개 이상이라면 false
		if (cnt >= K)
			return false;

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		top = new Pos[N];
		bottom = new Pos[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int durability = Integer.parseInt(st.nextToken());
			top[i] = new Pos(durability, 0);
		}
		for (int i = N - 1; i >= 0; i--) {
			int durability = Integer.parseInt(st.nextToken());
			bottom[i] = new Pos(durability, 0);
		}

		int stage = 0;
		while (true) {
			stage++;
			rotate();
			moveRobot();
			pickUpRobot();
			if (!chkDurability())
				break;
		}

		System.out.println(stage);
	}

	// 컨베이어벨트 칸을 나타낼 클래스
	static class Pos {
		int durability;
		int isRobot;

		Pos(int durability, int isRobot) {
			this.durability = durability;
			this.isRobot = isRobot;
		}
	}
}
