import java.util.*;

public class Solution {
	public int solution(String numbers) {
		int answer = 0;

		String[] strArr = numbers.split("");	// 배열 만들어주기
		int[] numArr = new int[strArr.length];
		
		int k=0;
		for(String n : strArr) {
			numArr[k] = Integer.parseInt(n);   
			k++; 								// int형으로 저장
		}
		Set<Integer> set = new HashSet<>();
		
		for(int i=1; i<=numArr.length; i++) {
			perm(strArr, 0, i, set);         // perm메서드 실행
		}
		answer = set.size();
		
		return answer;
	}
	public void perm(String[] arr, int depth, int k, Set set) {
		if(depth == k) {    // 원하는 k개의 숫자를 조합했으니 종료
			print(arr, k, set);  // 조합한 값 호출
			return;
		} else {
			for(int i=depth; i<arr.length; i++) {
				swap(arr, i, depth);
				perm(arr, depth + 1, k, set);
				swap(arr, i, depth);     // 섞어주면서 조합
			}
		}
	}
	
	// 셔플
	public void swap(String[] arr, int i, int j) {  
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	// 섞어준 값 조합 하여 출력
	public void print(String[] arr, int k, Set set) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<k; i++) {
			sb.append(arr[i]);
		}
		primeNumber(set, sb);
	}
	
	// 조합 된 값 숫자 int형으로 변환후 소수인 값만 print로 반환
	public void primeNumber(Set set, StringBuilder sb) {
		int num = Integer.parseInt(String.valueOf(sb));
		boolean prime = true;
		if(num <= 1) {
			return;
		}
		
		// 에라토스테네스의 체의 법칙으로 num의 제곱근의 값까지만 반복해도 해당 값의 소수를 모두 찾을 수 있다.
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i == 0) {
				prime=false;
				break;  // 하나라도 나눠지면 반복문 종료
			}
		}
		
		// 만약 소수일 경우 바로 set 객체에 추가
		if(prime) {
			set.add(num);
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		String numbers = "011";
		
		int answer = s.solution(numbers);
		System.out.println(answer);
	}
}
