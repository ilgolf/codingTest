import java.util.*;

public class Solution {
	public int solution(String numbers) {
		int answer = 0;

		String[] strArr = numbers.split("");	// �迭 ������ֱ�
		int[] numArr = new int[strArr.length];
		
		int k=0;
		for(String n : strArr) {
			numArr[k] = Integer.parseInt(n);   
			k++; 								// int������ ����
		}
		Set<Integer> set = new HashSet<>();
		
		for(int i=1; i<=numArr.length; i++) {
			perm(strArr, 0, i, set);         // perm�޼��� ����
		}
		answer = set.size();
		
		return answer;
	}
	public void perm(String[] arr, int depth, int k, Set set) {
		if(depth == k) {    // ���ϴ� k���� ���ڸ� ���������� ����
			print(arr, k, set);  // ������ �� ȣ��
			return;
		} else {
			for(int i=depth; i<arr.length; i++) {
				swap(arr, i, depth);
				perm(arr, depth + 1, k, set);
				swap(arr, i, depth);     // �����ָ鼭 ����
			}
		}
	}
	
	// ����
	public void swap(String[] arr, int i, int j) {  
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	// ������ �� ���� �Ͽ� ���
	public void print(String[] arr, int k, Set set) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<k; i++) {
			sb.append(arr[i]);
		}
		primeNumber(set, sb);
	}
	
	// ���� �� �� ���� int������ ��ȯ�� �Ҽ��� ���� print�� ��ȯ
	public void primeNumber(Set set, StringBuilder sb) {
		int num = Integer.parseInt(String.valueOf(sb));
		boolean prime = true;
		if(num <= 1) {
			return;
		}
		
		// �����佺�׳׽��� ü�� ��Ģ���� num�� �������� �������� �ݺ��ص� �ش� ���� �Ҽ��� ��� ã�� �� �ִ�.
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i == 0) {
				prime=false;
				break;  // �ϳ��� �������� �ݺ��� ����
			}
		}
		
		// ���� �Ҽ��� ��� �ٷ� set ��ü�� �߰�
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
