package chap6day02_콜렉션2;

public class Day0205_스태틱활용1 {

	public static void main(String[] args) {
		String userdata = "test01/pw1/김철수\n";
		userdata += "test02/pw2/이영희\n";
		userdata += "test03/pw3/신민수\n";
		userdata += "test04/pw4/최상민";
		
		String accountdata = "test01/1111-1111-1111/8000\n";
		accountdata += "test02/2222-2222-2222/5000\n";
		accountdata += "test01/3333-3333-3333/11000\n";
		accountdata += "test03/4444-4444-4444/9000\n";
		accountdata += "test01/5555-5555-5555/5400\n";
		accountdata += "test02/6666-6666-6666/1000\n";
		accountdata += "test03/7777-7777-7777/1000\n";
		accountdata += "test04/8888-8888-8888/1000";
		// 1) test01 김철수 는 계좌를 3개 가지고있다.
		// 2) test02 이영희 는 계좌를 2개 가지고있다.
		// 3) test03 신민수 는 계좌를 2개 가지고있다.
		// 4) test04 최상민 은 계좌를 1개 가지고있다. 
		
		UserManager um = new UserManager();
		um.dataSetting(userdata);
		AccountManager am = new AccountManager();
		am.dataSetting(accountdata);
		
		Bank bank = new Bank();
		bank.bankSetting(am, um);
		bank.run();
	}
}
