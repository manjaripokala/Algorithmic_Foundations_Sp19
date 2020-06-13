public class DL_List_10_2_8 {
	
	Entry header;
	int size;

	static class Entry{
		Entry next;
		Entry prev;
		Object element;

		Entry(Object o, Entry next, Entry prev){
			element = o;
			prev = prev;
			next = next;
		}
	} 

	public DL_List_10_2_8(){
		header = new Entry(null,null,null);
		header.next = header;
		header.prev = header;
		size = 0;
	}

	public void insert(Entry e){
		e.next = header.next;
		System.out.println(e);
		
		System.out.println(0xfae2^0xbed2);
		header.next.prev = e;
		header.next = e;
		e.prev = header;
		size++ ;
	}

	public void add(Object o){
		Entry e = new Entry(o, null, null);
		insert(e);
	}

	public void delet(Entry x){
		x.prev.next = x.next;
		x.next.prev = x.prev;
		size --;
	}

	
	public void remove(Object o){
		Entry e = search(o);
		if (e == null) throw new IllegalArgumentException();
		delet(e);
	}

	public Entry search(Object o){
		Entry h = header;
		while(h != null && h.element != o){
			h=h.next;
		}
		return h;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Size:" + size + "Elements are: [");
		Entry x = header;
		while(x!=null){
			sb.append(x.element);
			x = x.next;
			if (x == header) break;
			sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		DL_List_10_2_8 d = new DL_List_10_2_8();
		System.out.println("d: " + d);
		d.add(9); d.add(667); d.add(21); d.add(867);
		System.out.println(d);
		System.out.println((d.search(9)).element);
                System.out.println(d);
		d.remove(21);
		System.out.println(d);
	}

}
