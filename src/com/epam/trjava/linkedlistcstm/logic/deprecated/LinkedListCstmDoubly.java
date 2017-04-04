package com.epam.trjava.linkedlistcstm.logic.deprecated;

/**
 * Class creates Doubly LinkedList
 * 
 * @autor Mikhail Bahatyrou
 * @version 1.0
 */
public class LinkedListCstmDoubly {

	/** Number of elements in LinkedList */
	private int size = 0;

	/** The first element of LinkedList */
	private Entry head;

	/** The last element of LinkedList */
	private Entry tail;

	/** Empty constructor */
	public LinkedListCstmDoubly() {
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
	 * Method adds the first node into LinkedList Mission: step 1: set next
	 * field into the new node linked to previous first node; step 2: set prev
	 * field into previous first node linked to new node; step 3: refresh tail
	 * if needed and increment size;
	 * 
	 * @param value
	 *            Object to add in LinkedList
	 * @deprecated Here we add nodes in the end of LinkedList
	 */

	public void addFirst(Object value) {

		Entry node = new Entry();
		node.element = value;

		Entry temp = head;

		// step 1
		head = node;
		head.next = temp;

		if (0 == size) { // step 3
			tail = head;
		} else {
			// step 2
			temp.prev = head;
		} // step 3
		size++;
	}

	/**
	 * Method adds the last node into LinkedList. Mission: necessary to create
	 * new node and refresh head and tail
	 * 
	 * @param value
	 *            Object to add in LinkedList
	 */
	public void addLast(Object value) {
		Entry node = new Entry();
		node.element = value;

		if (0 == size) {
			head = node;
		} else {
			tail.next = node;
			node.prev = tail;
		}

		tail = node;
		size++;
	}

	/**
	 * Method adds node in the end of LinkedList
	 * 
	 * @param value
	 *            Object to add in LinkedList
	 */
	public void add(Object value) {
		addLast(value);
	}

	/**
	 * Method removes the first node of LinkedList If the list is empty - do
	 * nothing.
	 */
	public void removeFirst() {
		if (0 != size) {
			head = head.next;
			size--;
		}
		if (size == 0) {
			tail = null;
		} else {
			head.prev = null;
		}
	}

	/**
	 * Method removes the last node of LinkedList If the list is empty - do
	 * nothing.
	 */
	public void removeLast() {
		if (0 == size) {
			if (1 == size) {
				head = null;
				tail = null;
			} else {
				tail.prev.next = null;
				tail = tail.prev;
			}
			size--;
		}
	}

	/**
	 * Method removes the node by the value from LinkedList. Mission: 1: List is
	 * empty, do nothing; 2: One removable node, set previous = null 3: some of
	 * removable nodes: 3a: removable node is the first; 3b: removable node in
	 * the middle or in the end of the list.
	 * 
	 * @param value
	 *            Object to remove from LinkedList
	 * @return true if node was removed, and false if not.
	 */
	public boolean remove(Object value) {

		Entry previous = null;
		Entry current = head;

		// step 1: head check if list is empty
		while (null != current) {

			// Removable node in the list
			if (current.element.equals(value)) {

				// step 3b: Removable node in the middle or in the end
				if (previous != null) {

					// Removable node in the middle of the list
					previous.next = current.next;

					// Removable node in the end of list (change tail)
					if (null == current.next) {
						tail = previous;
					} else {

						// step 2 or 3a: One element (previous = null) or
						// removable
						// node is first
						current.next.prev = previous;
					}
					size--;
				} else {
					removeFirst();
				}
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
		Entry<E> prev;

		Entry() {}
	}
}
