/**
 * 1.3.26  Write a method remove() that takes a linked list 
 * and a string key as arguments and removes all of the nodes 
 * in the list that have key as its item field.
 * 
 */

package StacksAndQueues;

public class LinkedListRemove<Item> {

	private Node first = null;
	private Node last = null;
	private int N = 0;

	private class Node {
		Item item;
		Node next;
	}

	public int size() {
		return N;
	}

	public void enqueue(Item item) {
		Node oldlast = last;

		last = new Node();
		last.item = item;
		last.next = null;

		if (first == null) {
			first = last; 
		} else {
			oldlast.next = last;
		}

		N++;
	}

	public void remove(LinkedListRemove<Item> q, Item key) {
		// empty node checker
		if (first == null) return; 

		// first remove consecutive Keys from the list
		Node newfirst = first;
		while(true) {
			if (newfirst == null) break;

			if (newfirst.item.equals(key)) {
				newfirst = newfirst.next;
				N--;
			} else
				break;
			
		}
		first = newfirst;
		
		// empty node checker
		if (first == null) return; 

		// now we remove rest matched nodes
		Node current = first;
		while (true) {
			if (current == null) break;

			// find the non-key node "Node after" after current node
			Node after = current.next;
			while(after != null) {
				if (after.item.equals(key)) {
					after = after.next;
					N--;
				} else {
					break;
				}
			}

			// modify current node's next field
			current.next = after;

			// process that non-key node
			current = after;
		}
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

		LinkedListRemove<String> q = new LinkedListRemove<String>();
		String s = "to to be to or to or not to to be to be";
		System.out.println("initial string:" + s);
		String[] split = s.split(" ");
		for(int i=0;i<split.length; i++){
			q.enqueue(split[i]);
		}
		
		String key = "to";
		q.remove(q, key);		
		q.printList();
	}

}