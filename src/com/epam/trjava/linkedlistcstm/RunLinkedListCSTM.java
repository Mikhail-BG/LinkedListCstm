package com.epam.trjava.linkedlistcstm;

import com.epam.trjava.linkedlistcstm.logic.LinkedListCstmDoubly;
import com.epam.trjava.linkedlistcstm.logic.LinkedListCstmSimply;

public class RunLinkedListCSTM {

	public static void main(String[] args) {
		linkedListSingle();
		linkedListDouble();
	}
	
	public static void linkedListSingle(){
		System.out.println("----Simply----");
		LinkedListCstmSimply myList = new LinkedListCstmSimply();
		myList.add("A");
		myList.add("B");
		myList.add("C");
		myList.printListValues();
		System.out.println(myList.contains("A"));
		System.out.println(myList.remove("A"));
		System.out.println(myList.contains("A"));
		System.out.println("Size = " + myList.size());
		myList.printListValues();
		myList.clear();
		System.out.println(myList.contains("B"));
		System.out.println("Size = " + myList.size());
		
	}
	
	public static void linkedListDouble(){
		System.out.println("----Doubly----");
		LinkedListCstmDoubly myList = new LinkedListCstmDoubly();
		myList.add("A");
		myList.add("B");
		myList.add("C");
		myList.printListValues();
		System.out.println(myList.contains("A"));
		System.out.println(myList.remove("A"));
		System.out.println(myList.contains("A"));
		System.out.println("Size = " + myList.size());
		myList.printListValues();
		myList.clear();
		System.out.println(myList.contains("B"));
		System.out.println("Size = " + myList.size());
	}

}
