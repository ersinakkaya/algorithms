/**
 * 1.3.42  Copy a stack. Create a new constructor for the linked-list implementation  
 * of Stack so that
 * 
 * Stack<Item> t = new Stack<Item>(s);
 * 
 */
package StacksAndQueues;

public class CopyAStack<Item> extends Stack<Item> {
	private CopyAStack<Item> t;
	private Node first;
	private int N;
	
	public CopyAStack(){
		
	}
	
	public CopyAStack(CopyAStack<Item> s) {
		t = s;
	}

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
	
	//printing the list
	public void printList() {
		System.out.println("final list:");
		Node current = first; 
		while(true){
			if(current == null) break;
			System.out.println(current.item);
			current = current.next;
		}
	}

	public static void main(String[] args) {
		//let's create a stack first
		CopyAStack<Integer> s = new CopyAStack<Integer>();
		//Let's add 10 random positive numbers to LinkedList first
		System.out.println("Integers:");
		for(int i=0; i<10; i++){
			int randomPositiveInteger = (int) (Math.random() * 100) + 1;
			//System.out.println(randomPositiveInteger);
			s.push(randomPositiveInteger);
		}
		
		s.printList();
		CopyAStack<Integer> t = new CopyAStack<Integer>(s);
		System.out.println(t.t.size());
		t.t.printList();
	}
}