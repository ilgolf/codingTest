package ����;

public class day1311_�׽�Ʈ����6 {

	public static void main(String[] args) {
		int arr[] = {0,0,0,0,0};
		int b[] = {2,3,1,0,4};

		// arr �迭�� 10 ���� 10�� �����ϸ鼭10~50�� ���� 
		// ���� ) b�� ���� ������� ���� 
		// ��) b�ǰ���  2,3,1,0,4,  ==>  {30,40,20,10,50}
		
		
		int num = 0;
		for(int i=0; i<arr.length; i++) {
			num += 10;
			for(int j=0; j<b.length; j++) {
				if(i == b[j]) {
					arr[j] = num;
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
