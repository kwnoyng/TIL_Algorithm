import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N개의 단어 모음을 문자열 arr배열에 저장
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for (int i = 0; i < N; i++)
			arr[i] = br.readLine();

		// M개의 단어로 이루어진 문장 S를 문자열 S배열에 저장
		int M = Integer.parseInt(br.readLine());
		String[] S = new String[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			S[i] = st.nextToken();

		// 정렬된 단어와 원본 단어를 key value로 저장할 map 생성
		HashMap<String, String> map = new HashMap<>();

		// arr를 순회하면서 해당 단어를 맨 앞과 맨 뒤 글자를 고정시키고 정렬한 후 sorted에 저장
		for (int i = 0; i < N; i++) {
			StringBuilder sorted = new StringBuilder();
			// 단어의 길이가 4이상이라면 tmp 임시 문자 배열을 생성
			// arr[i]에 해당하는 단어를 문자배열로 변경 후 양 끝을 제외한 문자를 정렬
			// sorted에 정렬한 문자 배열을 문자열로 변환 후 저장
			if (arr[i].length() >= 4) {
				char[] tmp = arr[i].toCharArray();
				Arrays.sort(tmp, 1, tmp.length - 1);
				sorted.append(String.valueOf(tmp));
			}
			// 단어의 길이가 3 이하라면 정렬할 필요 없이 단어 그대로 sorted에 저장
			else {
				sorted.append(arr[i]);
			}
			// key : 정렬된 단어, value : 원본 단어로 map에 저장
			map.put(sorted.toString(), arr[i]);
		}

		StringBuilder sb = new StringBuilder();
		// S배열을 순회하며 단어를 하나씩 확인
		for (int i = 0; i < M; i++) {
			// 현재 단어 : word
			String word = S[i];
			StringBuilder sorted = new StringBuilder();
			// 동일한 로직으로 word를 양끝을 고정한 채 정렬 후 sorted에 저장
			if (word.length() >= 4) {
				char[] tmp = word.toCharArray();
				Arrays.sort(tmp, 1, tmp.length - 1);
				sorted.append(String.valueOf(tmp));
			} else {
				sorted.append(word);
			}
			// sorted 문자열을 key로 하는 원본 단어를 sb에 저장
			sb.append(map.get(sorted.toString())).append(" ");
		}

		System.out.println(sb);
	}
}
