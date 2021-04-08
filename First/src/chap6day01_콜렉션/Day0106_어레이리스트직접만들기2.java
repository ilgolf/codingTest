package chap6day01_�ݷ���;

class MyArrayList {
	Tv[] arr;
	int count;
	
	void add(Tv e) {
		if(count == 0) {
			arr = new Tv[count + 1];
		} else if(count > 0) {
			Tv[] temp = arr;
			
			arr = new Tv[count + 1];
			for(int i=0; i<count; i++) {
				arr[i] = temp[i];
			}
		}
		arr[count] = e;
		count ++;
	}
	
	int size() {
		return count;
	}
	
	void remove(int index) {
		if(count == 1) {
			arr = null;
			count = 0;
			
		} else if(count > 1) {
			Tv[] temp = arr;
			
			arr = new Tv[count - 1];
			int j = 0;
			for(int i=0; i<count; i++) {
				if(i != index) {
					arr[j] = temp[i];
					j++;
				}
			}
		}
		count --;
	}
	
	Tv get(int index) {
		return arr[index];
	}
}

public class Day0106_��̸���Ʈ���������2 {

	public static void main(String[] args) {
		MyArrayList myList = new MyArrayList();
		Tv temp = new Tv("TV", "�Ｚ", 1000);
		myList.add(temp);

		temp = new Tv("�ñ״�óTV", "����", 2000);
		myList.add(temp);

		temp = new Tv("����ƮTV", "����", 3000);
		myList.add(temp);

		temp = myList.get(1);
		System.out.println(temp.name);
	}
}
