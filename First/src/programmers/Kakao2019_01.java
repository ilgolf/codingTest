package programmers;

import java.util.*;

public class Kakao2019_01 {

	public String[] solution(String[] record) {
		Map<String, String> user = new HashMap<>();  // 중복처리를 위해 해시맵 사용
		String[] logState = new String[100000];  // 상태
		String[] logId = new String[100000];     // 아이디
		
		int j = 0;
		for(int i=0; i<record.length; i++) {
			String check = record[i];
			StringTokenizer st = new StringTokenizer(check, " ");
			String command = st.nextToken();
			
			// 들어왔습니다.
			if(command.equals("Enter")) {
				String id = st.nextToken();
				String nick = st.nextToken();
				
				user.put(id, nick);
				logId[j] = id;
				logState[j] = "님이 들어왔습니다.";
				j++;
			}
			
			// 나갔습니다.
			if(command.equals("Leave")) {
				String id = st.nextToken();
				logId[j] = id;
				logState[j] = "님이 나갔습니다.";
				j++;
			}
			
			// 바꿨습니다, 실질적으로 출력이 되지 않기 때문에 j ++ (x)
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
