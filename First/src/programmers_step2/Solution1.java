package programmers_step2;

// ��ȭ��ȣ�ο� ���� ��ȭ��ȣ ��, �� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 �ִ��� Ȯ���Ϸ� �մϴ�.
// ��ȭ��ȣ�� ������ ���� ���, ������ ��ȭ��ȣ�� �������� ��ȭ��ȣ�� ���λ��Դϴ�.
//
// ������ : 119
// ���ؿ� : 97 674 223
// ������ : 11 9552 4421
// ��ȭ��ȣ�ο� ���� ��ȭ��ȣ�� ���� �迭 phone_book �� solution 
// �Լ��� �Ű������� �־��� ��, � ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 ������ false�� 
// �׷��� ������ true�� return �ϵ��� solution �Լ��� �ۼ����ּ���.

import java.util.*;

public class Solution1 {
	
	public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        
        int k = 0;
        for(String n : phone_book) {
        	map.put(n, k);
        	k++;
        }
        
        for(int i=0; i<phone_book.length; i++) {
        	for(int j=0; j<phone_book[i].length(); j++) {
        		if(map.containsKey(phone_book[i].substring(0, j))) { return false; }
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		boolean answer = s.solution(phone_book);
		System.out.println(answer);
	}
}
