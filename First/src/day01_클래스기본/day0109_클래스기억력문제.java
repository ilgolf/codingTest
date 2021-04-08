package day01_Ŭ�����⺻;

import java.util.Random;
import java.util.Scanner;

class Ex09 {
	int[] front = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
	int[] back = new int[10];
	
	int cnt = 0;		// ������ ���� Ƚ��
}

/*
 * # ���� ���� : Ŭ���� + ����
 * 1. front �迭 ī�� 10���� ���´�.
 * 2. front �迭���� ���� ī�带 ��� ī���� ��ġ�� �Է��Ѵ�.
 * 3. ������ 2���� ī�尡 ���� ī���̸�, back �迭�� ǥ���Ѵ�.
 * 4. ��� ī�尡 ��������(back�迭�� 0�� �������) ������ ����ȴ�. 
 */

public class day0109_Ŭ�������¹��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		Ex09 e = new Ex09();
		
		for(int i=0; i<1000; i++) {
			int r = ran.nextInt(e.front.length - 1);
			
			int temp = e.front[0];
			e.front[0] = e.front[r];
			e.front[r] = temp;
		}
		
		while(true) {
			
			System.out.print("Memory Game = { ");
			for(int i=0; i<e.front.length; i++) {
				if(e.back[i] == 0) {
					System.out.print("[ ] ");
				}
				else {
					System.out.print("[" + e.back[i] + "] ");
				}
			}
			System.out.println("}");
			
			if(e.cnt == 5) {
				System.out.println("exit program");
				break;
			}
			
			System.out.println("index 1 >>> ");
			int idx1 = sc.nextInt();
			e.back[idx1] = e.front[idx1];
			for(int i=0; i<e.front.length; i++) {
				if(e.back[i] == 0) {
					System.out.print("[ ] ");
				}
				else {
					System.out.print("[" + e.back[i] + "] ");
				}
			}
			System.out.println("}");
			System.out.println("index 2 >>> ");
			int idx2 = sc.nextInt();
			e.back[idx2] = e.front[idx2];
			for(int i=0; i<e.front.length; i++) {
				if(e.back[i] == 0) {
					System.out.print("[ ] ");
				}
				else {
					System.out.print("[" + e.back[i] + "] ");
				}
			}
			System.out.println("}");
			
			if(e.back[idx1] != 0 && e.back[idx2] != 0) {
				System.out.println("select again");
				continue;
			}
			else {
				if(e.front[idx1] == e.front[idx2]) {
					e.cnt++;
				}
				else {
					e.back[idx1] = 0;
					e.back[idx2] = 0;
				}
			}
		}
	}
}
