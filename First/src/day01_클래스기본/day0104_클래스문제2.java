package day01_Ŭ�����⺻;

import java.util.Scanner;

class Ex04 {
	int[] hakbuns = {1001,1002,1003,1004,1005};
	int[] scores = new int[5];
}

public class day0104_Ŭ��������2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Ex04 e = new Ex04();
		System.out.println("����1");
		for(int i=0; i<e.scores.length; i++) {
			System.out.println("�Է� >>> ");
			e.scores[i] = sc.nextInt();
		}
		
		System.out.println("���� 2");
		int tot = 0;
		double avg = 0;
		for(int i=0; i<e.scores.length; i++) {
			tot += e.scores[i];
		}
		avg = tot/e.scores.length;
		System.out.println("���� : " + tot);
		System.out.println("��� : " + avg);
		
		System.out.println("���� 3");
		int count = 0;
		for(int i=0; i<e.scores.length; i++) {
			if(e.scores[i] > 60) {
				count ++;
			}
		}
		System.out.println("�հ��� �� : " + count);
		
		System.out.println("���� 4");
		System.out.println("�ε��� �Է� >>> ");
		int idx = sc.nextInt();
		System.out.println(e.scores[idx]);
		
		System.out.println("���� 5");
		System.out.println("���� �Է� >>> ");
		int score = sc.nextInt();
		for(int i=0; i<e.scores.length; i++) {
			if(score == e.scores[i]) {
				idx = i;
			}
		}
		System.out.println(idx);
		
		System.out.println("���� 6");
		System.out.println("�й� �Է� >>> ");
		int num = sc.nextInt();
		
		for(int i=0; i<e.hakbuns.length; i++) {
			if(num == e.hakbuns[i]) {
				System.out.println(e.scores[i]);
			}
		}
		
		System.out.println("���� 7");
		idx = -1;
		System.out.println("�й� �Է� >>> ");
		num = sc.nextInt();
		
		for(int i=0; i<e.hakbuns.length; i++) {
			if(num == e.hakbuns[i]) {
				idx = i;
			}
		}
		if(idx == -1) {
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
		}
		else {
			System.out.println(e.scores[idx]);
		}
		
		System.out.println("���� 8");
		int maxNum = e.scores[0];
		int maxIdx = 0;
		for(int i=0; i<e.scores.length; i++) {
			if(maxNum < e.scores[i]) {
				maxNum = e.scores[i];
				maxIdx = i;
			}
		}
		
		System.out.println("1��  = " + e.hakbuns[maxIdx] + " : " + maxNum);
	}

}
