package ����;

public class day1309_�׽�Ʈ����2 {

	public static void main(String[] args) {
		int arr[] = {10,20,30,40,50};
		int b[] = {10,20,3,5};
		
		//����) arr �ȿ� b�� ���� ������ 0���� ����
		// ��) arr = {0,0,30,40,50};
		
		for(int i=0; i<b.length; i++) {
			int check = -1;
			for(int j=0; j<arr.length; j++) {
				if(b[i] == arr[j]) {
					check = j;
				}
			}
			if(check != -1)
				arr[check] = 0;
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
