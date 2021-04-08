package programmers;

import java.util.*;

public class Kakao2019_05 {
	class Node {
		int x;
		int y; 
		int id;
		Node left;   // Ʈ�� ����
		Node right;  // Ʈ�� ������
		
		Node(int x, int y, int id) {
			this.x = x;
			this.y = y;
			this.id = id;
		}
	}
	
	// y��ǥ �� ����
	Comparator<Node> com = new Comparator<Node>() {
		public int compare(Node a, Node b) {
			if(a.y == b.y) {
				return a.x - b.x;
			}
			
			return b.y - a.y;
		}
	};
	
	// ��� �߰� x��ǥ ���� 
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
	
	// ���������� Ž��
	void preorder(int[][] answer, Node node) {
		if(node == null) return;
		
		answer[0][idx++] = node.id;
		preorder(answer, node.left);
		preorder(answer, node.right);
	}
	
	// �Ʒ��ʺ��� �ö���� Ž��
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
		
		// ��̸���Ʈ ����
		list.sort(com);
		
		Node root = list.get(0);  // ��Ʈ ���
		for(int i=1; i<size; i++) {
			addNode(root, list.get(i)); // ��� Ʈ�����·� ����
		}
		
		int[][] answer = new int[2][size];
		preorder(answer, root); // Ž��
		idx = 0; // �ε��� �ʱ�ȭ
		postorder(answer, root); // Ž��
		return answer;
	}
	
	public static void main(String[] args) {
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		
		Kakao2019_05 k = new Kakao2019_05();
		
		int[][] answer = k.solution(nodeinfo);
		System.out.println(Arrays.deepToString(answer));
	}
}
