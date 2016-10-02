import java.util.Random;

public class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }
    
	  public static void main(String[] args)
	  {
		  LinkedListNode a = new LinkedListNode(5);
		  LinkedListNode b = new LinkedListNode(1);
		  LinkedListNode c = new LinkedListNode(9);

		  a.next = b;
		  b.next = c;
		  
	  }
}
