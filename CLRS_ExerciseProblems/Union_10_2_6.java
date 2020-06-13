// We can use Single linked list because getting nodes and inserting takes O(1) time


public class Union_10_2_6{
	public static void main(String[] args){
		Q_SL_10_2_3 s1 = new Q_SL_10_2_3();
		s1.enq(4); s1.enq(9); s1.enq(89); s1.enq(76);
		
		Q_SL_10_2_3 s2 = new Q_SL_10_2_3();
                s2.enq(14); s2.enq(19); s2.enq(45); s2.enq(34);		

		Q_SL_10_2_3 s3 = s1;
		s3.tail.next = s2.head;
	
		System.out.println(s3);
	}
}
