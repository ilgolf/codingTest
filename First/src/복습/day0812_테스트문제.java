package ����;

import java.util.Scanner;

public class day0812_�׽�Ʈ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� 1 >>> ");
		int scr1 = sc.nextInt();
		System.out.println("���� 2 >>> ");
		int scr2 = sc.nextInt();
		System.out.println("���� 3 >>> ");
		int scr3 = sc.nextInt();
		
		int sum = scr1 + scr2 + scr3;
		int avg = sum/3;
		
		String grade = "";
		
		if(90 <= avg && avg <= 100) {
			grade = "A";
			if(avg%10 >= 7) {
				grade = "A+";
			}
		}
		else if(80 <= avg && avg <= 89) {
			grade = "B";
			if(avg%10 >= 7) {
				grade = "B+";
			}
		}
		else if(70<= avg && avg <= 79) {
			grade = "C";
			if(avg%10 >= 7) {
				grade = "C+";
			}
		}
		
		System.out.println("�л��� ���� : " + grade + ", ���" + avg + "��");
	}
}
