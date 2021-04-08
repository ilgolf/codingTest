package day01_Ŭ�����⺻;

import java.util.Random;
import java.util.Scanner;

class Test3 {
	Random ran = new Random();
	Scanner sc = new Scanner(System.in);
	
	void problem1(int[] scores) {
		System.out.println("���� 1");
		for(int i=0; i<scores.length; i++) {
			scores[i] = ran.nextInt(100) + 1;
			System.out.print(scores[i] + " ");
		}
		System.out.println();
	}
	
	void problem2(int[] scores) {
		int sum = 0;
		System.out.println("���� 2");
		for(int i=0; i<scores.length; i++) {
			sum += scores[i];
		}
		int avg = sum/scores.length;
		System.out.println("���� (" + sum + "), " + "��� (" + avg + ")");
	}
	
	void problem3(int[] scores) {
		int count = 0;
		System.out.println("���� 3");
		for(int i=0; i<scores.length; i++) {
			if(scores[i] > 60) {
				count ++;
			}
		}
		System.out.println("�հ��� : " + count + "��");
	}
	
	void problem4(int[] scores) {
		System.out.println("���� 4");
		
		System.out.println("idx >>> ");
		int idx = sc.nextInt();
		
		System.out.println(scores[idx]);
		
	}
	void problem5(int[] scores) {
		System.out.println("���� 5");
		
		System.out.println("score >>> ");
		int score = sc.nextInt();
		
		
		int check = -1;
		for(int i=0; i<scores.length; i++) {
			if(score == scores[i]) {
				check = i;
			}
		}
		if(check == -1) {
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
		}
		else {
			System.out.println(score);
		}
	}
	void problem6(int[] scores, int[] hakbuns) {
		System.out.println("���� 6");
		
		System.out.println("�й� >>> ");
		int hakbun = sc.nextInt();
		
		int idx = -1;
		for(int i=0; i<scores.length; i++) {
			if(hakbun == hakbuns[i]) {
				idx = i;
			}
		}
		if(idx == -1) {
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
		}
		else {
			System.out.println(idx);
		}
	}
	
	void problem8(int[] scores, int[] hakbuns) {
		int maxNum = scores[0];    int maxIdx = 0;
		System.out.println("���� 8");
		
		for(int i=0; i<scores.length; i++) {
			if(maxNum < scores[i]) {
				maxNum = scores[i];
				maxIdx = i;
			}
		}
		
		System.out.println("1�� �л� : " + hakbuns[maxIdx] + ", ���� : " + maxNum + "��");
	}
}

public class day0303_��������3 {

	public static void main(String[] args) {
		
		// ����1) scores�迭�� 1~100�� ������ ���� ������ 5�� ����
				// �� 1) 87, 11, 92, 14, 47

				// ����2) �������� ������ ��� ���
				// �� 2) ����(251) ���(50.2)

				// ����3) ������ 60�� �̻��̸� �հ�. �հݻ� �� ���
				// �� 3) 2��

				// ����4) �ε����� �Է¹޾� ���� ���
				// ����4) �ε��� �Է� : 1 ���� : 11��

				// ����5) ������ �Է¹޾� �ε��� ���
				// ����5) ���� �Է� : 11 �ε��� : 1

				// ����6) �й��� �Է¹޾� ���� ���
				// ����6) �й� �Է� : 1003 ���� : 45��

				// ����7) �й��� �Է¹޾� ���� ���
				// ��, �����й� �Է� �� ����ó��
				// �� 7)
				// �й� �Է� : 1002 ���� : 11��
				// �й� �Է� : 1000 �ش��й��� �������� �ʽ��ϴ�.

				// ����8) 1���л��� �й��� ���� ���
				// ����8) 1004��(98��)
		
		Test3 t = new Test3();

		int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
		int[] scores = new int[5];
		
		t.problem1(scores);
		
		t.problem2(scores);
		
		t.problem3(scores);
		
		t.problem4(scores);
		
		t.problem5(scores);
		
		t.problem6(scores, hakbuns);
		
		t.problem8(scores, hakbuns);
	}

}
