package switch_day01;

import java.util.Calendar;

public class day01_exercise1 {

	public static void main(String[] args) {
		// month���� ������ �� ������ ��� �ֽ��ϴ�.
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		String season = "";
		// switch���� �̿��ؼ� season�� ������ � �������� ��Ÿ���� ��������.

		switch (month) {
		case 1 :
			season = "�ܿ�";
			break;
		case 2 :
			season = "�ܿ�";
			break;
		case 3 :
			season = "�ܿ�";
			break;
		case 4 :
			season = "��";
			break;
		case 5 :
			season = "��";
			break;
		case 6 :
			season = "����";
			break;
		case 7 :
			season = "����";
			break;
		case 8 :
			season = "����";
			break;
		case 9 : 
			season = "����";
			break;
		case 10 : 
			season = "����";
			break;
		case 11 : 
			season = "����";
			break;
		default :
			System.out.println("�߸��� ��");
		}
		System.out.println("������ " + month + "���̰�, " + season + "�Դϴ�.");
	}
}
