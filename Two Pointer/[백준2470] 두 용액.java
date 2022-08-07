import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr); // 오름차순 정렬

		int left = 0; // 변화시킬 왼쪽 인덱스
		int right = n - 1; // 변화시킬 오른쪽 인덱스
		int idxLeft = 0; // 정답인 왼쪽 인덱스
		int idxRight = 0; // 정답인 오른쪽 인덱스
		int value = Math.abs(arr[left] + arr[right]); // 가장 0에 가까운 특성값의 합

		// 특성값의 합을 좌우 인덱스를 변화시키며 구함, 가장 0에 가까운 특성값의 합을 구해야 해
		while (left < right) {
			int sum = arr[left] + arr[right]; // 특성값의 합
			int absSum = Math.abs(arr[left] + arr[right]); // 특성값의 합의 절대값

			// 특성값의 합이 0이면 정답 인덱스에 저장하고 break
			if (sum == 0) {
				idxLeft = left;
				idxRight = right;
				break;
			}
			// 특성값의 합의 절대값이 현재의 특성값의 합보다 같거나 낮다 = 0에 가깝다면
			// value에 절대값을 넣어주고 정답 인덱스를 지속적으로 최신화
			if (absSum <= value) {
				value = absSum;
				idxLeft = left;
				idxRight = right;
			}

			// sum이 양수라면 오른쪽 인덱스를 --, 음수라면 왼쪽 인덱스를 --
			if (sum > 0) {
				right--;
			} else {
				left++;
			}
		}

		System.out.println(arr[idxLeft] + " " + arr[idxRight]);
	}
}