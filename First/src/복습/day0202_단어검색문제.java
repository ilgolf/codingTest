package ����;

import java.util.Scanner;

public class day0202_�ܾ�˻����� {

	/*
	 * # �ܾ� �˻�
	 * 1. �ܾ �Է¹޾� text���� ���� �ӿ� �ش� �ܾ �ִ��� �˻��Ѵ�.
	 * 2. �ܾ �����ϸ� true
	 *    �ܾ ������ false�� ����Ѵ�.
	 */
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String text = "Life is too short.";
		System.out.println(text);
		
		System.out.print("�˻��� �ܾ �Է��ϼ��� : ");
		String word = scan.next();
		
		String[] temp = text.split(" ");
		
		boolean check = false;
		
		for(int i=0; i<temp.length; i++) {
			if(word.equals(temp[i])) {
				check = true;
			}
		}
		
		if(check) {
			System.out.println(check);
		}
		else if(!check) {
			System.out.println(false);
		}
	}
}
