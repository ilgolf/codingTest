package day01_Ŭ�����⺻;

import java.util.Scanner;

class BurgerShop {
	Scanner sc = new Scanner(System.in);
	
	String name = "";
	int[] arPrice = {   2500,     3800,     1500,      1000};
	String[] arMenu = {"ġ�����", "�Ұ�����", "����Ƣ��", "��        ��"};
	int[] arCount = new int[4];
	int total = 0;
	
	void showMeu() {
		System.out.println("===== " + name + " =====");
		for(int i=0; i<arMenu.length; i++) {
			System.out.println((i+1) + "." + arMenu[i] + ": " + arPrice[i] + "��");
		}
		System.out.println("5.�����ϱ�");
	}
	
	void select1() { arCount[0] ++; }
	void select2() { arCount[1] ++; }
	void select3() { arCount[2] ++; }
	void select4() { arCount[3] ++; }
	
	void getReceipt() {
		System.out.println("===== ������ =====");
		for(int i=0; i<arMenu.length; i++) {
			System.out.println((i+1) + "." + arMenu[i] + ": " + arCount[i] + "��");
			total += arPrice[i] * arCount[i];
		}
		System.out.println("�� �ݾ� : " + total + "��");
	}
	
	void run() {
		while(true) {
			
			showMeu();
			
			System.out.print("�޴��� �����ϼ��� : ");
			int choice = sc.nextInt();
			
			if(choice == 1) { select1(); }
			else if(choice == 2) { select2(); }
			else if(choice == 3) { select3(); }
			else if(choice == 4) { select4(); }
			else if(choice == 5) {
				getReceipt();
				break;
			}
		}
	}
}

public class day0407_��������¾ϱ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BurgerShop moms = new BurgerShop();
		moms.name = "������ġ �ܹ���";
		
		moms.run();
	}

}
