import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		// 인접한 두 학생이 가지고 있는 사탕의 수를 입력 및 그 합을 구한다.
		// 합을 2로 나눠주어 총 학생이 갖고 있는 사탕의 수를 구해준다.
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		sum /= 2;

		int tmp = 0;
		for (int i = 1; i < N; i += 2) {
			tmp += arr[i];
		}

		// k : 첫 번째 학생이 갖고 있던 사탕의 수
		int k = sum - tmp;

		// 각 학생들이 가지는 사탕 배열
		// 첫 번째 학생이 갖고 있는 사탕은 k
		int[] candy = new int[N];
		candy[0] = k;

		// 각 학생이 가지는 사탕을 구해준다.
		for (int i = 1; i < N; i++) {
			candy[i] = arr[i - 1] - candy[i - 1];
		}

		// StringBuilder에 저장 후 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++)
			sb.append(candy[i]).append("\n");

		System.out.println(sb);
	}
}
