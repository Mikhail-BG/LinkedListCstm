package com.epam.trjava.linkedlistcstm.logic;

/**
 * Class implements realization of Simply Linked List with the possibility to
 * add element at first, at last positions and in the middle.
 * 
 * The idea: define the current position inside LinkedList. Element adding
 * implemented with methods addFirst, addLast and addMiddle. The method
 * addMiddle inserts element in position: (size of LinkedList / 2)
 * 
 * @autor Mikhail Bahatyrou
 * @version 1.0
 */

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

	public LinkedListCstmAddPos() {
	}

	/**
	 * Method returns the First element of LinkedList
	 * 
	 * @return head of the LinkedList
	 */
	public Entry<E> getFirst() {
		return head;
	}

	/**
	 * Method inserts element at the first position
	 */
	public void addFirst(E value) {
		setCurrentLocation(0);
		insertAtLocation(value);
	}

	/**
	 * Method inserts element at the last position. If LinkedList is empty the
	 * method addFirst works.
	 */
	public void addLast(E value) {
		if (0 == size) {
			addFirst(value);
			return;
		} else
			setCurrentLocation(size);
		insertAtLocation(value);
	}

	/**
	 * Method inserts element at the middle. If LinkedList is empty the method
	 * addFirst works. If this is the second iteration, addLast works.
	 */
	public void addInPosition(E value, int index) {
		if (isIndexValid(index)) {
			int i = index;
			if (0 == size) {
				addFirst(value);
				return;
			}
			if (i == size || 1 == size) {
				addLast(value);
				return;
			}
			setCurrentLocation(i - 1);
			insertAtLocation(value);
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
	 */
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

	/**
	 * Method return the size of LinkedList
	 * 
	 * @return number of elements
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Method returns false if LinkedList is empty
	 * 
	 * @returns false if empty, true if not
	 */
	public boolean isEmpty() {
		return (0 == size);
	}

	/**
	 * Method checks if LinkedList contains the value
	 * 
	 * @param value
	 *            Object for checking
	 * @return true if LinkedList contains, false if not
	 */
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
	 * Method clears LinkedList
	 */
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Method return the value of the node in LinkedList
	 * 
	 * @param index
	 *            - number of element in the LinkedList
	 * 
	 * @return the value of certain node
	 */
	public E getNodeByIndex(int index) {
		if (isIndexValid(index)) {
			setCurrentLocation(index);
			return current.element;
		}
		return null;
	}

	/**
	 * Method check if index is valid
	 * 
	 * @param index
	 *            - number of element in the LinkedList
	 * 
	 * @return true if element with certain index exists, false if not
	 */
	private boolean isIndexValid(int index) {
		if (index < 0 || index >= size) {
			System.err.println("Index out of bounds");
			return false;
		}
		return true;
	}

	/**
	 * Auxiliary method defines current position and index into LinkedList,
	 * method sets current_index and current as element after which will be
	 * added new element
	 */
	private void setCurrentLocation(int index) {
		for (int i = 0; i <= index; i++) {
			if (0 == i) {
				current = head;
			} else {
				current = current.next;
			}
			this.current_index = i;
		}
	}

	/**
	 * Auxiliary method inserts new element at position. It is possible 5
	 * situations: 1 - set element on the first iteration when LinkedList is
	 * created; 2 - set element at the first position; 3 - set element at the
	 * last position; 4 - set element before the last position; 5 - set element
	 * in the middle
	 */
	private void insertAtLocation(E value) {
		Entry<E> node = new Entry<E>();
		node.element = value;

		size++;

		// 1. first iteration
		if (current_index == 0 && size == 1) {
			node.next = null;
			head = node;
			tail = node;
			return;
		}

		// 2. set the first into LinkedList
		if (current_index == 0 && size > 1) {
			node.next = head;
			head = node;
			return;
		}

		// 3. set the last into LinkedList
		if (current_index == (size - 1) && size >= 1) {
			node.next = null;
			tail.next = node;
			tail = node;
			return;
		}

		// 4. middle element before tail
		if (current_index == size - 1) {
			node.next = tail;
			head.next = node;
			tail.next = null;
			return;
		}

		// 5 set node in the middle of LinkedList
		if (current_index <= size) {
			node.next = current.next;
			current.next = node;
			return;
		}
	}

	/**
	 * Class of node (special entity) for adding and removing into LinkedList
	 */
	static class Entry<T> {
		T element;
		Entry<T> next;

		Entry() {
		}
	}
}
