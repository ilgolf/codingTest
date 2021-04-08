package _09_tree;

import java.util.*;

class Node {
	int key;
	Node left;
	Node right;
	boolean check;
	
	Node(int key) {
		this.key = key;
	}
}

class Tree {
	Node root;
	Tree() {
		
	}
	void insert(int key) {                // 키 삽입 메서드
		if(root == null) {
			root = new Node(key);
			System.out.println("root : " + key);      // root노드가 없을경우 새로운 값을 저장
			return;
		}
		if(findKey(key)) {
			System.out.println("중복키 : " + key);       // 입력한 값이 트리구조안에 있을경우 저장하지않고 리턴
			return;
		}
		
		Node cur = root;
		while(true) {
			if(cur.key > key) {                      // 현재 값보다 작을시 left에 저장
				if(cur.left == null) { 				 // 왼쪽값이 null일 경우 왼쪽에 새로운 노드를 만들어 저장
					cur.left = new Node(key);
					System.out.println("left : " + key);
					return;
				}
				cur = cur.left;                      // null이 아닐경우 left에 바로 저장
			}
			if(cur.key < key) {						 // 저장된 값 기준 key보다 클때 오른쪽에 저장
				if(cur.right == null) {
					cur.right = new Node(key);       // 오른쪽값이 null일 경우 오른쪽에 새로운 노드를 만들어 저장
					System.out.println("right : " + key);
					return;
				}
				cur = cur.right;
			}
		}
	}
	
	boolean findKey(int key) {
		Node cur = root;
		while(true) {
			if(cur.key == key) {           // 루트 노드부터 내려오면서 같을시 true 리턴 작을시 left탐색 클시에는 right탐색 
				return true;
			}
			if(cur.key > key) {
				if(cur.left != null) {
					cur = cur.left;
				} else {
					return false;
				}
			}
			if(cur.key < key) {
				if(cur.right != null) {
					cur = cur.right;
				} else {
					return false;
				}
			}
		}
	}
	
	// 출력
	void printTree() {
		System.out.println("------------------------");
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		while(true) {
			if(stack.size() == 0) {
				break;
			}
			Node top = stack.peek();
			while(true) {
				if(top.left == null ) {
					break;
				}
				if(top.check == true) {
					break;
				}
				top.check = true;
				top = top.left;
				stack.push(top);
			}
			top = stack.peek();
			System.out.println(top.key + " ");
			top.check = false;
			stack.pop();
			if(top.right != null) {
				top = top.right;
				stack.push(top);
			}
		}
		System.out.println("------------------------");
	}
	
	void remove(int key) {
		if(findKey(key) == false) {             // 탐색했을때 없을경우 삭제 불가
			System.out.println("삭제 불가");
			return;
		}
		
		Node par = root;
		Node cur = root;
		while(true) {
			if(cur.key == key) {         
				break;
			}
			if(cur.key > key) {
				par = cur;
				cur = cur.left;
			}
			if(cur.key < key) {
				par = cur;          // 파라미터에 cur값을 저장하고 cur값에 오른쪽에 있는 값을 갖고온다.
				cur = cur.right;
			}
		}
		
		if(cur.left == null && cur.right == null) {
			if(cur == root) {
				root = null;       // 삭제할값이 root노드이고 left, right모두 null값일경우 트리구조를 null로 변경하고 리턴
				return;
			}
			
			if(par.left == cur) {
				par.left = null;    // 파라미터값이 현재값과 같을경우 파라미터값 null
			}
			else if(par.right == cur) {
				par.right = null;
			}
		} else if(cur.left == null || cur.right == null) {
			if(cur == root) {
				if(root.left != null) {
					root = root.left;
				} else if(root.right != null) {
					root = root.right;
				}
				return;
			}
			if(par.left == cur) {
				if(cur.left != null) {
					par.left = cur.left;
				}
				else if(cur.right != null) {
					par.left = cur.right;
				}
			}
			
			else if(par.right == cur) {
				if(cur.left != null) {
					par.right = cur.left;
				}
				else if(cur.right != null) {
					par.right = cur.right;
				}
			}
		} else {
			Node par2 = cur;
			Node cur2 = cur.right;
			while(true) {
				if(cur2.left == null) {
					break;
				}
				par2 = cur2;
				cur2 = cur2.left;
			}
			System.out.println("후보키 : " + cur2.key);
			if(par2.left == cur2) {
				par2.right = cur2.right;
			}
			cur.key = cur2.key;
			cur = cur2;
			cur = null;
		}
	}
}

public class Tree02 {
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insert(10);
		tree.insert(10);
		tree.insert(13);
		tree.insert(43);
		tree.insert(33);
		tree.insert(47);
		tree.printTree();
		//tree.printTree();
		tree.remove(43);
		tree.printTree();
	}
}
