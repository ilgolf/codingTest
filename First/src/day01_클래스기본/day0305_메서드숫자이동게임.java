package day01_Ŭ�����⺻;

import java.util.Scanner;

/*
 * # ���� �̵��ϱ� : Ŭ���� + �޼���
 * 1. ���� 8�� ĳ�����̴�.
 * 2. ���� 1�� �Է��ϸ�, ĳ���Ͱ� �������� �̵��Ѵ�.
 * 3. ���� 2�� �Է��ϸ�, ĳ���Ͱ� �����������̵��Ѵ�.
 * 4. �¿� ���� �������� �� ������ �߻����� �ʵ��� ����ó���� ���ش�.
 */

class NumberGame{
	Scanner sc = new Scanner(System.in);

	int[] move = {0, 0, 0, 0, 8, 0, 0, 0, 0, 0};
	int player = 4;
	
	void printGame() {
		for(int i=0; i<move.length; i++) {
			if(move[i] == 8) {
				System.out.print("[��] ");
			}
			else if(move[i] == 0) {
				System.out.print("[ ] ");
			}
		}
		System.out.println();
	}
	
	void showMenu() {
		System.out.println("===== Number Move Game =====");
		System.out.println("1. ���� �̵�");
		System.out.println("2. ������ �̵�");
		System.out.println("3. ����");
	}
	
	void Left() {
		if(player-1 >= 0) {
			move[player] = 0;
			player --;
			move[player] = 8;
		}
		else if(player-1 < 0) {
			System.out.println("���̻� ������ �� �����ϴ�.");
		}
	}
	
	void Right() {
		if(player+1 < move.length) {
			move[player] = 0;
			player ++;
			move[player] = 8;
		}
		else if(player+1 >= move.length) {
			System.out.println("���̻� ������ �� �����ϴ�.");
		}
	}
	
	void run() {
		while(true) {
			printGame();
			showMenu();
			int sel = sc.nextInt();
			
			if(sel == 1) {
				Left();
			}
			else if(sel == 2) {
				Right();
			}
			else if(sel == 3) {
				System.out.println("exit program");
				break;
			}
		}
	}
}
public class day0305_�޼�������̵����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberGame ng = new NumberGame();
		
		ng.run();
	}

}
