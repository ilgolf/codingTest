package programmers_step2;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막
 * 문제까지 다음과 같이 찍습니다.
 * 
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ... 2번 수포자가 찍는 방식: 2, 1, 2, 3,
 * 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ... 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4,
 * 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * 
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에
 * 담아 return 하도록 solution 함수를 작성해주세요.
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