package day01_Ŭ�����⺻;

import java.util.Scanner;

class User {
	String id;
	int money;
}

public class day0507_ȸ������1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int max = 100;
		User[] user = new User[max];
		for(int i=0; i<100; i++) {
			user[i] = new User();
		}
		int count = 0;
		int n=0;
		while(n == 0) {
			System.out.println("1.ȸ������");
			System.out.println("2.Ż��");
			System.out.println("3.���");
			System.out.println("4.�α���");
			System.out.println("5.�α׾ƿ�");
			System.out.println("6.�Ա�");
			System.out.println("7.��ü");
			int sel = sc.nextInt();
			if(sel == 1) {
				System.out.println("�̸��� �Է��ϼ��� >>> ");
				user[count].id = sc.next();
				System.out.println("�ݾ��� �Է��ϼ��� >>> ");
				user[count].money = sc.nextInt();
				count++;
			}
			else if(sel == 2) {
				System.out.println("�ε����� �Է��ϼ��� >>> ");
				int idx = sc.nextInt();
				for(int i=idx; i<count-1; i++) {
					user[i] = user[i+1];
				}
				count --;
			}
			else if(sel == 3) {
				for(int i=0; i<count; i++) {
					System.out.println(i+1 + "��) " + user[i].id + " : " + user[i].money + "��");
				}
			}
			else if(sel == 4) {
				System.out.println("");
			}
		}
	}

}
