import java.util.Scanner;

public class 게이임 {

	static int x;
	static double y;
	static int z;
	

	static void BinarySearch(int x, double y) {
		if (z >= 99) {
			System.out.println(-1);
		} else {
			int st = 1;
			int end = 1000000000;
			int mid = (st+end)/2;
			while(st<=end) {
				mid = (st+end)/2;
				if(z < (int)((y+mid) * 100 / (x+mid))) {
					end = mid-1;
				}
				else {
					st= mid+1;
				}
			}
			System.out.println(end+1);
		}
	}

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextDouble();
		z = (int)(y * 100 / x);
		BinarySearch(x, y);

	}
}
