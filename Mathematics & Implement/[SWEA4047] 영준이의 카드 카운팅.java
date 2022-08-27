import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			// S D H C의 배열 및 카운트 할 변수 선언
			int[] S = new int[14];
			int[] D = new int[14];
			int[] H = new int[14];
			int[] C = new int[14];
			int cntS = 13;
			int cntD = 13;
			int cntH = 13;
			int cntC = 13;
			String str = br.readLine();
			int num = 0;
			boolean flag = true;

			// 카드종류+카드번호까지 총 3자리의 숫자씩 확인
			// num에 카드숫자를 저장하고 해당 배열에 카운트를 시켜준다
			// 만약 카운트가 2가 된다면 flag를 false로 바꿔주고 break
			// 그게 아니라면 cnt를 한 개씩 빼준다
			for (int i = 0; i < str.length(); i += 3) {
				if (str.charAt(i) == 'S') {
					num = (str.charAt(i + 1) - '0') * 10 + (str.charAt(i + 2) - '0');
					S[num]++;
					if (S[num] == 2) {
						flag = false;
						break;
					} else
						cntS--;
				} else if (str.charAt(i) == 'D') {
					num = (str.charAt(i + 1) - '0') * 10 + (str.charAt(i + 2) - '0');
					D[num]++;
					if (D[num] == 2) {
						flag = false;
						break;
					} else
						cntD--;
				} else if (str.charAt(i) == 'H') {
					num = (str.charAt(i + 1) - '0') * 10 + (str.charAt(i + 2) - '0');
					H[num]++;
					if (H[num] == 2) {
						flag = false;
						break;
					} else
						cntH--;
				} else if (str.charAt(i) == 'C') {
					num = (str.charAt(i + 1) - '0') * 10 + (str.charAt(i + 2) - '0');
					C[num]++;
					if (C[num] == 2) {
						flag = false;
						break;
					} else
						cntC--;
				}
			}

			// 에러일 시 정답을 출력할 문자열
			String ans = "ERROR";

			// flag = true라면 필요한 카드 갯수를 각각 출력
			// flag = false라면 ERROR 출력
			if (flag)
				System.out.printf("#%d %d %d %d %d\n", t, cntS, cntD, cntH, cntC);
			else
				System.out.printf("#%d %s\n", t, ans);
		}
	}
}
