package ����;

import java.util.Scanner;

public class day0107_�����ձ⹮�� {
	/*
	 * # �����ձ� ����
	 * ���þ� : ������
	 * �Է� : �Ź�
	 * ���þ� : �Ź�
	 * �Է� : �̼�
	 * ...
	 */

	public static void main(String[] args) {
		String start = "������";
		
		Scanner sc = new Scanner(System.in);
		
		int turn = 0;
		
		while(true) {
			System.out.println("���þ� : " + start);
	
			System.out.println("�����ձ� >>> ");
			String str = sc.next();
			
			char ch1 = start.charAt(start.length()-1);
			char ch2 = str.charAt(0);
			
			if(ch1 == ch2) {
				start = str;
				turn ++;
			}
			else {
				continue;
			}
			if(turn == 5) {
				break;
			}
		}
	}
}
