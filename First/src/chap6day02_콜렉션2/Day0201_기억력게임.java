package chap6day02_콜렉션2;

import java.util.*;

class Node {
	int front;
	int back;
}

class MemoryGame {
	Vector<Node> nodeList;
	int[] data;
	final int SIZE = 10;
	Scanner sc = new Scanner(System.in);
	
	void shuffle() {
		Random ran = new Random();
		for(int i=0; i<1000; i++) {
			int r = ran.nextInt(data.length);
			int temp = data[r];
			data[r] = data[0];
			data[0] = temp;
		}
	}
	void dataInit() {
		data = new int[SIZE];
		for(int i=0; i<SIZE; i++) {
			data[i] = (i+2)/ 2;
		}
	}
	
	void nodeInit() {
		nodeList = new Vector<>();
		for(int i=0; i<SIZE; i++) {
			Node node = new Node();
			node.front = data[i];
			nodeList.add(node);
		}
	}
	void init() {
		dataInit();
		shuffle();
		nodeInit();
	}
	void print() {
		System.out.println("-------------------");
		for(int i=0; i<SIZE; i++) {
			if(nodeList.get(i).back == 0) {
				System.out.print("[ ]");
			} else {
				System.out.print("[" + nodeList.get(i).back + "]");
			}
		}
		System.out.println();
		System.out.println("-------------------");
	}
	
	void update() {
		while(true) {
			print();
			System.out.println("인덱스1 을 입력하세요 >>> ");
			int sel1 = sc.nextInt();
			System.out.println("인덱스2 를 입력하세요 >>> ");
			int sel2 = sc.nextInt();
			nodeList.get(sel1).back = nodeList.get(sel1).front;
			nodeList.get(sel2).back = nodeList.get(sel2).front;
			print();
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			if(nodeList.get(sel1).back != nodeList.get(sel2).back || sel1 == sel2) {
				nodeList.get(sel1).back = 0;
				nodeList.get(sel2).back = 0;
			}
		}
	}
}

public class Day0201_기억력게임 {

	public static void main(String[] args) {
		MemoryGame mg = new MemoryGame();
		mg.init();
		mg.update();
		
	}
}
