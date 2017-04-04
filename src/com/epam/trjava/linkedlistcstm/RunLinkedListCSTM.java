package com.epam.trjava.linkedlistcstm;

import com.epam.trjava.linkedlistcstm.logic.LinkedListCstmAddPos;
import com.epam.trjava.linkedlistcstm.logic.LinkedListOperations;
import com.epam.trjava.linkedlistcstm.logic.deprecated.LinkedListCstmAnyAdd;

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
		
		myList.addFirst("First 3");
		System.out.println("size = " + myList.getSize());
		LinkedListOperations.printListValues(myList);
		
		myList.addFirst("First 2");
		System.out.println("size = " + myList.getSize());
		LinkedListOperations.printListValues(myList);
		
		myList.addFirst("First 1");
		System.out.println("size = " + myList.getSize());
		LinkedListOperations.printListValues(myList);
		
		myList.addInPosition("Postition 1", 1);
		System.out.println("size = " + myList.getSize());
		LinkedListOperations.printListValues(myList);
		
		myList.addInPosition("Position 2", 2);
		System.out.println("size = " + myList.getSize());
		LinkedListOperations.printListValues(myList);
		
		myList.addLast("Last 3");
		System.out.println("size = " + myList.getSize());
		LinkedListOperations.printListValues(myList);
		
		myList.addInPosition("Position last", myList.getSize()-1);
		System.out.println("size = " + myList.getSize());
		LinkedListOperations.printListValues(myList);
		
		System.out.println(myList.contains("B"));
		
		myList.remove("Last 3");
		myList.remove("Position 2");
		System.out.println("size = " + myList.getSize());
		LinkedListOperations.printListValues(myList);
		
		for (int i = 0; i < myList.getSize(); i++){
			System.out.println("Node at the position [" + i + "] : " + myList.getNodeByIndex(i));
		}
		
		System.out.println("---");
		
		myList.clear();
		System.out.println("size = " + myList.getSize());
		LinkedListOperations.printListValues(myList);
	}

}
