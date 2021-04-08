package programmers_step1;

import java.util.*;

/*
 *  �迭 array�� i��° ���ں��� j��° ���ڱ��� �ڸ��� �������� ��, k��°�� �ִ� ���� ���Ϸ� �մϴ�.
	���� ��� array�� [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3�̶��
	array�� 2��°���� 5��°���� �ڸ��� [5, 2, 6, 3]�Դϴ�.
	1���� ���� �迭�� �����ϸ� [2, 3, 5, 6]�Դϴ�.
	2���� ���� �迭�� 3��° ���ڴ� 5�Դϴ�.
	�迭 array, [i, j, k]�� ���ҷ� ���� 2���� �迭 commands�� �Ű������� �־��� ��, 
	commands�� ��� ���ҿ� ���� �ռ� ������ ������ �������� �� ���� ����� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���
 */

class solution1 {

	public int[] solution(int[] array, int[][] commands) {
		int[] answer = {};
		
		answer = new int[commands.length];
		
		for(int i=0; i<commands.length; i++) {
			int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
			
			Arrays.sort(temp);
			
			answer[i] = temp[commands[i][2] - 1];
		}
		return answer;
	}

	public static void main(String[] args) {
		solution1 s = new solution1();

		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		int[] answer = s.solution(array, commands);
		
		System.out.println(Arrays.toString(answer));
	}
}
