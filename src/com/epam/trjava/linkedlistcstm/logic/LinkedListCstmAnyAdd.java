package com.epam.trjava.linkedlistcstm.logic;

public class LinkedListCstmAnyAdd<E> {
	/** Number of elements in LinkedList */
	private int size = 0;

	/** The first element of LinkedList */
	private Entry<E> head;

	/** The last element of LinkedList */
	private Entry<E> tail;

	public LinkedListCstmAnyAdd() {
	}

	/**
	 * Method for printing elements of LinkedList
	 */
	public void printListValues() {
		Entry<E> temp = new Entry<E>();
		temp = head;
		while (temp != null) {
			System.out.println(temp.element + " @ " + temp.index);
			temp = temp.next;
		}
	}
	
	/**
	 * Method adds element at first position of LinkedList
	 * 
	 * @param value - value of adding element
	 */	
	public void addFirst(E value){
		insertNode(value, 0);
		//the very first element
		if(size == 0){
			tail = head;
		}
	}

	/**
	 * Method adds element at last position of LinkedList
	 * 
	 * @param value - value of adding element
	 */	
	public void addLast(E value) {
		if(0 == size){
			addFirst(value);
		} else {
			insertNode(value, size);
		}
	}
	
	/**
	 * Method adds element in the middle position of LinkedList
	 * 
	 * @param value - value of adding element
	 */	
	public void addMiddle(E value){
		if(0 == size){
			addFirst(value);
			return;
		} 
		int i = size / 2;
		if(i == size || 1 == size) {
			addLast(value);
			return;
		}
		insertNode(value, (size / 2));
	}
	
	/**
	 * Auxiliary method adds element in LinkedList according index
	 * 
	 * @param value - value of adding element
	 * @param index - position of adding element
	 */	
	private void insertNode(E value, int startIndex){
		Entry<E> node = new Entry<E>();
		node.element = value;
		node.index = startIndex;
		
		Entry<E> current = head;
		
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
	
	/**
	 * Auxiliary method rebuilds indexes when element added
	 * 
	 * @param next - starting element for index rebuilding
	 */	
	private void increaseIndexForEach(LinkedListCstmAnyAdd<E>.Entry<E> next){
		while(null != next){
			next.index++;
			next = next.next;
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
				
				decreaseIndexForEach(current);
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
	 * Auxiliary method rebuilds indexes when element removed
	 * 
	 * @param next - starting element for index rebuilding
	 */	
	private void decreaseIndexForEach(LinkedListCstmAnyAdd<E>.Entry<E> current){
		while(null != current){
			current.index--;
			current = current.next;
		}
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
	 * Method return the size of LinkedList
	 * 
	 * @return number of elements
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Class of node (special entity) for adding and removing into LinkedList
	 */
	private class Entry<E> {
		E element;
		Entry<E> next;
		int index;

		Entry() {}
	}
}
