import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] arr = new int[100][100];
	static boolean[][] visited;
	// 사다리는 위에서부터 내려오므로 좌 우 아래만 탐색
	static int[] dr = { 0, 0, 1 };
	static int[] dc = { -1, 1, 0 };
	static int k;
	static int ans;

	// 해당 지점을 true로 바꿔줌

	static void dfs(int x, int y) {
		visited[x][y] = true;
		boolean flag = false;
		// 3방탐색
		for (int cur = 0; cur < 3; cur++) {
			if (flag == true)
				break;
			int nr = x + dr[cur];
			int nc = y + dc[cur];
			// 경계값 설정
			if (nr < 0 || nr >= 100 || nc < 0 || nc >= 100)
				continue;
			// arr값이 2면 해당 열(k)이 정답
			if (arr[nr][nc] == 2) {
				ans = k;
				return;
			}
			// arr값이 1이고 방문하지 않았으면 dfs 함수 재귀 호출
			if (arr[nr][nc] == 1 && !visited[nr][nc]) {
				flag = true;
				dfs(nr, nc);
			}
		}
	}
	// 사다리타기는 위에서 내려오다가 좌측 우측 혹은 아래로만 진행하므로 flag를 만들었다.
	// 좌 우 아래를 순서대로 1이며 false인지 탐색하다가 조건이 만족하면 flag를 true로
	// 그리고 flag가 true이면 break해주며 나머지 방향을 탐색하지 않는다.

	/*
	 * 예시) 
	 * 좌(0, false) 우(1, false) 아래(1, false) 
	 * (첫 번째 for)좌측은 조건에 부합하지 않으므로 continue
	 * (두 번째 for)우측은 조건에 만족, dfs 재귀 호출, flag = true 
	 * (세 번째 for)dfs를 모두 순회한 후 다시 돌아왔지만
	 * flag = true이므로 break; => flag는 방향을 한 곳으로만 설정해주는 역할
	 * 
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			Integer.parseInt(br.readLine());
			arr = new int[100][100];
			visited = new boolean[100][100];
			StringTokenizer st;
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 0행 k열(가장 윗부분)만 탐색
			// 1이면서 방문하지 않았으면(false) dfs함수 호출
			for (k = 0; k < 100; k++) {
				if (arr[0][k] == 1 && !visited[0][k]) {
					dfs(0, k);
				}
				visited = new boolean[100][100];
			}
			System.out.printf("#%d %d\n", t, ans);

		}
	}
}
 	// dfs 풀이

-------------------------------------------------------------------------------------

public class Solution {

	static int[][] arr = new int[100][100];
	static int ans;
	static int row;
	static int col;
	static int idx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			Integer.parseInt(br.readLine());
			arr = new int[100][100];
			ArrayList<Integer> list = new ArrayList<>();
			StringTokenizer st;
			// 마지막 행이 0이 아닌 경우, 인덱스값을 list에 저장
			// 2를 찾아서 거꾸로 올라갈 예정이므로 2인 경우의 인덱스값을 idx에 저장
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[99][j] != 0) {
						list.add(j);
					}
					if (arr[99][j] == 2) {
						idx = j;
					}
				}
			}

			// 99번행 idx열 == 2
			// key : 숫자 2를 가진 idx값이 저장된 list의 인덱스값
			row = 99;
			col = idx;
			int key = list.indexOf(idx);
			while (true) {
				// 0행에 도달시 해당 열이 정답
				if (row == 0) {
					ans = col;
					break;
				}
				// 좌측열이 배열을 벗어나지 않으면서 값이 1일 경우
				// 열을 리스트 해당 key의 값과 좌측 키(key-1)의 값만큼 빼준다  
				// 그리고 현재 key를 바꿔줘야한다.
				// 왼쪽 끝까지 다 뺐으니 행을 하나 줄여줌
				if (col - 1 >= 0 && arr[row][col - 1] == 1) {
					col -= list.get(key) - list.get(key - 1);
					key--;
					row--;
				}
				// 우측열이 배열을 벗어나지 않으면서 값이 1일 경우
				// 열을 리스트 해당 key의 값과 우측 키(key-1)의 값만큼 더해준다  
				// 그리고 현재 key를 바꿔줘야한다.
				// 왼쪽 끝까지 다 뺐으니 행을 하나 줄여줌
				else if (col + 1 < 100 && arr[row][col + 1] == 1) {
					col += list.get(key + 1) - list.get(key);
					key++;
					row--;
				}

				// 좌측열도 우측열도 1이 아니면 올라가야하니 행을 줄여줌
				else {
					row--;
				}
			}

			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
	// ArrayList의 idx값을 이용한 풀이

-------------------------------------------------------------------------------------

public class Solution {

	static int[][] arr = new int[100][100];
	static int ans;
	static int row;
	static int col;
	static int idx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			Integer.parseInt(br.readLine());
			arr = new int[100][100];
			StringTokenizer st;
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2) {
						idx = j;
					}
				}
			}

			row = 99;
			col = idx;
			// 2인 지점부터 거꾸로 올라간다
			// 0행에 도달하면 해당 열이 정답
			while (true) {
				if (row == 0) {
					ans = col;
					break;
				}
				// 좌측열이 배열을 벗어나지 않으면서 값이 1일 경우 계속해서 좌측으로 이동
				// 좌측열의 끝에 도달하면 row--
				if (col - 1 >= 0 && arr[row][col - 1] == 1) {
					while (col - 1 >= 0 && arr[row][col - 1] == 1) {
						col--;
					}
					row--;
				// 우측열이 배열을 벗어나지 않으면서 값이 1일 경우 계속해서 우측으로 이동
				// 우측열의 끝에 도달하면 row--
				} else if (col + 1 < 100 && arr[row][col + 1] == 1) {
					while (col + 1 < 100 && arr[row][col + 1] == 1) {
						col++;
					}
					row--;
				// 좌측열도 우측열도 1이 아니면 위로 올라가기
				} else {
					row--;
				}
			}

			System.out.printf("#%d %d\n", t, ans);
		}
	}
}
	// 단순 구현
