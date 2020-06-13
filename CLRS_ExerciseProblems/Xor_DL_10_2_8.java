public class Xor_DL_10_2_8{
	Entry header;
	int size;

	static class Entry{
		Object element;
		Entry np;

		Entry(Object o, Entry np){
			element = o; np = np;
		}
	}

	public Xor_DL_10_2_8(){
		header = new Entry(null, null);
		header.np = null;
	}

	public void insert(Object o){
		Entry new_node = new Entry(o, ((int)header) ^ 0);
		if (header != null){
			Entry next = (header.np) ^ null;
			header.np = new_node ^ next; 
		}
		header = new_node;
	}

	public String toString(){
		Entry current = header;
		prev = null; Entry next;
		StringBuilder sb = new StringBuilder();
		while(current != null){
			sb.append(current.element);
			next = current.np ^ prev;
			prev = current;
			current = next; 
			if (current == null) break;
			sb.append(",");
		}

		return toString();
	}

	public static void main(String[] a){
		Xor_DL_10_2_8 x = new Xor_DL_10_2_8();
		System.out.println(x);
		x.insert(9);
		System.out.println(x);
	}
}
