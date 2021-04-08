package chap6day02_ÄÝ·º¼Ç2;

import java.util.*;

class Node1to50{
	int front;
	int back;
	
	void printNode() {
		System.out.print(front + "\t");
	}
}

class Manager1to50 {
	Vector<Node1to50[]> nodeList;
	int[][] data1;
	int[][] data2;
	final int SIZE = 5;
	
	void dataInit() {
		data1 = new int[SIZE][SIZE];
		data2 = new int[SIZE][SIZE];
		int num = 1;
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				data1[i][j] = num++;
			}
		}
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				data2[i][j] = num++;
			}
		}
	}
	
	void shuffle() {
		Random ran = new Random();
		for(int i=0; i<1000; i++) {
			int r1 = ran.nextInt(SIZE);
			int r2 = ran.nextInt(SIZE);
			
			int temp = data1[0][0];
			data1[0][0] = data1[r1][r2];
			data1[r1][r2] = temp;
			
			temp = data2[0][0];
			data2[0][0] = data2[r1][r2];
			data2[r1][r2] = temp;
		}
	}
	
	void nodeInit() {
		nodeList = new Vector<>();
		
		for(int i=0; i<SIZE; i++) {
			Node1to50[] temp = new Node1to50[SIZE];
			for(int j=0; j<SIZE; j++) {
				Node1to50 node = new Node1to50();
				node.front = data1[i][j];
				node.back = data2[i][j];
				
				temp[j] = node;
			}
			nodeList.add(temp);
		}
	}
	
	void showMenu() {
		System.out.println("=============== 1 to 50 =============");
		printNodeList();
		System.out.println("=====================================");
	}
	
	void printNodeList() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				nodeList.get(i)[j].printNode();
			}
			System.out.println();
		}
	}
	
	void run() {
		Scanner sc = new Scanner(System.in);
		
		dataInit();
		shuffle();
		nodeInit();
		
		int cnt = 1;
		while(true) {
			showMenu();
			System.out.println("enter Y (1~5) >>> ");
			int y = sc.nextInt() - 1;
			System.out.println("enter X (1~5) >>> ");
			int x = sc.nextInt() - 1;
			
			if(nodeList.get(y)[x].front == cnt) {
				nodeList.get(y)[x].front = nodeList.get(y)[x].back;
				cnt++;
			}
			if(cnt == 50) {
				break;
			}
		}
	}
}

public class Day0202_1to50 {

	public static void main(String[] args) {
		Manager1to50 nm = new Manager1to50();
		nm.run();
	}
}
