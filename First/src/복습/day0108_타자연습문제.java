package ����;

import java.util.Random;
import java.util.Scanner;

public class day0108_Ÿ�ڿ������� {
	/*
	 * # Ÿ�ڿ��� ����[1�ܰ�]
	 * 1. ������ ���´�.(shuffle)
	 * 2. ������� ������ �����ϰ�, ������ �� ���߸� ���� ����
	 * ��)
	 * ���� : mysql
	 * �Է� : mydb
	 * ���� : mysql
	 * �Է� : mysql	<--- ������ ���߸�, ���� ���� ����
	 * ���� : jsp
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		String[] words = {"java", "mysql", "jsp", "spring"};
		
		// shuffle
		for(int i=0; i<1000; i++) {
			int r = ran.nextInt(words.length);
			
			String temp = words[0];
			words[0] = words[r];
			words[r] = temp;
		}
		
		
		int i = 0;
		
		while(i < words.length) {
			System.out.println((i+1) + ". " + words[i]);
			System.out.println("���� �Է� >>> ");
			String str = sc.next();
			
			int cnt = 0;
			if(str.length() == words[i].length()) {
				for(int j=0; j<str.length(); j++) {
					if(str.charAt(j) == words[i].charAt(j)) {
						cnt++;
					}
				}
			}
			
			if(cnt == str.length()) {
				System.out.println("���� !");
				i++;
			}
			else {
				System.out.println("����!");
			}
		}
	}
}
