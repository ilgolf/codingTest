package ����;

import java.util.Scanner;

public class day1309_�׽�Ʈ����3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int game[] = { 0, 2, 0, 2, 8, 0, 0, 4, 0 };

		// 1)left , 2)right
		
		// ����1)��ȣ�� �Է¹ް� ���������� ���ڸ������ÿ�.
		// ����) ���࿡ ��������2���� �پ������� ���� ��������.
		// �Ʒ� 2�ܰ����
		// ��) left
		// 1�ܰ� : {2,2,8,4,0,0,0,0,0};
		// 2�ܰ� : {4,8,4,0,0,0,0,0,0}; 2�� 2���پ����� 4���ȴ�.
		
		System.out.println("1)left  2)Right");
		int sel = sc.nextInt();
		
		if(sel == 1) {
			for(int i=0; i<game.length-1; i++) {
				for(int j=0; j<game.length-1; j++) {
					if(game[j] == 0 && game[j+1] != 0) {
						int temp = game[j];
						game[j] = game[j+1];
						game[j+1] = temp;
					}
					if(game[j] == game[j+1]) {
						game[j] += game[j+1];
					}
				}
			}
			
			for(int i=0; i<game.length; i++) {
				System.out.print(game[i]);
			}
		}
		else if(sel == 2) {
			for(int i=game.length-1; i>0; i--) {
				for(int j=game.length-1; j>0; j--) {
					if(game[j] == 0 && game[j-1] != 0) {
						int temp = game[j];
						game[j] = game[j-1];
						game[j-1] = temp;
					}
					if(game[j] == game[j-1]) {
						game[j] += game[j-1];
					}
				}
			}
			
			for(int i=0; i<game.length; i++) {
				System.out.print(game[i]);
			}
		}
	}
}