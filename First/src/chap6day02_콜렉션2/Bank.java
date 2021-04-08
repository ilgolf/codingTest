package chap6day02_콜렉션2;

import java.util.*;

class User {
	String id;
	String pw; 
	String name;
}

class UserManager {
	Scanner sc = new Scanner(System.in);
	Vector<User> userlist = new Vector<User>();
	void dataSetting(String data) {
		String[] token = data.split("\n");
		for(int i=0; i<token.length; i++) {
			User user = new User();
			String[] token2 = token[i].split("/");
			user.id = token2[0];
			user.pw = token2[1];
			user.name = token2[2];
			userlist.add(user);
		}
	}
	
	boolean checkId(String id) {
		for(int i=0; i<userlist.size(); i++) {
			if(id.equals(userlist.get(i).id)) {
				return true;
			}
		}
		return false;
	}
	
	boolean checkLogin(String id, String pw) {
		for(int i=0; i<userlist.size(); i++) {
			if(id.equals(userlist.get(i).id) && pw.equals(userlist.get(i).pw)) {
				return true;
			}
		}
		return false;
	}
	
	void join(AccountManager am) {
		System.out.println("[회원가입] id 를 입력하세요. ");
		String id = sc.next();
		if(checkId(id)) {
			System.out.println("중복id 입니다.");
		} else {
			System.out.println("[회원가입] 비밀번호를 입력하세요 >>> ");
			String pw =sc.next();
			System.out.println("[회원가입] 이름을 입력하세요 >>> ");
			String name = sc.next();
			User user = new User();
			user.id = id;
			user.pw = pw;
			user.name = name;
			userlist.add(user);
			am.openAccount(id);
			System.out.println("회원가입을 축하합니다.");
		}
	}
}

class Account{
	String userId;
	String accountId;
	int money;
}

class AccountManager {
	Scanner sc = new Scanner(System.in);
	Vector<Account> accountlist = new Vector<Account>();
	void dataSetting(String data) {
		String[] token = data.split("\n");
		for(int i=0; i<token.length; i++) {
			Account ac = new Account();
			String[] token2 = token[i].split("/");
			ac.userId = token2[0];
			ac.accountId = token2[1];
			ac.money = Integer.parseInt(token2[2]);
			accountlist.add(ac);
		}
	}
	
	Vector<Account> getPersonalAccount(String id) {
		Vector<Account> personalList = new Vector<Account>();
		for(int i=0; i<accountlist.size(); i++) {
			if(accountlist.get(i).userId.equals(id)) {
				personalList.add(accountlist.get(i));
			}
		}
		return personalList;
	}
	
	void openAccount(String id) {
		Random ran = new Random();
		String acId = "";
		for(int i=0; i<3; i++) {
			int r1 = ran.nextInt(10);
			acId += r1;
			int r2 = ran.nextInt(10);
			acId += r2;
			int r3 = ran.nextInt(10);
			acId += r3;
			int r4 = ran.nextInt(10);
			acId += r4;
			if(i<3 - 1) {
				acId += "-";
			}
		}
		System.out.println(id + " : " + acId);
		Account ac = new Account();
		ac.accountId = acId;
		ac.userId = id;
		ac.money = 0;
		accountlist.add(ac);
	}
	
	void deposit(UserManager um) {
		System.out.println("[입금] id 를 입력하세요 >>> ");
		String id = sc.next();
		System.out.println("[입금] pw 를 입력하세요 >>> ");
		String pw = sc.next();
		
		if(um.checkLogin(id, pw)) {
			System.out.println("[입금] 계좌번호를 선택하세요 >>> ");
			Vector<Account> personalAccount = getPersonalAccount(id);
			for(int i=0; i<personalAccount.size(); i++) {
				System.out.print("[" + i + "] " + personalAccount.get(i).accountId + " : ");
				System.out.println(personalAccount.get(i).money);
			}
			int sel = sc.nextInt();
			System.out.println("[입금] 금액을 입력하세요 >>> ");
			int money = sc.nextInt();
			personalAccount.get(sel).money += money;
		}
	}
	
	void checkBalance(UserManager um) {
		System.out.println("[조회] id 를 입력하세요 >>> ");
		String id = sc.next();
		System.out.println("[조회] pw 를 입력하세요 >>> ");
		String pw = sc.next();
		if(um.checkLogin(id, pw)) {
			Vector<Account> personalAccount = getPersonalAccount(id);
			for(int i=0; i<personalAccount.size(); i++) {
				System.out.print("[" + i + "] " + personalAccount.get(i).accountId + " : ");
				System.out.println(personalAccount.get(i).money);
			}
		}
	}
	
	void createAccount(UserManager um) {
		System.out.println("[계좌생성] id 를 입력하세요 >>> ");
		String id = sc.next();
		
		boolean check = um.checkId(id);
		
		if(check) {
			openAccount(id);
		}
		else {
			System.out.println("아이디를 다시 입력해주십쇼");
			return;
		}
	}
	
	void transfer(UserManager um) {
		System.out.println("[계좌이체] id 를 입력하세요 >>> ");
		String id = sc.next();
		System.out.println("[계좌이체] pw 를 입력하세요 >>> ");
		String pw = sc.next();
		
		boolean check1 = um.checkLogin(id, pw);
		
		if(check1) {
			Vector<Account> personalList2 = getPersonalAccount(id);
			System.out.println("[계좌이체] 이체할 사람의 아이디를 입력해 주세요 >>> ");
			String t_id = sc.next();
			
			boolean check2 = um.checkId(t_id);
			if(check2) {
				Vector<Account> personalList1 = getPersonalAccount(t_id);
				System.out.println("=============== 내 계좌 =================");
				for(int i=0; i<personalList2.size(); i++) {
					System.out.print("[" + (i+1) + "] " + personalList2.get(i).accountId + " : ");
					System.out.println(personalList2.get(i).money);
				}
				System.out.println("=============== 상대방 계좌 =================");
				for(int i=0; i<personalList1.size(); i++) {
					System.out.print("[" + (i+1) + "] " + personalList1.get(i).accountId + " : ");
					System.out.println(personalList1.get(i).money);
				}
				
				System.out.println("[계좌이체] 이체할 나의 계좌 선택 >>> ");
				int sel1 = sc.nextInt() - 1;
				System.out.println("[계좌이체] 이체할 상대 계좌 선택 >>> ");
				int sel2 = sc.nextInt() - 1;
				
				System.out.println("[계좌이체] 이체할 금액 >>> ");
				int money = sc.nextInt();
				
				personalList2.get(sel1).money -= money;
				personalList1.get(sel2).money += money;
				
				System.out.println("나의 계좌 : " + personalList2.get(sel1).money);
				System.out.println("상대 계좌 : " + personalList1.get(sel2).money);
			}
		}
	}
	
	void withdrawal(UserManager um) {
		System.out.println("[회원탈퇴] id 를 입력하십쇼 >>> ");
		String id = sc.next();
		System.out.println("[회원탈퇴] pw 를 입력하십쇼 >>> ");
		String pw = sc.next();
		
		boolean check = um.checkLogin(id, pw);
		if(check) {
			for(int i=0; i<um.userlist.size(); i++) {
				if(um.userlist.get(i).id.equals(id)) {
					um.userlist.remove(i);
				}
			}
			
			for(int i=0; i<accountlist.size(); i++) {
				if(accountlist.get(i).userId.equals(id)) {
					accountlist.remove(i);
				}
			}
		}
	}
	
	void deletAccount(UserManager um) {
		System.out.println("[계좌삭제] id 를 입력하십쇼 >>> ");
		String id = sc.next();
		System.out.println("[계좌삭제] pw 를 입력하십쇼 >>> ");
		String pw = sc.next();
		
		boolean check = um.checkLogin(id, pw);
		if(check) {
			Vector<Account> personalList = getPersonalAccount(id);
			for(int i=0; i<personalList.size(); i++) {
				System.out.println("[" + (i+1) + "]" + personalList.get(i).accountId);
			}
			System.out.println("삭제할 계좌 선택 >>> ");
			int sel = sc.nextInt();
			
			accountlist.remove(sel); 
		}
	}
}

class Bank {
	AccountManager am;
	UserManager um;
	Scanner sc = new Scanner(System.in);
	void bankSetting(AccountManager am, UserManager um) {
		this.am = am;
		this.um = um;
	}
	
	void run() {
		
		while(true) {
			for(int i=0; i<um.userlist.size(); i++) {
				System.out.println(um.userlist.get(i).id + " : " + um.userlist.get(i).name + " : " + um.userlist.get(i).pw);
			}
			System.out.println("(1)회원가입  (2)입금 (3)조회 (4)계좌추가 (5)이체 (6)회원탈퇴 (7)계좌삭제 (0)종료");
			int sel = sc.nextInt();
			if(sel == 1) {
				um.join(am);
			}
			else if(sel == 2) {
				am.deposit(um);
			}
			else if(sel == 3) {
				am.checkBalance(um);
			}
			else if(sel == 4) {
				am.createAccount(um);
			}
			else if(sel == 5) {
				am.transfer(um);
			}
			else if(sel == 6) {
				am.withdrawal(um);
			}
			else if(sel == 7) {
				am.deletAccount(um);
			}
			else if(sel == 0) {
				System.out.println("종료");
				break;
			}
		}
	}
}
