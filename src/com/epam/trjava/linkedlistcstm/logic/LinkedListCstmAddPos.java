package com.epam.trjava.linkedlistcstm.logic;

public class LinkedListCstmAddPos<E> {

	/** Number of elements in LinkedList */
	private int size = 0;

	/** The first element of LinkedList */
	private Entry<E> head;

	/** The last element of LinkedList */
	private Entry<E> tail;

	/** The internal class element, indicates location inside LinkedList */
	private int current_index;

	/** The internal class element, indicates Entry of current_index */
	private Entry<E> current;

	public LinkedListCstmAddPos() {}

	/**
	 * Method for printing elements of LinkedList
	 */
	public void printListValues() {
		
		Entry<E> temp = new Entry<E>();
		temp = head;
		while (temp != null) {
			System.out.println(temp.element);
			temp = temp.next;
		}
		System.out.println("----");
	}

	private void setCurrentLocation(int index) {
		if (index > size | index < 0) {
			System.out.println("Exception: index out of bounds");
			return;
		}

		for (int i = 0; i <= index; i++) {
			if (0 == i) {
				current = head;
			} else {
				current = current.next;
			}
			this.current_index = i;
		}
	}

	private void insertAtLocation(E value) {
		Entry<E> node = new Entry<E>();
		node.element = value;

		size++;
		
		//first iteration
		if (current_index == 0 && size == 1){
			node.next = null;
			head = node;
			tail = node;
			return;
		}
		
		// set the first into LinkedList
		if (current_index == 0 && size > 1) {
			node.next = head;
			head = node;
			return;
		}

		// set the last into LinkedList
		if (current_index == (size - 1) && size >= 1) {
			node.next = null;
			tail.next = node;
			tail = node;
			return;
		}
		
		//middle element before tail
		if(current_index == 1 && size == 3){
			node.next = tail;
			head.next = node;
			tail.next = null;
			return;
		}

		// set node in the middle of LinkedList
		if (current_index <= size) {
			node.next = current.next;
			current.next = node;
			return;
		}
	}

	public void addFirst(E value) {
		setCurrentLocation(0);
		insertAtLocation(value);
	}

	public void addLast(E value) {
		if(0 == size) {
			addFirst(value);
			return;
		} else setCurrentLocation(size);
		insertAtLocation(value);
	}
	
	public void addMiddle(E value){
		int i = size / 2;
		if (0 == size){
			addFirst(value);
			return;
		}
		if (i == size || 1 == size){
			addLast(value);
			return;
		}
		setCurrentLocation(i);
		insertAtLocation(value);
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean remove(E value) {

		Entry<E> previous = null;

		// step 1: head check if LinkedList is empty
		Entry<E> current = head;

		while (null != current) {

			// Removable node is in the LinkedList
			if (current.element.equals(value)) {
				
				// step 3b: Removable node is in the middle or in the end of
				// LinkedList
				if (previous != null) {

					// Removable node in the middle of the LinkedList
					previous.next = current.next;

					// Removable node in the end of LinkedList (change tail)
					if (null == current.next) {
						tail = previous;
					}
				} else {

					// step 2 or 3a: One element in Linked List (previous =
					// null) or removable node is first
					head = head.next;

					// List is empty now?
					if (null == head) {
						tail = null;
					}
				}
				size--;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;
	}
	
	public boolean contains(E value) {
		Entry<E> current = head;

		while (null != current) {
			if (current.element.equals(value)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	/**
	 * Class of node (special entity) for adding and removing into LinkedList
	 */
	private class Entry<E> {
		E element;
		Entry<E> next;

		Entry() {
		}
	}

}
