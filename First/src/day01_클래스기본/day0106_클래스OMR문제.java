package day01_Ŭ�����⺻;

import java.util.Random;

class Ex06{
	int[] answer = {1, 3, 4, 2, 5};		// ������
	int[] hgd = new int[5];				// �л����
	
	int cnt = 0;						// ���� ���� ����
	int score = 0;						// ����
}

/*
 * # OMRī�� : Ŭ���� + ����
 * 1. �迭 answer�� ���蹮���� �������̴�.
 * 2. �迭 hgd�� 1~5 ������ ���� ���� 5���� �����Ѵ�.
 * 3. answer�� hgd ���� ���� ����ǥ�� ����Ѵ�.
 * 4. �� ������ 20���̴�.
 * ��)
 * answer = {1, 3, 4, 2, 5}
 * hgd    = {1, 1, 4, 4, 3}
 * ����ǥ     = {O, X, O, X, X}
 * ����        = 40��
 */

public class day0106_Ŭ����OMR���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random ran = new Random();
		Ex06 e = new Ex06();
		
		System.out.print("Answer = { ");
		for(int i=0; i<e.answer.length; i++) {
			System.out.print(e.answer[i] + " ");
		}
		System.out.println("}");
		
		for(int i=0; i<e.hgd.length; i++) {
			int r = ran.nextInt(5) + 1;
			e.hgd[i] = r;
		}
		
		System.out.print("MyAnswer = { ");
		for(int i=0; i<e.hgd.length; i++) {
			System.out.print(e.hgd[i] + " ");
		}
		System.out.println("}");
		
		System.out.print("Errata = { ");
		for(int i=0; i<e.hgd.length; i++) {
			if(e.hgd[i] == e.answer[i]) {
				System.out.print("O ");
				e.cnt ++;
			}
			else {
				System.out.print("X ");
			}
		}
		System.out.println("}");
		
		e.score = e.cnt * 20;
		
		System.out.println("your score = " + e.score + "point");
	}
}