package ����;

import java.util.Scanner;

public class day0201_���ڿ��Ӽ��ڰ˻繮�� {
	/*
	 * # ���ڿ� �� ���ڰ˻�
	 * ��) adklajsiod
	 * 	     ���ڸ� �ִ�.
	 * ��) 123123
	 *    ���ڸ� �ִ�.
	 * ��) dasd12312asd
	 *    ���ڿ� ���ڰ� �����ִ�.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		char[] check = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
		System.out.print("�Է� : ");
		String text = scan.next();
		
		int cnt = 0;
		for(int i=0; i<text.length(); i++) {
			for(int j=0; j<check.length; j++) {
				if(text.charAt(i) == check[j]) {
					cnt++;
				}
			}
		}
		
		if(cnt == text.length()) {
			System.out.println("���ڷθ� �̷�����ִ�.");
		}
		else if(cnt == 0) {
			System.out.println("���ڷθ� �̷�����ִ�.");
		}
		else {
			System.out.println("�����ִ�.");
		}
	}

}
