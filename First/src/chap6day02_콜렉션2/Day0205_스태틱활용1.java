package chap6day02_�ݷ���2;

public class Day0205_����ƽȰ��1 {

	public static void main(String[] args) {
		String userdata = "test01/pw1/��ö��\n";
		userdata += "test02/pw2/�̿���\n";
		userdata += "test03/pw3/�Źμ�\n";
		userdata += "test04/pw4/�ֻ��";
		
		String accountdata = "test01/1111-1111-1111/8000\n";
		accountdata += "test02/2222-2222-2222/5000\n";
		accountdata += "test01/3333-3333-3333/11000\n";
		accountdata += "test03/4444-4444-4444/9000\n";
		accountdata += "test01/5555-5555-5555/5400\n";
		accountdata += "test02/6666-6666-6666/1000\n";
		accountdata += "test03/7777-7777-7777/1000\n";
		accountdata += "test04/8888-8888-8888/1000";
		// 1) test01 ��ö�� �� ���¸� 3�� �������ִ�.
		// 2) test02 �̿��� �� ���¸� 2�� �������ִ�.
		// 3) test03 �Źμ� �� ���¸� 2�� �������ִ�.
		// 4) test04 �ֻ�� �� ���¸� 1�� �������ִ�. 
		
		UserManager um = new UserManager();
		um.dataSetting(userdata);
		AccountManager am = new AccountManager();
		am.dataSetting(accountdata);
		
		Bank bank = new Bank();
		bank.bankSetting(am, um);
		bank.run();
	}
}
