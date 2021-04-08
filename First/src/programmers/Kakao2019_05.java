package programmers;

import java.util.*;

public class Kakao2019_05 {
	class Node {
		int x;
		int y; 
		int id;
		Node left;   // 트리 왼쪽
		Node right;  // 트리 오른쪽
		
		Node(int x, int y, int id) {
			this.x = x;
			this.y = y;
			this.id = id;
		}
	}
	
	// y좌표 순 정렬
	Comparator<Node> com = new Comparator<Node>() {
		public int compare(Node a, Node b) {
			if(a.y == b.y) {
				return a.x - b.x;
			}
			
			return b.y - a.y;
		}
	};
	
	// 노드 추가 x좌표 기준 
	void addNode(Node Parent, Node child) {
		if(child.x < Parent.x) {
			if(Parent.left == null) {
				Parent.left = child;
			} else {
				addNode(Parent.left, child);
			}
		} else {
			if(Parent.right == null) {
				Parent.right = child;
			} else {
				addNode(Parent.right, child);
			}
		}
	}
	
	// 위에서부터 탐색
	void preorder(int[][] answer, Node node) {
		if(node == null) return;
		
		answer[0][idx++] = node.id;
		preorder(answer, node.left);
		preorder(answer, node.right);
	}
	
	// 아래쪽부터 올라오며 탐색
	void postorder(int[][] answer, Node node) {
		if(node == null) return;
		
		postorder(answer, node.left);
		postorder(answer, node.right);
		
		answer[1][idx++] = node.id;
	}
	
	int idx = 0;
	List<Node> list = new ArrayList<>();
	
	public int[][] solution(int[][] nodeinfo) {
		int size = nodeinfo.length;
		
		for(int i=0; i<size; i++) {
			int x = nodeinfo[i][0];
			int y = nodeinfo[i][1];
			
			list.add(new Node(x, y, i+1));
		}
		
		// 어레이리스트 정렬
		list.sort(com);
		
		Node root = list.get(0);  // 루트 노드
		for(int i=1; i<size; i++) {
			addNode(root, list.get(i)); // 노드 트리형태로 저장
		}
		
		int[][] answer = new int[2][size];
		preorder(answer, root); // 탐색
		idx = 0; // 인덱스 초기화
		postorder(answer, root); // 탐색
		return answer;
	}
	
	public static void main(String[] args) {
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		
		Kakao2019_05 k = new Kakao2019_05();
		
		int[][] answer = k.solution(nodeinfo);
		System.out.println(Arrays.deepToString(answer));
	}
}
