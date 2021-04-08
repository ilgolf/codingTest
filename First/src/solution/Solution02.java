package solution;

import java.util.Arrays;

public class Solution02 {
	String[] custno;
	int[] pointer;
	String[] name;

	public String[] Solution(String data1, String data2) {
		String[] answer = {};
		
		String[] temp = data1.split(",");
		String[] custno1 = new String[temp.length];
		int[] pointer1 = new int[temp.length];
		
		for(int i=0; i<temp.length; i++) {
			String[] info = temp[i].split("/");
			
			custno1[i] = info[0];
			pointer1[i] = Integer.parseInt(info[1]);
		}
		
		temp = data2.split(",");
		answer = new String[temp.length];
		custno = new String[temp.length];
		name = new String[temp.length];
		pointer = new int[temp.length];
		
		for(int i=0; i<temp.length; i++) {
			String[] info = temp[i].split("/");
			
			custno[i] = info[0];
			name[i] = info[1];
			
			for(int j=0; j<custno1.length; j++) {
				if(custno[i].equals(custno1[j])) {
					pointer[i] += pointer1[j];
				}
			}
			
			answer[i] = custno[i];
			answer[i] += "/";
			answer[i] += name[i];
			answer[i] += "/";
			answer[i] += pointer[i];
			if(i != temp.length-1) {
				answer[i] += ",";
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		String data1 = "1001/4,1002/5,1003/21,1001/34,1004/2,1002/43";
		String data2 = "1001/±èÃ¶¼ö,1002/ÀÌ¸¸¼ö,1003/³ë°æ¹Î,1004/À¯½ÂÈ¯";
		
		Solution02 s = new Solution02();
		
		String[] answer = s.Solution(data1, data2);
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}
