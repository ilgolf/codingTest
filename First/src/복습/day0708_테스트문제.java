package ����;

public class day0708_�׽�Ʈ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����4) 50���� 100���� �ڿ����߿��� 9�� ����� ������ ��� # �� : 6 (54,63,72,81,90,99)
		// ����5) 28�� ��� �߿��� ���� ū ���ڸ� ���� ��� ==> �� : 980
		// ����6) 8�� ����� ���������� 5�� ��� ==> �� : 0,8,16,24,32
		
		System.out.println("���� 4");
		for(int i=50; i<101; i++) {
			if(i%9 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		System.out.println("���� 5");
		int maxNum = 0;
		for(int i=28; i<1000; i++) {
			if(i%28 == 0) {
				if(maxNum < i) {
					maxNum = i;
				}
			}
		}
		System.out.println(maxNum);
		
		System.out.println("���� 6");
		int count = 0;
		String ans = "";
		for(int i=0; i<100; i++) {
			if(i%8 == 0) {
				ans += i;
				count ++;
				if(count == 5) {
					break;
				}
				if(i != 5-1) {
					ans += "/";
				}
			}
		}
		System.out.println(ans);
	}

}
