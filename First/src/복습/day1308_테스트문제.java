package ����;

import java.util.Scanner;

public class day1308_�׽�Ʈ���� {

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50 };
		int b[] = new int[5];

		// ���ڸ� 5�� �Է¹ް� arr �迭�ȿ� �Է��Ѱ��� ����������
		// b�迭�ȿ� �ش� ���� �ε����� ���ʴ�� �����ҷ��� �Ѵ�.
		// ����) ���࿡ �Է��� ���ڰ� arr �� ������ �ε��� ��� -1 ����

		// ��) 10, 20, 10, 1, 50
		// b ={0,1,0,-1,4}

		// ��) 30, 40, 1, 10, 2

		// b = {2,3,-1,0,-1}

		Scanner sc = new Scanner(System.in);
		
		int[] temp = new int[arr.length];
		
		for(int i=0; i<temp.length; i++) {
			temp[i] = sc.nextInt();
		}
		
		for(int i=0; i<arr.length; i++) {
			int check = -1;
			for(int j=0; j<arr.length; j++) {
				if(temp[i] == arr[j]) {
					check = j;
				}
			}
			b[i] = check;
		}
		for(int i=0; i<b.length; i++) {
			System.out.println(b[i]);
		}
	}
}
