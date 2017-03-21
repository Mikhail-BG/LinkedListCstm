package com.epam.trjava.linkedlistcstm.logic;

public class LinkedListCstmSimply {

	private int size = 0;

	// the first and the last nodes of Linked list
	private Entry _head;
	private Entry _tail;

	// Empty constructor
	public LinkedListCstmSimply() {
	}

	public void printListValues() {
		Entry temp = new Entry();
		temp = _head;
		while (temp != null) {
			System.out.println(temp.element);
			temp = temp.next;
		}
	}

	// add node in the list
	/*
	 * 1: create Entry with node 
	 * 2: find the last node 
	 * 3: set next field
	 * of last node on created node
	 */
	public void add(Object value) {

		//step 1
		Entry node = new Entry();
		node.element = value;
		node.next = null;

		//steps 2 and 3 steps: if this node is the first
		if (null == _head) {
			_head = node;
			_tail = node;

			// if this node is not the first
		} else {
			_tail.next = node;
			_tail = node;
		}
		size++;
	}


	//Remove node from the list
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

		//step 1: _head check if list is empty
		while (null != current) {

			// Removable node in the list
			if (current.element.equals(value)) {

				//step 3b: Removable node in the middle or in the end
				if (previous != null) {

					// Removable node in the middle of the list
					previous.next = current.next;

					// Removable node in the end of list (change _tail)
					if (null == current.next) {
						_tail = previous;
					}
				} else {

					//step 2 or 3a: One element (previous = null) or removable node is first
					_head = _head.next;

					// List is empty now?
					if (null == _head) {
						_tail = null;
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
	
	public void clear(){
		_head = null;
		_tail = null;
		size = 0;
	}
	
	public boolean contains(Object value){
		Entry current = _head;
		
		while (null != current){
			if(current.element.equals(value)){
				return true;
			}
			current = current.next;
		}
		
		return false;
	}
	
	public int size(){
		return size;
	}

	// Class of node (special entity) for adding and removing
	private static class Entry<E> {
		E element;
		Entry<E> next;

		Entry() {}
	}

}
