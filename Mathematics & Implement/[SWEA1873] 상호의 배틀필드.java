import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];
			int r = 0, c = 0;
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < str.length(); j++) {
					char field = str.charAt(j);
					map[i][j] = field;
					if (field == '<' || field == '>' || field == '^' || field == 'v') {
						// 현재의 탱크 위치를 저장
						r = i;
						c = j;
					}
				}
			}
			int N = Integer.parseInt(br.readLine());
			String cmd = br.readLine();

			// 커맨드의 입력의 길이만큼 반복
			for (int i = 0; i < cmd.length(); i++) {
				// U : 탱크의 바라보는 방향 변경, 평지라면 이동
				if (cmd.charAt(i) == 'U') {
					map[r][c] = '^';
					if (r - 1 >= 0 && map[r - 1][c] == '.') {
						map[r - 1][c] = '^';
						map[r][c] = '.';
						r--;
					}
				}
				// D : 탱크의 바라보는 방향 변경, 평지라면 이동
				else if (cmd.charAt(i) == 'D') {
					map[r][c] = 'v';
					if (r + 1 < H && map[r + 1][c] == '.') {
						map[r + 1][c] = 'v';
						map[r][c] = '.';
						r++;
					}
				}
				// L : 탱크의 바라보는 방향 변경, 평지라면 이동
				else if (cmd.charAt(i) == 'L') {
					map[r][c] = '<';
					if (c - 1 >= 0 && map[r][c - 1] == '.') {
						map[r][c - 1] = '<';
						map[r][c] = '.';
						c--;
					}
				}
				// R : 탱크의 바라보는 방향 변경, 평지라면 이동
				else if (cmd.charAt(i) == 'R') {
					map[r][c] = '>';
					if (c + 1 < W && map[r][c + 1] == '.') {
						map[r][c + 1] = '>';
						map[r][c] = '.';
						c++;
					}
				}
				// S : 미사일 발사
				else if (cmd.charAt(i) == 'S') {
					// 현재 미사일 위치 저장
					int MR = r;
					int MC = c;
					while (true) {
						// 미사일이 범위를 넘어가거나 강철 벽을 만나면 break
						if (MR < 0 || MR >= H || MC < 0 || MC >= W || map[MR][MC] == '#')
							break;
						// 각 위치에서 미사일이 발사되면서 이동, 벽돌로 만들어진 벽을 만나면 부수고 평지가 되며 break
						if (map[r][c] == '^') {
							if (MR - 1 >= 0 && map[MR - 1][MC] == '*') {
								map[--MR][MC] = '.';
								break;
							} else {
								MR--;
							}
						}

						else if (map[r][c] == 'v') {
							if (MR + 1 < H && map[MR + 1][MC] == '*') {
								map[++MR][MC] = '.';
								break;
							} else {
								MR++;
							}
						}

						else if (map[r][c] == '<') {
							if (MC - 1 >= 0 && map[MR][MC - 1] == '*') {
								map[MR][--MC] = '.';
								break;
							} else {
								MC--;
							}
						}

						else if (map[r][c] == '>') {
							if (MC + 1 < W && map[MR][MC + 1] == '*') {
								map[MR][++MC] = '.';
								break;
							} else {
								MC++;
							}
						}
					}
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			sb.delete(sb.length() - 1, sb.length());
			System.out.println(sb);
		}
	}
}
