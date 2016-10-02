package cracking.the.coding.interview;

import java.util.HashSet;

class LinkedList<E> {
	
	private Node first;
	private Node last;
	private E data;
	
	private class Node{
		E data;
		Node next;
	}
	
	public LinkedList(){
		this.first = new Node();
		this.last = new Node();
		first.next = last;
	}
	
	public void addFirst(E data){
		if(first.data == null){
			first.data = data;
		}
		else{
			Node node = new Node();
			node.data = data;
			node.next = first;
			this.first = node;
		}
	}
	
	public void addLast(E data){
		if(last.data == null){
			last.data = data;
		}
		else{
			Node node = new Node();
			node.data = data;
			node.next = new Node();
			last.next = node;
			last = node;
		}
	}
	
	public void print() {
        Node curr = first;
        while(curr.next != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
	
	public Node getFirst(){
		return this.first;
	}
	
	public void deleteDuplicates(){
		Node node = this.first;
		HashSet<E> set = new HashSet<E>();
		Node previous = null;
		while(node != null){
			if(set.contains(node.data)){
				previous.next = node.next;
			}
			else{
				set.add(node.data);
				previous = node;
			}
			node = node.next;
		}
	}
	
	public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.addFirst("Apple");
        list.addLast("Bear");
        list.addLast("Chair");
        list.addLast("Bear");
        list.print();
        
        list.deleteDuplicates();
        System.out.println("after deleting dups");
        list.print();
        
        
    }
}
