package day01_Ŭ�����⺻;

class Test2 {
	void printSum(int[] arr) {
		int sum = 0;
		System.out.println("���� 1");
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
	void printSumMultiple4(int[] arr) {
		int sum = 0;
		System.out.println("���� 2");
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%4 == 0) {
				sum += arr[i];
			}
		}
		System.out.println(sum);
	}
	void printCountMultiple4(int[] arr) {
		int count = 0;
		System.out.println("���� 3");
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%4 == 0) {
				count ++;
			}
		}
		System.out.println(count);
	}
	void printCountEven(int[] arr) {
		int count = 0;
		System.out.println("���� 4");
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%2 == 0) {
				count ++;
			}
		}
		System.out.println(count);
	}
}

public class day0302_��������2 {

	public static void main(String[] args) {
		
		Test2 t = new Test2();
		int[] arr = { 87, 100, 11, 72, 92 };
		
		t.printSum(arr);
		
		t.printSumMultiple4(arr);
		
		t.printCountMultiple4(arr);
		
		t.printCountEven(arr);
		// ���� 1) ��ü �� ���
		// ���� 1) 362

		// ���� 2) 4�� ����� �� ���
		// ���� 2) 264

		// ���� 3) 4�� ����� ���� ���
		// ���� 3) 3

		// ���� 4) ¦���� ���� ���
		// ���� 4) 3
	}

}
