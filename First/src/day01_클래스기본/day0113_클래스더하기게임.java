package day01_Ŭ�����⺻;

import java.util.Random;
import java.util.Scanner;

class Ex15{
	int[] game = new int[6];
	int[] idx = new int[3];
	int[] myIdx = new int[3];	
	int total = 0;
}

/*
 * # ���ϱ� ����
 * 1. 1���� 10 ������ ������ ���� �ߺ� ���� game �迭�� 6�� �����Ѵ�.
 * 2. 6���� �迭�� �ε����� 0���� 5������ ���� �� 3���� �ߺ� ���� ������ 
       �� �ε����� �� �� ���� ����Ѵ�. 
 * 3. ����ڴ� �ߺ����� 3���� �ε����� ��� �� ���� ���ߴ� �����̴�.
*  ��)  4, 7, 5, 3, 2, 9  //   ����:  14   ==> �ε��� 3���� ��� ���� ���߸�ȴ�.  
    ����)  3,4,5 (�������� ����� ���� ���ü����ִ�)
 */

public class day0113_Ŭ�������ϱ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		Ex15 e = new Ex15();
		
		int cnt = 0;
		for(int i=0; i<e.game.length; i++) {
			int r = ran.nextInt(10)+1;
			
			e.game[i] = r;
			for(int n=0; n<e.game.length; n++) {
				if(r == e.game[n] && i != n) {
					e.game[i] = 0;
					i--;
				}
			}
		}
		
		for(int i=0; i<e.idx.length; i++) {
			int r = ran.nextInt(e.game.length-1);
			e.idx[i] = r;
			for(int n=0; n<e.idx.length; n++) {
				if(i != 0) {
					if(r == e.idx[n] && i != n) {
						e.myIdx[i] = 0;
						i--;
					}
				}
			}
		}
		
		for(int i=0; i<e.idx.length; i++) {
			e.total += e.game[e.idx[i]];
		}
		
		while(true) {
			int count = 0;
			System.out.print("list = { ");
			for(int i=0; i<e.game.length; i++) {
				System.out.print(e.game[i] + " ");
			}
			System.out.println("}");
			
			System.out.println("answer : = " + e.total);
			
			System.out.println("===============================");
			int myAnswer = 0;
			for(int i=0; i<e.myIdx.length; i++) {
				System.out.println("enter index >>> ");
				e.myIdx[i] = sc.nextInt();
				myAnswer += e.game[e.myIdx[i]];
			}
			if(myAnswer == e.total) {
				for(int i=0; i<e.idx.length; i++) {
					for(int j=0; j<e.myIdx.length; j++) {
						if(e.idx[i] == e.myIdx[j]) {
							count++;
						}
					}
				}
			}
			System.out.println(count);
			
			if(count == 3) {
				System.out.println("Sounds Great !");
				break;
			} else {
				System.out.println("bad...");
			}
			
			for(int i=0; i<e.idx.length; i++) {
				System.out.print(e.idx[i] + " ");
			}
			System.out.println();
		}
	}

}
