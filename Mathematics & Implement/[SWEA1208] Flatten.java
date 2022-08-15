import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int dump = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			// dump의 값만큼 정렬하며 가장 최고값--, 가장 최저값++
			for (int i = 0; i < dump; i++) {
				Arrays.sort(arr);
				arr[99]--;
				arr[0]++;
			}

			Arrays.sort(arr);
			System.out.printf("#%d %d\n", t, arr[99] - arr[0]);
		}
	}
}
