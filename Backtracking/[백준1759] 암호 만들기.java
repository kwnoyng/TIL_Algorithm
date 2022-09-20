import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int L, C;
	static char[] arr;
	static char[] ans;
	static StringBuilder sb;

	static void dfs(int x, int idx) {
		// 문자 L개가 완성됐다면
		if (x == L) {
			int cntV = 0; // 모음의 개수 cnt 할 변수
			int cntC = 0; // 자음의 개수 cnt 할 변수
			// 문자 확인, 모음이라면 cntV++, 자음이라면 cntC++
			for (int i = 0; i < L; i++) {
				if (ans[i] == 'a' || ans[i] == 'e' || ans[i] == 'i' || ans[i] == 'o' || ans[i] == 'u') {
					cntV++;
				} else {
					cntC++;
				}
			}
			// 모음이 1개 이상이며 자음이 2개 이상이면 암호가 완성
			if (cntV >= 1 && cntC >= 2) {
				for (int i = 0; i < L; i++) {
					sb.append(ans[i]);
				}
				sb.append("\n");
				return;
			}
			return;
		}

		// C개 중 L개의 조합을 구한다
		for (int i = idx; i < C; i++) {
			ans[x] = arr[i];
			dfs(x + 1, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		ans = new char[L];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		// 문자 순서로 정렬
		Arrays.sort(arr);
		sb = new StringBuilder();
		dfs(0, 0);
		System.out.println(sb);
	}
}
