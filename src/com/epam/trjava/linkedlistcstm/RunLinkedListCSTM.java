package com.epam.trjava.linkedlistcstm;

import com.epam.trjava.linkedlistcstm.logic.LinkedListCstmAddPos;
import com.epam.trjava.linkedlistcstm.logic.LinkedListCstmAnyAdd;

public class RunLinkedListCSTM {

	public static void main(String[] args) {
		linkedListAnyPosition1();
		linkedListAnyPosition2();
		linkedListAnyPosition3();
		linkedListAnyPosition4();
		//linkedListAnyAdd();
	}

	public static void linkedListAnyPosition1() {

		System.out.println("--- Testing 1 ----");
		LinkedListCstmAddPos<String> myList = new LinkedListCstmAddPos<String>();
		myList.addFirst("A");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
		myList.addMiddle("C");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
		myList.addMiddle("B");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
		myList.addLast("D");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();

	}

	public static void linkedListAnyPosition2() {

		System.out.println("--- Testing 2 ----");
		LinkedListCstmAddPos<String> myList = new LinkedListCstmAddPos<String>();
		myList.addFirst("D");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
		myList.addFirst("C");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
		myList.addFirst("B");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
		myList.addFirst("A");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();

	}

	public static void linkedListAnyPosition3() {

		System.out.println("--- Testing 3 ----");
		LinkedListCstmAddPos<String> myList = new LinkedListCstmAddPos<String>();
		myList.addLast("A");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
		myList.addLast("B");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
		myList.addLast("C");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
		myList.addLast("D");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();

	}

	public static void linkedListAnyPosition4() {

		System.out.println("--- Testing 4 ----");
		LinkedListCstmAddPos<String> myList = new LinkedListCstmAddPos<String>();
		myList.addLast("D");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
		myList.addFirst("A");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
		myList.addMiddle("B");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
		myList.addMiddle("C");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();

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
