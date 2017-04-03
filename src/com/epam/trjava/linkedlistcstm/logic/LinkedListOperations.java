package com.epam.trjava.linkedlistcstm.logic;

import com.epam.trjava.linkedlistcstm.logic.LinkedListCstmAddPos.Entry;

public class LinkedListOperations {
	
	private LinkedListOperations(){}
	
	/**
	 * Method for printing elements of LinkedList
	 */
	public static void printListValues(LinkedListCstmAddPos<?> lindkedList) {
		Entry<?> temp;
		temp = lindkedList.getFirst();
		while (temp != null) {
			System.out.println(temp.element);
			temp = temp.next;
		}
		System.out.println("----");
	}

}
