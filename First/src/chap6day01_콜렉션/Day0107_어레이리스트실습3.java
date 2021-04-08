package chap6day01_콜렉션;

import java.io.*;
import java.util.*;

class Student {
	String id = "";
	String pw = "";
	
	void set_data(String i, String p) {
		id = i; pw = p;
	}
	
	void print_data() {
		System.out.println("이름 : " + id + "비밀번호  : " + pw);
	}
}

class Manager {
	Vector<Student> vec = new Vector<>();
	void add_studnet(Student st) {
		vec.add(st);
	}
	Student remove_student(int index) {
		Student del_st = vec.get(index);
		vec.remove(index);
		return del_st;
	}
	
	int check_id(Student st) {
		int check = -1;
		for(int i=0; i<vec.size(); i++) {
			if(vec.get(i).id.equals(st.id)) {
				check = i;
				break;
			}
		}
		return check;
	}
	
	void print_student() {
		for(int i=0; i<vec.size(); i++) {
			vec.get(i).print_data();
		}
	}
	String out_data() {
		String data = "";
		int count = vec.size();
		if(count == 0) {
			return data;
		}
		data += count;
		data += "\n";
		
		for(int i=0; i<count; i++) {
			data += vec.get(i).id;
			data += ", ";
			data += vec.get(i).pw;
			if(count - 1 != i) {
				data += "\n";
			}
		}
		return data;
	}
	
	void sort_data() {
		for(int j=0; j<vec.size(); j++) {
			for(int i=0; i<vec.size(); i++) {
				if(vec.get(j).id.compareTo(vec.get(i).id) < 0) {
					
					String tmp = vec.get(i).id;
					vec.get(i).id = vec.get(j).id;
					vec.get(j).id = tmp;
					
					tmp = vec.get(i).pw;
					vec.get(i).pw = vec.get(j).pw;
					vec.get(j).pw = tmp;
				}
			}
		}
	}
	
	void load_student(Vector<Student>temp) {
		vec = temp;
	}
	int get_size() {
		return vec.size();
	}
}

public class Day0107_어레이리스트실습3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Manager manager = new Manager();
		boolean run = true;
		while(run) {
			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				Student temp = new Student();
				System.out.println("[join] enter id >>> ");
				temp.id = sc.next();
				int check = manager.check_id(temp);
				if(check == -1) {
					System.out.println("[join] enter pw >>> ");
					temp.pw = sc.next();
					manager.add_studnet(temp);
					System.out.println(temp.id + "welcome to join");
				} else {
					System.out.println("Duplicate ID");
				}
			} else if(sel == 2) {
				manager.print_student();
				Student temp = new Student();
				System.out.println("[Withdrawal] enter id >>> ");
				temp.id = sc.next();
				int check = manager.check_id(temp);
				if(check == -1) {
					System.out.println("No id");
				} else {
					Student del_st = manager.remove_student(check);
					System.out.println(del_st.id + "complete Withdrawal");
				}
			} else if(sel == 3) {
				manager.sort_data();
				manager.print_student();
			} else if(sel == 4) {
				manager.print_student();
			} else if(sel == 5) {
				
				if(manager.get_size() == 0) return;
				try {
					FileWriter fw = new FileWriter("student_manager_vec.txt");
					String data = manager.out_data();
					if(!data.equals("")) {
						fw.write(data);
						System.out.println(data);
					}
					fw.close();
				} catch(Exception e) {e.printStackTrace();}
			} else if(sel == 6) {
				
				try {
					File file = new File("student_manager_vec.text");
					if(file.exists()) {
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);
						String line = br.readLine();
						int count = Integer.parseInt(line);
						Vector<Student> vec = new Vector<Student>();
						for(int i=0; i<count; i++) {
							Student temp = new Student();
							line = br.readLine();
							String[] value = line.split(",");
							temp.id = value[0];
							temp.pw = value[1];
							vec.add(temp);
						}
						fr.close();
						br.close();
						manager.load_student(vec);
					}
					manager.print_student();
				}catch (Exception e) {e.printStackTrace();}
			}
		}
	}
}
