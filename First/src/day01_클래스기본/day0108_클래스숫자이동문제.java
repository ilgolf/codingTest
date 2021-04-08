package day01_Ŭ�����⺻;

import java.util.Scanner;

class Ex08{
	int[] game = {0, 0, 1, 0, 2, 0, 0, 1, 0};
	int player = 4;
}

/*
 * # �����̵�[3�ܰ�] : Ŭ���� + ����
 * 1. ����2�� ĳ�����̴�.
 * 2. ����1�� �Է��ϸ�, ĳ���Ͱ� ��������
 * 	    ����2�� �Է��ϸ�, ĳ���Ͱ� ���������� �̵��Ѵ�.
 * 3. ���� 1�� ���̴�. ���� ������ �̵��� �� ����.
 * 4. ��, ����3�� �Է��ϸ�, ���� ������ �� �ִ�.
 * 5. �¿� ���� �����ص� ��� �ݴ������� �̵��� �����ϴ�.
 * ��) 
 *  0 0 0 0 0 0 0 2 
 *  ����(1) ������(2) : 2
 *  
 *  2 0 0 0 0 0 0 0 
 */

public class day0108_Ŭ���������̵����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Ex08 e = new Ex08();
		
		while(true) {
			for(int i=0; i<e.game.length; i++) {
				if(e.game[i] == 2) {
					System.out.print("[P] ");
				}
				else if(e.game[i] == 1) {
					System.out.print("[W] ");
				}
				else {
					System.out.print("[ ] ");
				}
			}
			
			System.out.println("===== PLAY THE GAME =====");
			System.out.println("1. move Left");
			System.out.println("2. move Right");
			System.out.println("3. destroy wall");
			System.out.println("=========================");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				if(e.player > 0) {
					if(e.game[e.player - 1] == 1) {
						System.out.println("sorry, l cant move because wall block Way");
					}
					else {
						e.game[e.player] = 0;
						e.player --;
						e.game[e.player] = 2;
					}
				} 
			}
			else if(sel == 2) {
				if(e.player < e.game.length) {
					if(e.game[e.player + 1] == 1) {
						System.out.println("sorry, l cant move because wall block Way");
					}
					else {
						e.game[e.player] = 0;
						e.player ++;
						e.game[e.player] = 2;
					}
				}
			}
			else if(sel == 3) {
				if(e.game[e.player + 1] == 1) {
					e.game[e.player + 1] = 0;
					System.out.println("broken wall");
				}
				if(e.game[e.player - 1] == 1) {
					e.game[e.player - 1] = 0;
					System.out.println("broken wall");
				}
			}
		}
	}
}