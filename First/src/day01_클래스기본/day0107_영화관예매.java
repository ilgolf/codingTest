package day01_Ŭ�����⺻;

import java.util.Scanner;

/*
 * # ��ȭ�� �¼����� : Ŭ���� + ����
 * 1. ����ڷκ��� �¼���ȣ(index)�� �Է¹޾� �����ϴ� �ý����̴�.
 * 2. ���Ű� �Ϸ�Ǹ� �ش� �¼� ���� 1�� �����Ѵ�.
 * 3. �̹� ���Ű� �Ϸ�� �¼��� �籸���� �� ����.
 * 4. �� �¼��� ���� ������ 12000���̴�.
 * 5. ���α׷� ���� ��, �ش� ��ȭ���� �� ������� ����Ѵ�.
 * ��)
 * seat = 0 0 0 0 0 0 0
 * 
 * �¼����� : 1
 * seat = 0 1 0 0 0 0 0
 * 
 * �¼����� : 3
 * seat = 0 1 0 1 0 0 0
 * 
 * �¼����� : 3
 * seat = 0 1 0 1 0 0 0
 * �̹� ���Ű� �Ϸ�� �ڸ��Դϴ�.
 * ----------------------
 * ����� : 24000��
 */

class Ex07{
	int[] seat = new int[7];
	int money = 0;
}

public class day0107_��ȭ������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Ex07 e = new Ex07();
		
		while(true) {
			System.out.println("[MEGA MOVIE]");
			System.out.println("[1]reservation Seat");
			System.out.println("[2]exit program");
			
			System.out.print("select menu : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				while(true) {
					System.out.print("seat state : ");
					for(int i=0; i<e.seat.length; i++) {
						if(e.seat[i] == 0) {
							System.out.print("[ ] ");
						}
						else {
							System.out.print("[O] ");
						}
					}
					System.out.println();
					
					System.out.println("===== subMenu =====");
					System.out.println("1. reservation Seat");
					System.out.println("2. finish reservation");
					
					System.out.println("choice subMenu >>> ");
					int choice = sc.nextInt();
					
					if(choice == 1) {
						System.out.println("select SeatNo >>> ");
						int num = sc.nextInt();
						
						e.seat[num] = 1;
						e.money += 12000;
					}
					else if(choice == 2) {
						System.out.println("finish reservation");
						break;
					}
				}
			}
			else if(sel == 2) {
				System.out.println("total amount : " + e.money + "$");
				break;
			}
		}
	}
}
