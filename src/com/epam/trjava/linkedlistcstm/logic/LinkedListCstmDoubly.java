package com.epam.trjava.linkedlistcstm.logic;

public class LinkedListCstmDoubly {

	private int size = 0;

	// the first and the last nodes of Linked list
	private Entry _head;
	private Entry _tail;

	// Empty constructor
	public LinkedListCstmDoubly() {
	}

	public void printListValues() {
		Entry temp = new Entry();
		temp = _head;
		while (temp != null) {
			System.out.println(temp.element);
			temp = temp.next;
		}
	}

	// addFirst method
	/*
	 * 1: set next field into new node linked to previous first node 
	 * 2: set prev field into previous first node linked to new node 
	 * 3: refresh _tail if needed and increment size
	 */
	public void addFirst(Object value) {

		Entry node = new Entry();
		node.element = value;

		Entry temp = _head;

		// step 1
		_head = node;
		_head.next = temp;

		if (0 == size) {
			// step 3
			_tail = _head;
		} else {
			// step 2
			temp.prev = _head;
		}
		// step 3
		size++;
	}

	// addLast method node into list
	/*
	 * Necessary to create new node and refresh _head and _tail
	 */
	public void addLast(Object value) {
		Entry node = new Entry();
		node.element = value;

		if (0 == size) {
			_head = node;
		} else {
			_tail.next = node;
			node.prev = _tail;
		}

		_tail = node;
		size++;
	}

	// add node in the list
	/*
	 * 1: create Entry with node 
	 * 2: find the last node 
	 * 3: set next field of last node on created node
	 */
	public void add(Object value) {
		addLast(value);
	}

	// removeFirst method removes the first node from the list. If the list is
	// empty - do nothing.
	public void removeFirst() {
		if (0 != size) {
			_head = _head.next;
			size--;
		}
		if (size == 0) {
			_tail = null;
		} else {
			_head.prev = null;
		}
	}

	// removeLast method remove the last node of the list. If the list is empty,
	// - do nothing.
	public void removeLast() {
		if (0 == size) {
			if (1 == size) {
				_head = null;
				_tail = null;
			} else {
				_tail.prev.next = null;
				_tail = _tail.prev;
			}
			size--;
		}
	}

	// remove(value) - removes the first element with value, return true if
	// deleted, and false if not.
	/*
	 * 1: List is empty, do nothing; 
	 * 2: One removable node, set previous = null
	 * 3: some of removable nodes: 
	 * 3a: removable node is the first; 
	 * 3b: removable node in the middle or in the end of the list.
	 */
	public boolean remove(Object value) {

		Entry previous = null;
		Entry current = _head;

		// step 1: _head check if list is empty
		while (null != current) {

			// Removable node in the list
			if (current.element.equals(value)) {

				// step 3b: Removable node in the middle or in the end
				if (previous != null) {

					// Removable node in the middle of the list
					previous.next = current.next;

					// Removable node in the end of list (change _tail)
					if (null == current.next) {
						_tail = previous;
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

	public void clear() {
		_head = null;
		_tail = null;
		size = 0;
	}

	public boolean contains(Object value) {
		Entry current = _head;

		while (null != current) {
			if (current.element.equals(value)) {
				return true;
			}
			current = current.next;
		}

		return false;
	}

	public int size() {
		return size;
	}

	// Class of node (special entity) for adding and removing
	private static class Entry<E> {
		E element;
		Entry<E> next;
		Entry<E> prev;

		Entry() {
		}
	}

}
