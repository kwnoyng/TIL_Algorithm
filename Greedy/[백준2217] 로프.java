import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr); // arr배열 정렬
		int max = 0;
		// 가장 무거운 것부터 차례로 반복문, max값 구하기
		// n개의 병렬로 무게를 지탱할 거면 같은 하중을 받으므로 최솟값*n으로 지탱 가능함
		for (int i = n - 1; i >= 0; i--) {
			if (max < arr[i] * (n-i)) {
				max = arr[i] * (n-i);
			}
		}
		System.out.println(max);
	}
}
