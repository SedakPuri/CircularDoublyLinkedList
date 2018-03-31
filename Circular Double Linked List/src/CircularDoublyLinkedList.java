/*Sedak Puri
 * Lab02
 * Intro to CS 3
 * Note: I worked a little bit with Evan Gill on this lab
 */

public class CircularDoublyLinkedList<E> {
	private Node<E> cursor;
	private int size;

	public CircularDoublyLinkedList() {
		cursor = null;
		size = 0;
	}

	/**
	 * Method to add nodes after the cursor value
	 * @param value is the generic value you wish to add to cursor
	 */
	public void addAfterCursor(E value) {
		Node<E> newNode;
		if (size == 0) {
			newNode = new Node<E>(value, null, null);
			cursor = newNode;
			newNode.next = cursor;
			newNode.prev = cursor;
			size++;
		} else {
			newNode = new Node<>(value, cursor.next, cursor); 
			cursor.next = newNode;
			newNode.next.prev = newNode;
			size++;
		}
	}

	/**
	 * Method to delete the node at the cursor
	 * @return the value stored at deleted node
	 */
	public E deleteCursor() {
		if (size == 0) {
			throw new IllegalStateException("The list is empty!");
		}
		
		E value = cursor.value;
		if (size == 1) {
			cursor = null;
			--size;
			return value;
		}

		cursor.prev.next = cursor.next;
		cursor.next.prev = cursor.prev;
		cursor = cursor.next;
		size--;
		return value;		
	}
	
	/**
	 * Method to print the linked list
	 */
	public void printList() {
		System.out.println("The list contains: ");
		if (size == 0) {
			System.out.println("List is empty");
			return;
		} else {
			for (int i = 0; i < size;i++) {
				System.out.print(getValue() + " ");
				advanceCursor(1);
			}
		}
		
	}

	/**
	 * Method to advance the cursor position
	 * @param n is the amount of times you wish to advance the cursor
	 */
	public void advanceCursor(int n) {
		if (size == 0) {
			return;
		}

		for(int i = 0; i < n; i++) {
			cursor = cursor.next;
		}
	}

	/**
	 * Method to get the value stored at the cursor
	 * @return the value stored at node
	 */
	public E getValue() {
		if (size == 0) {
			throw new IllegalStateException("List is empty!");
		}
		return cursor.value;
	}
	
	public int getSize() {
		return size;
	}

	private static class Node<T>
	{
		private T value;
		private Node<T> next;
		private Node<T> prev;

		public Node(T v, Node<T> n, Node<T> p)
		{
			value = v;
			next = n;
			prev = p;
		}

		public String toString()
		{
			return value.toString();
		}
	}
}
