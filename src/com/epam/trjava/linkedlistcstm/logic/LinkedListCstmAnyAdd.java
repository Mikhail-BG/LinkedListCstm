package com.epam.trjava.linkedlistcstm.logic;

public class LinkedListCstmAnyAdd {
	/** Number of elements in LinkedList */
	private int size = 0;

	/** The first element of LinkedList */
	private Entry head;

	/** The last element of LinkedList */
	private Entry tail;

	/** Empty constructor */
	public LinkedListCstmAnyAdd() {
	}

	/**
	 * Method for printing elements of LinkedList
	 */
	public void printListValues() {
		Entry temp = new Entry();
		temp = head;
		while (temp != null) {
			System.out.println(temp.element + " @ " + temp.index);
			temp = temp.next;
		}
		System.out.println("----");
	}
	
	public void addFirst(Object value){
		insertNode(value, 0);
		//the very first element
		if(size == 0){
			tail = head;
		}
	}

	/**
	 * @param value
	 *            Object to add in LinkedList
	 */
	public void addLast(Object value) {
		if(0 == size){
			addFirst(value);
		} else {
			insertNode(value, (size));
		}
	}
	
	public void addMiddle(Object value){
		if(0 == size){
			addFirst(value);
		} else {
			insertNode(value, (size / 2));
		}
	}
	
	private void insertNode(Object value, int startIndex){
		Entry node = new Entry();
		node.element = value;
		node.index = startIndex;
		
		Entry current = head;
		
		if (startIndex == 0) {
			node.next = head;
			head = node;
		}
		
		while(null != current){
			
			//set next node for the node before added node
			//set next for added node
			if(current.index == (startIndex - 1)){
				node.next = current.next;
				current.next = node;
			}
			tail = current;
			current = current.next;
		}
		increaseIndexForEach(node.next);
		size++;
	}
	
	private void increaseIndexForEach(Entry<Object> startEntry){
		while(null != startEntry){
			startEntry.index++;
			startEntry = startEntry.next;
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
		int index;

		Entry() {}
	}
}
