import java.util.*;


public class Stack_SL_10_2_2{
	// PUSH is similar to Insert
	// POP is deleting first node
	
	Node head; int size;
	static class Node{
		Node next;
		int element;
	}

	public void Push(int x){
		Node n = new Node();
		n.next = head;
		n.element = x;
		head = n;
		size ++;
	}

	public boolean Pop(){
		if (head == null) {
		throw new EmptyStackException();
		}
		else {
			head = head.next;
			size --;
			return true;
		}
	}

	@Override public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Size" + size + "[");
		Node n = head;
		while(true){
			sb.append(n.element);
			n = n.next;
			if (n== null) 
			break;
			sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args){
		Stack_SL_10_2_2 s = new Stack_SL_10_2_2();
		s.Push(9); s.Push(4); s.Push(19);
		System.out.println(s);
		s.Pop();
		System.out.println(s);
	}

}
