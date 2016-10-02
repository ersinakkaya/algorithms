package StacksAndQueues;

public class Stack<Item> {
	private Node first;
	private int N;
	
	//Nested class to define nodes
	private class Node {
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return N;
	}

	//Add item at the top of the stack
	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

	//Remove item from top of stack
	public Item pop(){
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
}