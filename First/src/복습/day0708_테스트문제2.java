package ����;

public class day0708_�׽�Ʈ����2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {10, 20, 30, 40, 50};
		int[] temp1 = new int[5];
		int[] temp2 = new int[5];
		int[] temp3 = new int[5];
		
		//����1) arr �� ���� temp1 ��  ������ ��� 
			// temp1 ==> {10, 20, 30, 40, 50}
				
				
		//����2) arr �� ���� 2�踦 temp2�� ������ ��� 
			// temp2 ==> {20, 40, 60, 80 , 100}		
		
		//����3) arr �� ���� i�� ���Ѱ��� temp3 �� ������ ��� 
			// temp3 ==> {10,21,32,43,54}
		
		System.out.println("���� 1");
		for(int i=0; i<arr.length; i++) {
			temp1[i] = arr[i];
			System.out.print(temp1[i] + " ");
		}
		System.out.println();
		
		System.out.println("���� 2");
		for(int i=0; i<arr.length; i++) {
			temp2[i] = arr[i]*2;
			System.out.print(temp2[i] + " ");
		}
		System.out.println();
		
		System.out.println("���� 3");
		for(int i=0; i<arr.length; i++) {
			temp3[i] = arr[i]+i;
			System.out.print(temp3[i] + " ");
		}
	}
}
