package com.epam.trjava.linkedlistcstm.logic;

public class LinkedListCstmAddPos<E> {

	/** Number of elements in LinkedList */
	private int size = 0;

	/** The first element of LinkedList */
	private Entry<E> head;

	/** The last element of LinkedList */
	private Entry<E> tail;

	private int p_index;

	private Entry<E> current;

	public LinkedListCstmAddPos() {}

	/**
	 * Method for printing elements of LinkedList
	 */
	public void printListValues() {
		System.out.println("size = " + size);
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
			this.p_index = i;
		}
	}

	private void insertAtLocation(E value) {
		Entry<E> node = new Entry<E>();
		node.element = value;

		// set the first into LinkedList
		if (p_index == 0) {
			head = node;
			node.next = current;
		}

		// set the last into LinkedList
		if (p_index == (size)) {
			tail = node;
			node.next = null;
		}

		// set node in the middle of LinkedList
		if (0 < p_index & p_index <= (size - 1)) {
			node.next = current.next;
			current.next = node;
		}
		size++;
	}

	public void addFirst(E value) {
		setCurrentLocation(0);
		insertAtLocation(value);
	}

	public void addLast(E value) {
		setCurrentLocation(size - 1);
		insertAtLocation(value);
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
