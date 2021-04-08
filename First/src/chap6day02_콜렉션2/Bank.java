package chap6day02_�ݷ���2;

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
		System.out.println("[ȸ������] id �� �Է��ϼ���. ");
		String id = sc.next();
		if(checkId(id)) {
			System.out.println("�ߺ�id �Դϴ�.");
		} else {
			System.out.println("[ȸ������] ��й�ȣ�� �Է��ϼ��� >>> ");
			String pw =sc.next();
			System.out.println("[ȸ������] �̸��� �Է��ϼ��� >>> ");
			String name = sc.next();
			User user = new User();
			user.id = id;
			user.pw = pw;
			user.name = name;
			userlist.add(user);
			am.openAccount(id);
			System.out.println("ȸ�������� �����մϴ�.");
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
		System.out.println("[�Ա�] id �� �Է��ϼ��� >>> ");
		String id = sc.next();
		System.out.println("[�Ա�] pw �� �Է��ϼ��� >>> ");
		String pw = sc.next();
		
		if(um.checkLogin(id, pw)) {
			System.out.println("[�Ա�] ���¹�ȣ�� �����ϼ��� >>> ");
			Vector<Account> personalAccount = getPersonalAccount(id);
			for(int i=0; i<personalAccount.size(); i++) {
				System.out.print("[" + i + "] " + personalAccount.get(i).accountId + " : ");
				System.out.println(personalAccount.get(i).money);
			}
			int sel = sc.nextInt();
			System.out.println("[�Ա�] �ݾ��� �Է��ϼ��� >>> ");
			int money = sc.nextInt();
			personalAccount.get(sel).money += money;
		}
	}
	
	void checkBalance(UserManager um) {
		System.out.println("[��ȸ] id �� �Է��ϼ��� >>> ");
		String id = sc.next();
		System.out.println("[��ȸ] pw �� �Է��ϼ��� >>> ");
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
		System.out.println("[���»���] id �� �Է��ϼ��� >>> ");
		String id = sc.next();
		
		boolean check = um.checkId(id);
		
		if(check) {
			openAccount(id);
		}
		else {
			System.out.println("���̵� �ٽ� �Է����ֽʼ�");
			return;
		}
	}
	
	void transfer(UserManager um) {
		System.out.println("[������ü] id �� �Է��ϼ��� >>> ");
		String id = sc.next();
		System.out.println("[������ü] pw �� �Է��ϼ��� >>> ");
		String pw = sc.next();
		
		boolean check1 = um.checkLogin(id, pw);
		
		if(check1) {
			Vector<Account> personalList2 = getPersonalAccount(id);
			System.out.println("[������ü] ��ü�� ����� ���̵� �Է��� �ּ��� >>> ");
			String t_id = sc.next();
			
			boolean check2 = um.checkId(t_id);
			if(check2) {
				Vector<Account> personalList1 = getPersonalAccount(t_id);
				System.out.println("=============== �� ���� =================");
				for(int i=0; i<personalList2.size(); i++) {
					System.out.print("[" + (i+1) + "] " + personalList2.get(i).accountId + " : ");
					System.out.println(personalList2.get(i).money);
				}
				System.out.println("=============== ���� ���� =================");
				for(int i=0; i<personalList1.size(); i++) {
					System.out.print("[" + (i+1) + "] " + personalList1.get(i).accountId + " : ");
					System.out.println(personalList1.get(i).money);
				}
				
				System.out.println("[������ü] ��ü�� ���� ���� ���� >>> ");
				int sel1 = sc.nextInt() - 1;
				System.out.println("[������ü] ��ü�� ��� ���� ���� >>> ");
				int sel2 = sc.nextInt() - 1;
				
				System.out.println("[������ü] ��ü�� �ݾ� >>> ");
				int money = sc.nextInt();
				
				personalList2.get(sel1).money -= money;
				personalList1.get(sel2).money += money;
				
				System.out.println("���� ���� : " + personalList2.get(sel1).money);
				System.out.println("��� ���� : " + personalList1.get(sel2).money);
			}
		}
	}
	
	void withdrawal(UserManager um) {
		System.out.println("[ȸ��Ż��] id �� �Է��Ͻʼ� >>> ");
		String id = sc.next();
		System.out.println("[ȸ��Ż��] pw �� �Է��Ͻʼ� >>> ");
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
		System.out.println("[���»���] id �� �Է��Ͻʼ� >>> ");
		String id = sc.next();
		System.out.println("[���»���] pw �� �Է��Ͻʼ� >>> ");
		String pw = sc.next();
		
		boolean check = um.checkLogin(id, pw);
		if(check) {
			Vector<Account> personalList = getPersonalAccount(id);
			for(int i=0; i<personalList.size(); i++) {
				System.out.println("[" + (i+1) + "]" + personalList.get(i).accountId);
			}
			System.out.println("������ ���� ���� >>> ");
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
			System.out.println("(1)ȸ������  (2)�Ա� (3)��ȸ (4)�����߰� (5)��ü (6)ȸ��Ż�� (7)���»��� (0)����");
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
				System.out.println("����");
				break;
			}
		}
	}
}
