## Delete Node and Find the Cycle
A singly-linked list is built with nodes, where each node has:

node.next—the next node in the list.
node.data—the data held in the node. For example, if our linked list stores people in line at the movies, node.data might be the person's name.
For example:

```
  public static class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }
}
```

A cycle occurs when a node’s next points back to a previous node in the list. The linked list is no longer linear with a beginning and end—instead, it cycles through a loop of nodes.

Write a function containsCycle() that takes the first node in a singly-linked list and returns a boolean indicating whether the list contains a cycle.