package ����;

import java.util.Random;

public class day1101_�����л����� {
	
	/*
	 * # �����л�
	 * 1. 10ȸ �ݺ��� �Ѵ�.
	 * 2. 1~100 ������ ���� ���ڸ� �����Ѵ�.(�л��� ����)
	 * 3. ������ 60�� �̻��̸� �հݻ��̴�.
	 * ---------------------------------------
	 * . ������(10��)�� ������ ����� ����Ѵ�.
	 * . �հ��� ���� ����Ѵ�.
	 * . 1�� �л��� ��ȣ�� ������ ����Ѵ�.
	 */

	public static void main(String[] args) {
		Random ran = new Random();
		
		int i=0; 
		double sum = 0;
		double avg = 0;
		int cnt = 0;
		int max = 0;
		int max_score = 0;
		while(i<10) {
			int r = ran.nextInt(100) + 1;
			
			sum += r;
			avg = sum/10;
			
			if(r >= 60) {
				cnt ++;
			}
			
			if(max < r) {
				max = i;
				max_score = r;
			}
			i++;
		}
		System.out.println(sum + " : " + avg);
		System.out.println("�հ��� = " + cnt + "��");
		System.out.println("1�� " + max + " : " + max_score);
	}
}
