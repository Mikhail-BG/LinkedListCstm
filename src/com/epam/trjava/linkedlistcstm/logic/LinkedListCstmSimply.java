package com.epam.trjava.linkedlistcstm.logic;

/**
 * Class creates Simply LinkedList
 * 
 * @autor Mikhail Bahatyrou
 * @version 1.0
 */
public class LinkedListCstmSimply {

	/** Number of elements in LinkedList */
	private int size = 0;

	/** The first element of LinkedList */
	private Entry head;

	/** The last element of LinkedList */
	private Entry tail;

	/** Empty constructor */
	public LinkedListCstmSimply() {
	}

	/**
	 * Method for printing elements of LinkedList
	 */
	public void printListValues() {
		Entry temp = new Entry();
		temp = head;
		while (temp != null) {
			System.out.println(temp.element);
			temp = temp.next;
		}
	}

	/**
	 * Method adds new node into LinkedList. Mission: step 1: create Entry with
	 * node with value and next fields; step 2: find the last node; step 3: set
	 * next field of last node on created node.
	 * 
	 * @param value
	 *            Object to add in LinkedList
	 */
	public void add(Object value) {
		// step 1
		Entry node = new Entry();
		node.element = value;
		node.next = null;

		// steps 2 and 3 steps: if this node is the first
		if (null == head) {
			head = node;
			tail = node;

			// if this node is not the first
		} else {
			tail.next = node;
			tail = node;
		}
		size++;
	}

	/**
	 * Method removes the node by the value from LinkedList. Mission: 1: List is
	 * empty, do nothing; 2: One removable node, set previous = null 3: some of
	 * removable nodes: 3a: removable node is the first; 3b: removable node in
	 * the middle or in the end of the list.
	 * 
	 * @param value
	 *            Object to remove from LinkedList
	 */
	public boolean remove(Object value) {

		Entry previous = null;

		// step 1: head check if LinkedList is empty
		Entry current = head;

		while (null != current) {

			// Removable node is in the LinkedList
			if (current.element.equals(value)) {

				// step 3b: Removable node is in the middle or in the end of
				// LinkedList
				if (previous != null) {

					// Removable node in the middle of the LinkedList
					previous.next = current.next;

					// Removable node in the end of LinkedList (change _tail)
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

	/**
	 * Method clears LinkedList
	 */
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Method checks if LinkedList contains the value
	 * 
	 * @param value
	 *            Object for checking
	 * @return true if LinkedList contains, false if not
	 */
	public boolean contains(Object value) {
		Entry current = head;

		while (null != current) {
			if (current.element.equals(value)) {
				return true;
			}
			current = current.next;
		}

		return false;
	}

	/**
	 * Method return the size of LinkedList
	 * 
	 * @return number of elements
	 */
	public int size() {
		return size;
	}

	/**
	 * Class of node (special entity) for adding and removing into LinkedList
	 */
	private static class Entry<E> {
		E element;
		Entry<E> next;

		Entry() {}
	}
}
