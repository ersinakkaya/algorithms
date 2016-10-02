package StacksAndQueues;
import java.lang.Iterable;
import java.util.Iterator;

public class Test<Item> implements Iterable<Item> {
	private Node<Item> first;
	private int N;
	
	private static class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
	
	
	public static void main(String[] args) {
		
	}


	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
