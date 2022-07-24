import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		int[] arr2 = new int[n];
		for (int i = 0; i < n; i++) {
			arr2[i] = sc.nextInt();
		}

		Arrays.sort(arr1);

		boolean[] chk = new boolean[n]; // arr2배열의 최댓값을 찾은 위치는 true 아니면 false
		int[] reArr = new int[n]; // arr1배열을 재배열할 배열
		for (int i = 0; i < n; i++) {
			// 한 바퀴 돌 때마다 max, idx값을 초기화
			int max = 0;
			int idx = 0;
			// 한 바퀴를 돌면서 max값을 확인하고 그 idx를 저장
			// 모두 순회했으면 최댓값이 들어있는 위치 idx를 확인 가능
			// true면 그 다음으로 가장 높은 최대값 찾기
			for (int j = 0; j < n; j++) {
				if (chk[j] == false && arr2[j] >= max) {
					idx = j;
					max = arr2[j];
				}
			}
			reArr[idx] = arr1[i]; // reArr1배열의 idx번째(arr2의 최댓값이 들어있는)곳에 가장 낮은 값부터 넣기
			chk[idx] = true; // idx번째는 확인했으니 true
		}

		int s = 0;
		for (int i = 0; i < n; i++) {
			s += reArr[i] * arr2[i];
		}
		System.out.println(s);
		
		/* 두 번째 풀이 (사실 arr1배열을 오름차순 소팅하고 arr2배열을 내림차순 소팅한 후 값끼리 곱해도 됨... 더 간결해)
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		Integer[] arr2 = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr2[i] = sc.nextInt();
		}

		Arrays.sort(arr1);
		Arrays.sort(arr2, Comparator.reverseOrder());

		int s = 0;
		for (int i = 0; i < n; i++) {
			s += arr1[i] * arr2[i];
		}
		System.out.println(s);
		*/
	}
}
