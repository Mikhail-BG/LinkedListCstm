package com.epam.trjava.linkedlistcstm;

import com.epam.trjava.linkedlistcstm.logic.LinkedListCstmAddPos;
import com.epam.trjava.linkedlistcstm.logic.LinkedListCstmAnyAdd;
import com.epam.trjava.linkedlistcstm.logic.LinkedListOperations;

public class RunLinkedListCSTM {

	public static void main(String[] args) {
		linkedListAnyPosition();
		//linkedListAnyAdd();
	}

	public static void linkedListAnyPosition() {

		System.out.println("--- Testing ----");
		LinkedListCstmAddPos<String> myList = new LinkedListCstmAddPos<String>();
		myList.addLast("Last 1");
		System.out.println("size = " + myList.getSize());
		LinkedListOperations.printListValues(myList);
		myList.addLast("Last 2");
		System.out.println("size = " + myList.getSize());
		LinkedListOperations.printListValues(myList);
		myList.addFirst("First 1");
		System.out.println("size = " + myList.getSize());
		LinkedListOperations.printListValues(myList);
		myList.addFirst("First 2");
		System.out.println("size = " + myList.getSize());
		LinkedListOperations.printListValues(myList);
		myList.addFirst("First 3");
		System.out.println("size = " + myList.getSize());
		LinkedListOperations.printListValues(myList);
		myList.addInPosition("Postition 1", 3);
		System.out.println("size = " + myList.getSize());
		LinkedListOperations.printListValues(myList);
		myList.addInPosition("Position 2", 3);
		System.out.println("size = " + myList.getSize());
		myList.addInPosition("Position 3", myList.getSize());
		System.out.println("size = " + myList.getSize());
		LinkedListOperations.printListValues(myList);
		System.out.println(myList.contains("B"));
		myList.remove("A");
		myList.remove("B");
		myList.remove("C");
		myList.remove("E");
		myList.clear();
		System.out.println("size = " + myList.getSize());
		LinkedListOperations.printListValues(myList);
	}

	public static void linkedListAnyAdd() {
		System.out.println("--- Testing ----");
		LinkedListCstmAnyAdd<String> myList = new LinkedListCstmAnyAdd<String>();
		myList.addLast("A");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
		myList.addMiddle("B");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
		myList.addMiddle("C");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
		myList.addLast("D");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
		myList.remove("B");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
	}

}
