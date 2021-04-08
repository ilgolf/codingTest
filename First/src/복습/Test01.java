package 복습;

class Node {
	String data;
	Node next;
}

class LinkedList{
	Node head;
	int size;
	
	void insertNodeLast(String data) {
		Node node = new Node();
		node.data = data;
		if(size == 0) {
			head = node;
		} else {
			Node pre = head;
			for(int i=0; i<size - 1; i++) {
				pre = pre.next;
			}
			pre.next = node;
		}
		size += 1;
	}
	
	void printLinkedList() {
		System.out.println("---------------------------");
		Node pre = head;
		for(int i=0; i<size; i++) {
			System.out.println(i + 1 + " " + pre.data);
			pre = pre.next;
		}
		
		System.out.println();
		System.out.println("---------------------------");
	}
	
	void insertNodePos(String data, int pos) {
		if(pos < 0) return;
		if(pos > size) return;
		
		Node node = new Node();
		node.data = data;
		if(pos == 0) {
			node.next = head;
			head = node;
		}
		else {
			Node pre = head;
			for(int i=0; i<pos - 1; i++) {
				pre = pre.next;
			}
			node.next = pre.next;
			pre.next = node;
		}
		size += 1;
	}
	
	void removeFirst() {
		Node node = new Node();
		
		if(head == null) {
			System.out.println("삭제할 값이 없습니다.");
		} else {
			Node pre = head;
			head = pre.next;
			
			pre = null;
			size --;
		}
	}
	void remove(int pos) {
		Node pre1 = head;
		Node pre2 = null;
		
		if(pos > size) return;
		
		if(pos == 0) {
			removeFirst();
		} else {
			for(int i=0; i<pos - 1; i++) {
				pre1 = pre1.next;
			}
			
			pre2 = pre1.next;
			pre1.next = pre2.next;
			pre2.next = null;
			size --;
		}
	}
	
	LinkedList sort() {
		LinkedList tempList = new LinkedList();
		
		return tempList;
	}
	LinkedList reverseList() {
		LinkedList tempList = new LinkedList();
		Node pre = head;
		for(int i=0; i<size; i++) {
			tempList.insertNodePos(pre.data, 0);
			pre = pre.next;
		}
		return tempList;
	}
}


public class Test01 {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertNodeLast("a");
		list.insertNodeLast("b");
		list.insertNodeLast("c");
		list.insertNodeLast("d");
		list.printLinkedList();
		list.insertNodePos("e" , 0);
		list.printLinkedList();
		list.insertNodePos("f" , 1);
		list.printLinkedList();
		list.insertNodePos("g" , 6);
		list.printLinkedList();
		list = list.reverseList();
		list.printLinkedList();
		list.removeFirst();
		list.printLinkedList();
		list.remove(3);
		list.printLinkedList();
	}
}
