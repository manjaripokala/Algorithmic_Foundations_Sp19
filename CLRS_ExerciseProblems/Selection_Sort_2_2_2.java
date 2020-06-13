import java.util.*;

public class Selection_Sort_2_2_2{

	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter Size of array:");
		int size = reader.nextInt();
		int[] A = new int[size];
		System.out.println("Enter elements of array:");
		for(int k=0; k<size; k++){
			A[k] = reader.nextInt();
		}
		System.out.println("Elements of array are:");
		for(int k=0; k<size; k++){
		System.out.println(A[k]);
		}
		selection_sort(A);
		System.out.println("Elements after sort:");
                for(int k=0; k<size; k++){
                System.out.println(A[k]);
                }
	}

	// Selection Sort
	public static void selection_sort(int[] A){
		for (int i=0; i<A.length-1; i++){
			int low = A[i];
			int low_index = i;
			for(int j=i+1; j<A.length; j++){
				if (A[j] <= low){
					low=A[j];
					low_index = j;
				}
			/*else {
					low = A[i];
					low_index = i;
				}*/
			}	
		A[low_index] = A[i];
		A[i] = low;
		System.out.println("Elements after " + i + "th iteration:");
                for(int k=0; k<A.length; k++){
                System.out.println(A[k]);
                }
		}
	}
}
