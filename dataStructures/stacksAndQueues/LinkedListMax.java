/**
 * 1.3.27  Write a method max() that takes a reference to the first node in a linked list as argument
 * and returns the value of the maximum key in the list. Assume that all keys are positive integers,
 * and return 0 if the list is empty.
 * 
 * 1.3.28 Develop a recursive solution to the previous question.
 */

package StacksAndQueues;

public class LinkedListMax<Item> {

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
	
	//returns the maximum
	public int max(Node first){
		if(first == null){
			return 0;
		}
		//assign the default max as 0
		Integer max = 0;
		Node current = first;
		
		while(true){
			if((int)current.item > max){
				max = (Integer) current.item;
			}
			if(current.next == null){
				break;
			}
			current = current.next;
		}
		return max;
	}
	
	//returns the maximum as recursive solution
	public int maxRecursive(Node current, Integer max){
		if(current == null){
			return 0;
		}
		
		if((int)current.item > max){
			max = (int) current.item;
		}
		
		if(current.next != null){
			return maxRecursive(current.next, max);
		}
		
		return max;
	}

	//printing the list
	private void printList() {
		System.out.println("final list:");
		Node current = first; 
		while(true){
			if(current == null) break;
			System.out.println(current.item);
			current = current.next;
		}
		
	}

	public static void main(String[] args) {
		LinkedListMax<Integer> q = new LinkedListMax<Integer>();
		//Let's add 10 random positive numbers to LinkedList first
		System.out.println("Integers:");
		for(int i=0; i<10; i++){
			int randomPositiveInteger = (int) (Math.random() * 100) + 1;
			q.push(randomPositiveInteger);
		}
		q.printList();
		int maximumPositiveInteger = q.max(q.first);
		System.out.println("Maximum Positive Integer on the stack is: " + maximumPositiveInteger);
		
		//let's assign default max as 0
		int maximumPositiveIntegerRecursive = q.maxRecursive(q.first, 0);
		System.out.println("Maximum Positive Integer on the stack from recursive is: " + maximumPositiveIntegerRecursive);
	}

}