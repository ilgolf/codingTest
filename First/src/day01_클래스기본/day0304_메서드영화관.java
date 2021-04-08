package day01_Ŭ�����⺻;

import java.util.Scanner;

class Theater{
	
	Scanner sc = new Scanner(System.in);

	int[] seat = new int[10];
	
	String name = "";				// ��ȭ�� �̸�
	int cnt = 0;					// ���� ��
	int money = 0;					// �����
	
	void printSeat() {
		for(int i=0; i<seat.length; i++) {
			if(seat[i] == 0) {
				System.out.print("[ ]\t");
			}else {
				System.out.print("[O]\t");
			}
		}
		System.out.println();
	}
	
	void showMenu(String name) {
		System.out.println("===== " + name + " =====");
		System.out.println("1.�¼� ����");
		System.out.println("2.���� �ϱ�");
	}
	
	void selSeat() {
		
		while(true) {
			System.out.println("===== Sub Menu =====" );
			System.out.println("1. �¼� ����");
			System.out.println("2. ���� �ϱ�");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				printSeat();
				System.out.println("�¼��� ����ּ��� >>> ");
				int idx = sc.nextInt();
				
				if(seat[idx] == 0) {
					seat[idx] = 1;
					cnt++;
				}
				else {
					System.out.println("�ٽ� �Է� ");
				}
			}
			else if(sel == 2) {
				money = cnt*12000;
				System.out.println("�� ���� : " + money);
				break;
			}
		}
		
	}
	
	void exit() {
		System.out.println("�� ����� " + money + "��");
	}
	
	void run(String name) {
		while(true) {
			printSeat();
			showMenu(name);
			int sel = sc.nextInt();
			
			if(sel == 1) {
				selSeat();
			}
			else if(sel == 2) {
				exit();
				break;
			}
		}
	}
}

public class day0304_�޼��念ȭ�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "LOTTE CINEMA";
		Theater lc = new Theater();
		
		lc.run(name);
	}
}
