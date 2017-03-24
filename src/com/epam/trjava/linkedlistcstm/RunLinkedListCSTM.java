package com.epam.trjava.linkedlistcstm;

import com.epam.trjava.linkedlistcstm.logic.LinkedListCstmAddPos;

public class RunLinkedListCSTM {

	public static void main(String[] args) {
		linkedListAnyPosition();
	}
	
	public static void linkedListAnyPosition(){
		
		System.out.println("--- Testing ----");
		LinkedListCstmAddPos<String> myList = new LinkedListCstmAddPos<String>();
		myList.addFirst("A");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
		myList.addLast("B");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
		myList.addFirst("C");
		System.out.println("size = " + myList.getSize());
		myList.printListValues();
	}

}
