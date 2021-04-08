package chap6day01_콜렉션;

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

public class Day0106_어레이리스트직접만들기2 {

	public static void main(String[] args) {
		MyArrayList myList = new MyArrayList();
		Tv temp = new Tv("TV", "삼성", 1000);
		myList.add(temp);

		temp = new Tv("시그니처TV", "엘지", 2000);
		myList.add(temp);

		temp = new Tv("스마트TV", "애플", 3000);
		myList.add(temp);

		temp = myList.get(1);
		System.out.println(temp.name);
	}
}
