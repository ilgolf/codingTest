package ����;

import java.util.Random;
import java.util.Scanner;

public class day0109_Ÿ�ڿ���2���� {
	/*
	 * # Ÿ�ڿ��� ����[2�ܰ�]
	 * 1. ������ ���´�.(shuffle)
	 * 2. ������� ������ �����ϰ�, ������ �� ���߸� ���� ����
	 * 3. �� ������ ������ ��, �ܾ��� ������ ��ġ �� ���� *�� ���
	 * ��)
	 * ���� : mys*l
	 * �Է� : mysql	<--- ������ ���߸�, ���� ���� ����
	 * ���� : *sp
	 * �Է� : jsp
	 * ...
	 */
	
	public static void main(String[] args) {
		String[] words = {"java", "mysql", "jsp", "spring"};
		
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		for(int i=0; i<words.length; i++) {
			int r = ran.nextInt(words.length);
			
			String temp = words[0];
			words[0] = words[r];
			words[r] = temp;
		}
		
		int i = 0;
		while(i < words.length) {
			int r = ran.nextInt(words.length);
			
			for(int j=0; j<words[i].length(); j++) {
				if(j == r) {
					System.out.print("*");
				}
				else if(j != r) {
					System.out.print(words[i].charAt(j));
				}
			}
			System.out.println();
			
			System.out.println("���� >>> ");
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
