package com.interview.cake;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
public class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }
    
    public static void deleteNode(LinkedListNode node){
    	if(node.next != null){
    		LinkedListNode next = node.next;
    		node.value = next.value;
    		node.next = next.next;
    	}
    	else{
    		node = null;
    	}
    }
    
    //Hashmap solution, effective but not O(1) space complexity
    public static boolean containsCycleHash(LinkedListNode first){
    	
    	LinkedListNode node = first;
    	
    	Map<Integer, Boolean> map = new HashMap<>();
    	while(node.next != null){
    		if(map.containsKey(node.value)){
    			return true;
    		}
    		else{
    			map.put(node.value, true);
    		}
    	}
    	return false;
    }
    
    public static boolean containsCycle(LinkedListNode first){
    	
    	LinkedListNode fastRunner = first;
    	LinkedListNode slowRunner = first;
    	
    	while(fastRunner != null && slowRunner != null){
    		slowRunner = slowRunner.next;
    		fastRunner = fastRunner.next.next;
    		
    		//fast is about to lap slowrunner
    		if(fastRunner == slowRunner){
    			return true;
    		}
    	}
    	return false;
    }
    public static void main(String[] args){
		LinkedListNode a = new LinkedListNode(1);
		LinkedListNode b = new LinkedListNode(2);
		LinkedListNode c = new LinkedListNode(3);
		LinkedListNode d = new LinkedListNode(4);
		LinkedListNode e = new LinkedListNode(5);
		LinkedListNode f = new LinkedListNode(1);
		LinkedListNode g = new LinkedListNode(2);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		//deleteNode(b);
		System.out.println(containsCycleHash(a));
    }
}

//deleteNode(b);