package symbolTablesAndBST;

public class SequentialSearchST<Key, Value>
{
    private int N;           // number of key-value pairs
    private Node first;

    private class Node
    {// linked-list node  
        // first node in the linked list
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next)
        {
          this.key  = key;
          this.val  = val;
          this.next = next;
        } 
    }

    public Value get(Key key)
    {  // Search for key, return associated value.
        for (Node x = first; x != null; x = x.next)
        if (key.equals(x.key))
        return x.val;    // search hit
        return null;           // search miss
    }

    public void put(Key key, Value val)
    {  // Search for key. Update value if found; grow table if new.
        for (Node x = first; x != null; x = x.next)
        if (key.equals(x.key))
        {
            x.val = val; return;
        }// Search hit: update val.

        first = new Node(key, val, first); // Search miss: add new node.
    }

    //Returns the number of items in symbol table
    public int size() {
        return N;
    }

    //Removes the key and associated value from the symbol table
    public void delete(Key key) {
        first = delete(first, key);
    }

    // delete key in linked list beginning at Node x
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            N--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    //get all keys in the symbol table by iterating
	public Value[] keys()  {
    	Value values[] = null;
    	int i = 0;
    	if(N > 0){
    		for (Node x = first; x != null; x = x.next) {
                values[i] = x.val;
                i++;
    		}
    	}    	
        return values;
    }
	public static void main(String[] args) {
		/*
		Random r = new Random();
		int Low = 10;
		int High = 100;
		int Result = r.nextInt(High-Low) + Low;
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		for(int i = 0; i< 10; i++){
			st.put(String.valueOf(i), Math.round(Math.random() * 100));
		}
		*/
	}

}