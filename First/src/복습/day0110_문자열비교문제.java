package ����;

import java.util.Scanner;

public class day0110_���ڿ��񱳹��� {
	/*
	 * # ���ڿ� ��
	 * . equals() �޼��� ������ ������ ��ġ���� ��
	 * ��)
	 * �ڳ���
	 * �Է� = Ƽ�����罺
	 * ��� = false
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String name = "�ڳ���";

		System.out.print("���� �̸��� �Է��ϼ��� : "); // ex) Ƽ�����罺
		String myName = scan.next();
		
		int cnt = 0;
		if(name.length() == myName.length()) {
			for(int i=0; i<name.length(); i++) {
				if(name.charAt(i) == myName.charAt(i)) {
					cnt++;
				}
			}
		}
		
		if(cnt == name.length()) {
			System.out.println("����");
		}
		else {
			System.out.println("����");
		}
	}
}
