package ����;

import java.util.Scanner;

public class day1104_ATM2���� {
	
	/*
	 * # ATM
	 * 1. �α���
	 * . �α��� �� �� �α��� �Ұ�
	 * . �α׾ƿ� ���¿����� �̿� ����
	 * 2. �α׾ƿ�
	 * . �α��� �� �̿밡��
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int dbAcc1 = 1111;
		int dbPw1 = 1234;
		
		int dbAcc2 = 2222;
		int dbPw2 = 2345;
		
		int log = -1;						// -1(�α׾ƿ�), 1(dbAcc1�α���), 2(dbAcc2�α���)
		
		boolean run = true;
		while(run) {
			
			if(log == 1) {
				System.out.println("#�α��� ���� : " + dbAcc1 + "�α��� ��....");
			}
			else if(log == 2) {
				System.out.println("#�α��� ���� : " + dbAcc2 + "�α��� ��....");
			}
			else  {
				System.out.println("#�α��� ���� :" + "�α��� ���ּ���.");
			}
			System.out.println("1.�α���");
			System.out.println("2.�α׾ƿ�");
			System.out.println("0.����");
			
			System.out.print("�޴� ���� : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				if(log == -1) {
					System.out.println("ID >>> ");
					int acc = sc.nextInt();
					System.out.println("PW >>> ");
					int pw = sc.nextInt();
					
					if(acc == dbAcc1 && pw == dbPw1) {
						log = 1;
						System.out.println(dbAcc1 + "�� ȯ���մϴ�.");
					}
					else if(acc == dbAcc2 && pw == dbPw2) {
						log = 2;
						System.out.println(dbAcc2 + "�� ȯ���մϴ�.");
					}
					else {
						System.out.println("�α��� ���� !");
					}
				}
				else {
					System.out.println("�̹� �α��� ���Դϴ�.");
				}
			}
			else if(sel == 2) {
				if(log == -1) {
					System.out.println("�̹� �α׾ƿ� �����Դϴ�.");
				}
				else {
					log = -1;
					System.out.println("�ȳ��� ���ʽÿ�");
				}
			}
			else if(sel == 0) {
				run = false;
				System.out.println("���α׷� ����");
			}
		}
	}
}
