import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		// A의 선공, 상대의 손가락이 5개 이상되면 승리 
		while (true) {
			B += A;
			if (B >= 5) {
				System.out.println("yt");
				break;
			}
			A += B;
			if (A >= 5) {
				System.out.println("yj");
				break;
			}
		}
	}
}