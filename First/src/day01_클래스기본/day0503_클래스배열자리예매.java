package day01_Ŭ�����⺻;

import java.util.Scanner;

class Seat {
	Scanner sc = new Scanner(System.in);
	int cnt;
	int money;
	String name = "";
	boolean check;
	Seat[] seatList = new Seat[8];
	
	void showMenu(String name) {
		System.out.println("===== " + name + " =====");
		System.out.println("1.�����ϱ�");
		System.out.println("2.�����ϱ�");
	}
	
	void Reserve() {
		Seat[] seatList = new Seat[8];
		for(int i=0; i<seatList.length; i++) {
			seatList[i] = new Seat();
		}
		while(true) {
			for(int i=0; i<seatList.length; i++) {
				if(seatList[i].check == true) {
					System.out.print("�� ");
				} else {
					System.out.print("�� ");
				}
			}
			System.out.println();
			System.out.println("1.�¼�����");
			System.out.println("2.�����ϱ�");
			int sel = sc.nextInt();
			if(sel == 1) {
				System.out.println("�¼��� ����ּ���  >>> ");
				int idx = sc.nextInt();
				
				if(seatList[idx].check == false) {
					seatList[idx].check = true;
					cnt++;
				}
				else {
					System.out.println("�̹� ����� �¼��Դϴ�.");
				}
			}
			else if(sel == 2) {
				System.out.println("�� ���� �¼��� " + cnt + "�� �Դϴ�.");
				break;
			}
		}
	}
	
	void exit() {
		money = cnt*12000;
		System.out.println("�� �ݾ��� " + money + "���Դϴ�.");
	}
	
	void run(String name) {
		while(true) {
			showMenu(name);
			int sel = sc.nextInt();
			
			if(sel == 1) {
				Reserve();
			}
			else if(sel == 2) {
				exit();
				break;
			}
		}
	}
}

public class day0503_Ŭ�����迭�ڸ����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Seat lc = new Seat();
		
		String name = "LOTTE CINEMA";
		
		lc.run(name);
	}
}
