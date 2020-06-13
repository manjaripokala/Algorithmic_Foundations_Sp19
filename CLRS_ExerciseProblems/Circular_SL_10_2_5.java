public class Circular_SL_10_2_5{
	Node head; Node tail;
	int size;

	public void enq(int x){
		Node n = new Node();
		n.element = x;
		if (head == null && tail == null){
			head = n;
			tail = n;
		}else {
			tail.next = n;
			tail = n;
		}
		tail.next = head;
		size++;
	}

	public Node deq(){
		if (head == null) throw new NullPointerException();
		Node n = null;
		if (head == tail) {
			n = head;
			head = null;
		} else {
			n = head;
			head = head.next;
		}
		tail.next = head;
		size --;
		return n;
	}

	public Node Search(int x){
		Node n = head;
		while (n != null && n.element != x){
			if (n == tail) {
				n=null; break;
			}
			n= n.next;
		}
		return n;
	}

	@Override public String toString(){
                StringBuilder sb = new StringBuilder();
                sb.append("Size" + size + "[");
                if (head != null){
			Node n = head;
                	while(true){
                        	sb.append(n.element);
                        	n = n.next;
                        	if (n== head)
                        	break;
                        	sb.append(",");
                	}
		}	
                sb.append("]");
                return sb.toString();
        }

	public static void main(String[] args){
		Circular_SL_10_2_5 c = new Circular_SL_10_2_5();
		c.enq(4); c.enq(9); c.enq(14); c.enq(19);
		System.out.println(c);
		Node n = c.Search(10); System.out.println("search" + n);
		n = c.Search(9); System.out.println("search" + n.element);
		n = c.deq();
		System.out.println("deq" + n.element);
		System.out.println(c);
		n = c.deq();
		System.out.println("deq" + n.element);
                System.out.println(c);
		n = c.deq(); 
		System.out.println("deq" + n.element);
		System.out.println(c);
		n = c.deq(); System.out.println("deq" + n.element); System.out.println(c);
	}
}
