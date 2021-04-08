package programmers_step2;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * �����ڴ� ������ ������ ����� �ظ��Դϴ�. ������ ���ι��� ���ǰ�翡 ���� ������ ���� ������ �մϴ�. �����ڴ� 1�� �������� ������
 * �������� ������ ���� ����ϴ�.
 * 
 * 1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ... 2�� �����ڰ� ��� ���: 2, 1, 2, 3,
 * 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ... 3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4,
 * 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * 
 * 1�� �������� ������ ���������� ������ ������� ���� �迭 answers�� �־����� ��, ���� ���� ������ ���� ����� �������� �迭��
 * ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 */

public class Solution {
    public int[] solution(int[] answers) {
        int[] result = {};
        
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        
        int[] count = new int[3];
        
        for(int i=0; i<answers.length; i++) {
        	if(a[i%a.length] == answers[i]) count[0] ++;
        	if(b[i%b.length] == answers[i]) count[1] ++;
        	if(c[i%c.length] == answers[i]) count[2] ++;
        }
        
        int max = 0;
        for(int val : count) {
        	max = Math.max(max, val);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int maxIdx = 1;
        for(int val : count) {
        	if(max ==  val) {
        		list.add(maxIdx);
        	}
        	maxIdx ++;
        }
        
        result = new int[list.size()];
        
        int k=0;
        for(int val : list) {
        	result[k] = val;
        	k++;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	
    	int[] answers = {1, 2, 3, 4, 5};
    	
    	int[] result = s.solution(answers);
    	
    	System.out.println(Arrays.toString(result));
	}
}