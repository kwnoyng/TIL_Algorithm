import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long cnt = 0; // 총 감독관 수

		for (int i = 0; i < N; i++) {
			// 총 감독관은 시험장에 1명은 무조건 존재, cnt++
			// 각 시험장에서 총 감독관이 감독할 수 있는 인원(B)를 빼준다
			cnt++;
			A[i] -= B;

			// 총 감독관이 감독할 인원수 제외한 인원이 0보다 크면 부감독도 들어가야한다
			if (A[i] > 0) {
				// 부감독이 감독할 수 있는 인원으로 나눈 몫을 cnt에 누적
				// 나누어떨어지지 않으면 1명 더
				cnt += A[i] / C;
				if (A[i] % C > 0)
					cnt++;
			}
		}

		System.out.println(cnt);
	}
}
