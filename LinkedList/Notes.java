
🧠 Linked List (Java Highlights)
  
1. What it is:
A dynamic chain of Node objects—no fixed size, each Node has int data and Node next.

2. Node structure:

class Node {
  int data;
  Node next;
  Node(int v) { 
    data = v; next = null; 
  }
}

3. Head & tail:
head points to the first node, the last node’s next is null.

4. Creation & insertion:
Easy to add/remove at head/tail in O(1) time (if tail is tracked), no shifts like in arrays.

5. Traversal:
Node cur = head; 
while(cur != null) { System.out.println(cur.data); cur = cur.next; }

6. References, not pointers:
Java references behave like pointers but abstracted—no manual memory access.

7. Memory trade-off:
Singly (next only), Doubly (prev + next), Circular (tail.next = head).

9. Built-in alternative:
java.util.LinkedList<E> is a doubly-linked list implementing List and Deque.

10. When to use:
Use for frequent insertions/deletions, unknown sizes, stack/queue implementations—avoid if random access is needed.
