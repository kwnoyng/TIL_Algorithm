import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열에서의 max값을 구해준다.
		int max = -1;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}

		double sum = max;
		// max가 아닌 값은 모두 2로 나누고 max에 누적해서 더해준다.
		for (int i = 0; i < n; i++) {
			if (arr[i] == max)
				continue;
			sum += (double) arr[i] / 2;
		}

		System.out.println(sum);

		// 두 에너지 드링크를 합칠 때 양이 가장 많게 하기 위해서
		// 가장 양이 적은 음료수는 2로 나눠주고 가장 양이 많은 음료수는 그냥 더해준다.
		// 즉 max값을 구한 뒤 max값이 아닌 값들을 모두 2로 나눠주고, max를 계속해서 누적합.
	}
}
