package day01_Ŭ�����⺻;

import java.util.Scanner;

class LadderGame {	
	Scanner sc = new Scanner(System.in);
	int[][] ladder = { 
			{ 0, 0, 0, 0, 0 }, 
			{ 1, 2, 0, 1, 2 }, 
			{ 0, 1, 2, 0, 0 }, 
			{ 0, 0, 0, 1, 2 }, 
			{ 0, 1, 2, 0, 0 },
			{ 1, 2, 0, 0, 0 }, 
			{ 0, 0, 0, 1, 2 }, 
			{ 0, 0, 0, 0, 0 } 
	};

	int xIdx = 0;
	int yIdx = 0;

	String menu = "";
	
	
	void showLadder() {
		System.out.println("  1  2  3  4  5");
		for(int i=0; i<ladder.length; i++) {
			for(int j=0; j<ladder[i].length; j++) {
				if(ladder[i][j] == 0 ) {
					if(xIdx == i && yIdx == j) {
						System.out.print("  *");
					} else {
						System.out.print("  ��");
					}
				} else if(ladder[i][j] == 1) {
					if(xIdx == i && yIdx == j) {
						System.out.print("  * ");
					} else {
						System.out.print("  ����");
					}
				} else if(ladder[i][j] == 2) {
					if(xIdx == i && yIdx == j) {
						System.out.print(" *");
					} else {
						System.out.print("����");
					}
				}
			}
			System.out.println();
		}
		System.out.println("��� ���� ġŲ ���� ����");
		System.out.println();
		
		try {
			Thread.sleep(500);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void moveLadder() {
		showLadder();
		while(true) {
			if(ladder[xIdx][yIdx] == 0) {
				xIdx ++;
				showLadder();
			} else if(ladder[xIdx][yIdx] == 1) {
				yIdx ++;
				showLadder();
				xIdx ++;
				showLadder();
			} else if(ladder[xIdx][yIdx] == 2) {
				yIdx --;
				showLadder();
				xIdx ++;
				showLadder();
			}
			
			if(xIdx == 7) {
				break;
			}
		}
	}
	
	void setMenu() {
		if(yIdx == 0) {
			menu = "���";
		} else if(yIdx == 1) {
			menu = "����";
		} else if(yIdx == 2) {
			menu = "ġŲ";
		} else if(yIdx == 3) {
			menu = "����";
		} else if(yIdx == 4) {
			menu = "����";
		}
	}
	
	void run() {
		showLadder();
		
		xIdx = 0;
		yIdx = 0;
		
		System.out.print("��ȣ�� �����ϼ���(1~5) : ");
		yIdx = sc.nextInt() - 1;
		
		moveLadder();
		
		setMenu();
		System.out.println("������ ���� �޴��� " + menu + " �Դϴ�~!!!");
	}
}

public class day0309_��ٸ����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LadderGame lg = new LadderGame();
		lg.run();
	}

}
