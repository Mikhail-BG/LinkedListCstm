package com.epam.trjava.linkedlistcstm;

import com.epam.trjava.linkedlistcstm.logic.LinkedListCstmAddPos;
import com.epam.trjava.linkedlistcstm.logic.LinkedListCstmAnyAdd;
import com.epam.trjava.linkedlistcstm.logic.LinkedListCstmDoubly;
import com.epam.trjava.linkedlistcstm.logic.LinkedListCstmSimply;

public class RunLinkedListCSTM {

	public static void main(String[] args) {
		//linkedListSingle();
		//linkedListDouble();
		//linkedListAnyAdd();
		linkedListAnyPosition();
	}
	
	public static void linkedListAnyPosition(){
		LinkedListCstmAddPos<String> myList = new LinkedListCstmAddPos<String>();
		
		myList.addFirst("A");
		myList.addFirst("B");
		myList.addLast("C");
		myList.printListValues();
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
	
	public static void linkedListAnyAdd(){
		System.out.println("----Any add----");
		LinkedListCstmAnyAdd<String> myList = new LinkedListCstmAnyAdd<String>();
		myList.addFirst("AA");
		myList.printListValues();
		myList.addLast("A");
		myList.printListValues();
		myList.addLast("B");
		myList.printListValues();
		myList.addFirst("AB");
		myList.printListValues();
		myList.addLast("C");
		myList.printListValues();
		myList.addFirst("AC");
		myList.printListValues();
		myList.addLast("D");
		myList.printListValues();
		myList.addMiddle("AAA");
		myList.printListValues();
		myList.addMiddle("BBB");
		myList.remove("AA");
		System.out.println("--- end ---");
		myList.printListValues();
		
		
	}

}
