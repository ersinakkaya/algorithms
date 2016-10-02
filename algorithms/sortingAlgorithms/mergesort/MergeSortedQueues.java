package Sorting;

import java.util.Iterator;
import java.util.LinkedList;

public class MergeSortedQueues {
	
		public static LinkedList<Integer> merge(LinkedList<Integer> queue1, LinkedList<Integer> queue2){
			LinkedList<Integer> mergedQueue = new LinkedList<Integer>();
			
			int item1 = queue1.remove();
			int item2 = queue2.remove();
	    	while(true){
	    		if(item1 > item2){
	    			mergedQueue.add(item2);
	    			if(queue2.isEmpty()){
		    			while(queue1.size() > 0){
		    				mergedQueue.add(queue1.remove());
		    			}
		    			break;
		    		}
	    			item2 = queue2.remove();
	    		}
	    		else{
	    			mergedQueue.add(item1);
	    			if(queue1.isEmpty()){
		    			while(queue2.size() > 0){
		    				mergedQueue.add(queue2.remove());
		    			}
		    			break;
		    		}
	    			item1 = queue1.remove();
	    		}
	    	}
	    	
			return mergedQueue;
		}
		
	    public static void main(String[] args) {
	    	LinkedList<Integer> queue1 = new LinkedList<Integer>();
	    	queue1.add(1);
	    	queue1.add(5);
	    	queue1.add(6);
	    	queue1.add(7);
	    	queue1.add(8);
	    	queue1.add(10);
	    	queue1.add(40);
	    	queue1.add(50);
	    	queue1.add(70);
	    	
	    	LinkedList<Integer> queue2 = new LinkedList<Integer>();
	    	queue2.add(2);
	    	queue2.add(8);
	    	queue2.add(15);
	    	queue2.add(20);
	    	queue2.add(21);
	    	queue2.add(30);
	    	
	    	LinkedList<Integer> mergedQueue = merge(queue1, queue2);
	    	
	    	System.out.println("Show mergedQueue items");
	    	Iterator<Integer> i = mergedQueue.iterator();
	    	while(i.hasNext()){
	    		System.out.println(mergedQueue.pop());
	    	}
		}
	
	
}
