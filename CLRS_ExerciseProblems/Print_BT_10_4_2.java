
import java.util.*;

public class Print_BT_10_4_2{
	Node root;
	int size;

	static class Node{
		int element;
		Node left; Node right;
		Node parent;

		public Node(int o, Node left, Node right){
			element = o; 	left = left;	right = right;
		}
	}

	private void insert(Node i){
		Node y = null;
		Node x = root;
		// iterate till we find exact place to insert
		while(x != null){
			y =x;
			if(x.element < i.element)
				x = x.right;
			else
				x = x.left;
		}
		//once determined that node will be parent of i
		if (y == null) root = i;
		else {
			i.parent = y;
			if(i.element < y.element)
				y.left = i;
			else
				y.right = i;
		}
	}

	public void insert(int element){
		Node n = new Node(element, null, null);
		insert(n);
	}

	
	public void recursive_print(Node n){
		if (n != null) {
			recursive_print(n.left);
			System.out.print(n.element + ",");
			recursive_print(n.right);
		}
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

	public void iterative_print(Node root){
		Stack s = new Stack();
		Node x = root;
		//s.Push(root);
		//inorder
		while (true){
			if (x != null) {
				s.Push(x);
				x= x.left;
			}
			else if (s.size != 0){
				x= s.Pop();
				System.out.print(x.element + ",");
				x = x.right;
			}
			else break;
		}
		/*while(s.size != 0){
			x = s.Pop();
			System.out.print(x.element + ",");
			if (x.left != null) 
				s.Push(x.left);
			if (x.right != null) 
				s.Push(x.right);
		}*/
	}

	public static void main(String[] args){
		Print_BT_10_4_2 b = new Print_BT_10_4_2();
		b.insert(9); b.insert(4); b.insert(14); b.insert(2); b.insert(12); b.insert(16);
		b.insert(1); b.insert(10);
		b.recursive_print(b.root);
		System.out.println(" ");
		b.iterative_print(b.root);
		//b.iterative_print(9);

	}
}
