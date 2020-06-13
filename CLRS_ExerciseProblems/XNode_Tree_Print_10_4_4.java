import java.util.*;

public class XNode_Tree_Print_10_4_4{
	Node root;
	int size;

	static class Node{
		Node left_child; Node right_sibling; Node parent;
		int element;
		public Node(int e, Node left, Node right){
			element = e; left_child = left; right_sibling = right;
		}
	}	

	public void insert(Node i){
		Node x = root;
		Node y = null;
		while(x != null){
			y = x;
			if ( i.element < x.element) x = x.left_child;
			else {
				x = x.right_sibling;
			}
		}
		if (y == null) root = i;
		else {
			//System.out.println("y: " + y.element);
			//System.out.println("i: " + i.element);
			i.parent = y;
			if (i.element < y.element) {
				System.out.println("yleft: " + y.element);
				System.out.println("i: " + i.element);
				y.left_child = i;
			}
			else {
				System.out.println("yright: " + y.element);
	                        System.out.println("i: " + i.element);
				y = y.left_child; Node z = y;
				if (y.right_sibling != null && y.right_sibling.element < i.element) {
					while (y != null){
						z = y;
						y = y.right_sibling;
					}
				}
				if (z.right_sibling != null){		
					i.right_sibling = z.right_sibling.right_sibling;
				}
				z.right_sibling = i;
			}
		}
	} 

	public void insert(int i){
		Node n = new Node(i, null, null);
		insert(n);
	}
	
	// Iterative version - using Stack by Single linked list
        static class Stack{
                int size;
                stack_Node head;
                static class stack_Node{
                        stack_Node next; Node element;
                }

                public void Push(Node x){
                        stack_Node n = new stack_Node();
                        n.next = head;
                        n.element = x;
                        head = n;
                        size ++;
                }

       	 	public Node Pop(){
                	if (head == null) {
                		throw new EmptyStackException();
                	}
                	else {
                        	stack_Node n = head;
                        	head = head.next;
                        	size --;
                        	return n.element;
                	}
        	}
        }


	

	public void Recursive(Node n){
		if (n != null) {
			System.out.print(n.element + ",");
			Recursive(n.left_child);
			Recursive(n.right_sibling);
		}
	}	

	public void Iterative(Node n){
		Node prev = null; 
		Stack s= new Stack();
		s.Push(n);
		while(s.size != 0){
			n = s.Pop();
			System.out.print(n.element + ",");
			if (n.left_child != null) {
				s.Push(n.left_child); }
			if (n.right_sibling != null) {
				s.Push(n.right_sibling); }
	


			/*	prev = n;
				n = n.left_child;
			} else { 
				n = prev;
				if (n != null) {
					n = n.right_sibling;
					prev = n;
				}	
			}*/
		}
	}

	public static void main(String[] a){
		XNode_Tree_Print_10_4_4 x = new XNode_Tree_Print_10_4_4();
		x.insert(9); x.insert(4); x.insert(10); x.insert(11); x.insert(2); x.insert(8);
		x.insert(12); x.insert(1); x.insert(6); x.insert(5); x.insert(7);
		x.Recursive(x.root);
		System.out.println(" ");
		x.Iterative(x.root);
	}
}
