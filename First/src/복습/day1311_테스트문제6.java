package 복습;

public class day1311_테스트문제6 {

	public static void main(String[] args) {
		int arr[] = {0,0,0,0,0};
		int b[] = {2,3,1,0,4};

		// arr 배열에 10 부터 10씩 증가하면서10~50을 저장 
		// 조건 ) b의 값의 순서대로 저장 
		// 예) b의값은  2,3,1,0,4,  ==>  {30,40,20,10,50}
		
		
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
