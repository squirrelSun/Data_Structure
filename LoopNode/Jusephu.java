package LoopNode;

import java.util.ArrayList;

//丢手帕问题（约瑟夫环）
public class Jusephu {

	public static void main(String[] args) {
		group group = new group();
		person person1 = new person(1);
		person person2 = new person(2);
		person person3 = new person(3);
		person person4 = new person(4);
		person person5 = new person(5);
		person person6 = new person(6);
		person person7 = new person(7);
		person person8 = new person(8);
		group.add(person1);
		group.add(person2);
		group.add(person3);
		group.add(person4);
		group.add(person5);
		group.add(person6);
		group.add(person7);
		group.add(person8);
		group.show();
		
		System.out.println("---------");
		int time = 2;
		int count = 0;
		person p = group.head;
		ArrayList<Integer> arr = new ArrayList<>();
		while(true) {
			count++;
			p = p.next;
			if (count == time) {
				arr.add(group.del(p));
				count = 0;
			}
			if (p.next.equals( p.next.next)) {
				arr.add(p.next.id);
				break;
			}
		}
		System.out.println(arr.toString());
	}

}

class person {
	int id;
	person next;

	public person(int id) {
		this.id = id;
	}

}

class group {
	person head = new person(-1);

	public group() {

	}

	public void add(person newPerson) {
		if (head.next == null) {
			head.next = newPerson;
			newPerson.next = newPerson;
		}else {
			person temp = head.next;
			while(temp.next != head.next) {
				temp = temp.next;
			}
			temp.next = newPerson;
			newPerson.next = head.next;
		}
	}

	public int del(person oldPerson) {
		person temp = head.next;
		person p = oldPerson.next;
		if (oldPerson.equals(temp)) {
			head.next = p;
		}
		while(!temp.next.equals(oldPerson)) {
			temp = temp.next;
		}
		temp.next = p;
		return oldPerson.id;
	}

	public void show() {
		person person = head.next;
		while (!person.next.equals(head.next) ) {
			System.out.print(person.id + "\t");
			person = person.next;
		}
		System.out.println(person.id);
	}

}