package epam.trjava.linkedlistcstm;

import epam.trjava.linkedlistcstm.logic.LinkedListCstmSingle;

public class RunLinkedListCSTM {

	public static void main(String[] args) {

		LinkedListCstmSingle myList = new LinkedListCstmSingle();
		myList.add("A");
		myList.add("B");
		myList.add("C");
		
		System.out.println(myList.contains("A"));
		System.out.println(myList.remove("A"));
		System.out.println(myList.contains("A"));
		
		myList.celar();
		System.out.println(myList.contains("B"));
		System.out.println(myList.size());
		
		
	}

}
