


public class Q_SL_10_2_3{
	Node head = null; Node tail = null;
	int size;
	
	static class Node{
		Node next;
		int element;
	}
	
	public void enq(int x){
		Node n = new Node();
		n.element = x;
		if (head == null && tail == null){
			head = n;
			tail = n;
			size ++;
		} else {
			tail.next = n;
			tail = n;
			size ++;
		}
	}

	public Node deq(){
		if (head == null) 
			throw new NullPointerException();
		else {
			Node n = head;
			head = head.next;
			size --;
			return n;
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
		Q_SL_10_2_3 q = new Q_SL_10_2_3();
		q.enq(9); q.enq(4); q.enq(14);
		System.out.println(q);
		Node n = q.deq();
		System.out.println(n.element);
		 n = q.deq();
		System.out.println(n.element);
		System.out.println(q);
	}
}
