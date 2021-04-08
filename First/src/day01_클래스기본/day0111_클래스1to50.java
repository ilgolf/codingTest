package day01_Ŭ�����⺻;

import java.util.Random;
import java.util.Scanner;

class Ex11{
	final int SIZE = 9;	
	int[] front = new int[SIZE];
	int[] back  = new int[SIZE];	
}

/* 
 * # 1 to 50[3�ܰ�] : 1 to 18
 * 1. ���ۿ��� 1 to 50 �̶�� �˻��Ѵ�.
 * 2. 1 to 50 ���߷� ������ ������ ������ �ǽ��غ���.
 * 3. �� ������ ���ڹ����� ���� 1 to 18�� ���� �����Ѵ�.
 * 4. ���� 1~9�� front �迭�� �����ϰ�,
 *    ���� 10~18�� back �迭�� �����Ѵ�.
 */

public class day0111_Ŭ����1to50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		Ex11 e = new Ex11();
		
		for(int i=0; i<e.SIZE; i++) {
			e.front[i] = i+1;
			e.back[i] = i+10;
		}
		
		for(int i=0; i<1000; i++) {
			int r = ran.nextInt(e.SIZE);
			
			int temp = e.front[0];
			e.front[0] = e.front[r];
			e.front[r] = temp;
			
			temp = e.back[0];
			e.back[0] = e.back[r];
			e.back[r] = temp;
		}
		
		int count = 1;
		
		while(true) {
			System.out.println("==== 1 to 50 ====");
			for(int i=0; i<e.SIZE; i++) {
				System.out.print(e.front[i] + " ");
				if(i%3 == 2) {
					System.out.println();
				}
			}
			System.out.println("=================");
			
			if(count == 19) {
				System.out.println("exit program");
				break;
			}
			
			System.out.println("enter No(1~9) >>> ");
			int num = sc.nextInt()-1;
			
			if(e.front[num] < 10) {
				if(e.front[num] == count) {
					e.front[num] = e.back[num];
					count ++;
				}
			}
			else if(e.front[num] > 9) {
				if(e.front[num] == count) {
					e.front[num] = 0;
					count ++;
				}
			}
		}
	}
}
