public class Reverse_SL_10_2_7{
	public static void main(String[] args){
		SL_List_10_2_1 s = new SL_List_10_2_1();
		s.insert(4); s.insert(64); s.insert(72); s.insert(67); s.insert(23);
		System.out.println(s);

		Node current = s.head;
		Node prev = null;
		while (current!= null){
			Node next1 = current.next;
			current.next = prev;
			prev = current;
			current = next1;
		}
		s.head = prev;
		
		System.out.println(s);
	}
}
