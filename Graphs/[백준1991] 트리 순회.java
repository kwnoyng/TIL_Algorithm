import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static Node[] node;
	static StringBuilder sb;

	// preOrder 함수 구현 (VLR)
	static void preOrder(int x) {
		if (x == -1)
			return;
		sb.append((char) (x + 'A'));
		preOrder(node[x].left);
		preOrder(node[x].right);
	}

	// inOrder 함수 구현 (LVR)
	static void inOrder(int x) {
		if (x == -1)
			return;
		inOrder(node[x].left);
		sb.append((char) (x + 'A'));
		inOrder(node[x].right);
	}

	// postOrder 함수 구현 (LRV)
	static void postOrder(int x) {
		if (x == -1)
			return;
		postOrder(node[x].left);
		postOrder(node[x].right);
		sb.append((char) (x + 'A'));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 총 노드의 개수만큼 배열 만들기
		node = new Node[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// x : 루트, y : 왼쪽 자식, z : 오른쪽 자식
			int x = st.nextToken().charAt(0) - 'A';
			char y = st.nextToken().charAt(0);
			char z = st.nextToken().charAt(0);

			// left, right의 초기값을 -1로 설정
			int left = -1;
			int right = -1;

			// 자식이 '.'이 아니라면 'A'를 빼준 값을 저장
			if (y != '.')
				left = y - 'A';
			if (z != '.')
				right = z - 'A';

			node[x] = new Node(left, right);
		}

		sb = new StringBuilder();
		preOrder(0);
		sb.append("\n");
		inOrder(0);
		sb.append("\n");
		postOrder(0);

		System.out.println(sb);
	}
}

// 노드 클래스 구현
class Node {
	int left;
	int right;

	Node(int left, int right) {
		this.left = left;
		this.right = right;
	}
}