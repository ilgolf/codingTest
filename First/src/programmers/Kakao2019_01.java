package programmers;

import java.util.*;

public class Kakao2019_01 {

	public String[] solution(String[] record) {
		Map<String, String> user = new HashMap<>();  // �ߺ�ó���� ���� �ؽø� ���
		String[] logState = new String[100000];  // ����
		String[] logId = new String[100000];     // ���̵�
		
		int j = 0;
		for(int i=0; i<record.length; i++) {
			String check = record[i];
			StringTokenizer st = new StringTokenizer(check, " ");
			String command = st.nextToken();
			
			// ���Խ��ϴ�.
			if(command.equals("Enter")) {
				String id = st.nextToken();
				String nick = st.nextToken();
				
				user.put(id, nick);
				logId[j] = id;
				logState[j] = "���� ���Խ��ϴ�.";
				j++;
			}
			
			// �������ϴ�.
			if(command.equals("Leave")) {
				String id = st.nextToken();
				logId[j] = id;
				logState[j] = "���� �������ϴ�.";
				j++;
			}
			
			// �ٲ���ϴ�, ���������� ����� ���� �ʱ� ������ j ++ (x)
			if(command.equals("Change")) {
				String id = st.nextToken();
				String nick = st.nextToken();
				user.put(id, nick);
			}
		}
		
		String[] answer = new String[j];
		for(int i=0; i<j; i++) {
			answer[i] = user.get(logId[i]) + logState[i];
		}
		return answer;
    }
	
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		
		Kakao2019_01 k = new Kakao2019_01();
		
		String[] answer = k.solution(record);
		System.out.println(Arrays.toString(answer));
	}
}