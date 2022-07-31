import java.util.Scanner;

public class Main {

	static long x, y, z; // 총 게임의 횟수, 이긴 게임의 횟수, 승률

	// Binary Search 구현, 이분탐색을 진행하여 z가 변하는 최소 게임의 횟수를 구한다.
	static int BinarySearch() {
		// 99퍼 이상일 경우 더 이상 z가 증가할 수 없으므로 -1 return
		if (z >= 99)
			return -1;

		int st = 1;
		int end = 1000000000;
		int mid = 0;
		while (st <= end) {
			mid = (st + end) / 2;
			if (z < (y + mid) * 100 / (x + mid)) {
				end = mid - 1;
			} else {
				st = mid + 1;
			}
		}
		return end + 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextLong();
		y = sc.nextLong();
		z = y * 100 / x;
		System.out.println(BinarySearch());

	}
}