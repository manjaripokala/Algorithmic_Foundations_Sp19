

public class SL_List_10_2_1 {
	int size;
	Node head;

//	static class Node {
//		int element;
//		Node next;
//	}	

	public void insert(int x){
		Node n = new Node();
		n.element = x;
		n.next = head;
		head = n;
		size ++;			
	}

	public Node search(int x){
                Node n = new Node();
		n = head;
		while(n != null && n.element != x){
			n = n.next;
		}
		return n;
        }

	
	public boolean delet(int x){
		Node n = head;
		Node prev = null;
		while(n != null && n.element != x){
			prev = n;
                        n = n.next;
                }
		System.out.println(n.element);;
		if (n == null)
			return false;
		else {
			prev.next = n.next;
			size --;
			return true;
		}
	}

	@Override public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("size" + size);
		sb.append("[");
		if (head != null) {
			Node current = new Node();
			current = head;
			while(true){
				sb.append(current.element);
				current = current.next;
				if (current == null) break;
				sb.append(',');
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args){
		SL_List_10_2_1 s = new SL_List_10_2_1();
		System.out.println(s);
		s.insert(9);
		s.insert(4);
		s.insert(14);
		System.out.println(s);
		System.out.println(s.delet(4));
		System.out.println(s);
		Node n = s.search(9);
		System.out.println(n.element);
		
	}

}
