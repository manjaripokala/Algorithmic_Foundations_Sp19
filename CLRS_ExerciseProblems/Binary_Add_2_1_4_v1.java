/* Formal Statement:
        Input: Two integer arrays of 'n' elements A[a0,a1,.....an-1] and B[b0,b1,b2,....bn-1] each representing integers stored in binary format. 
        They consist of 0's and 1's and least significant bit is in last position.
        Output: An array C of (n+1) elements C[c0,c2,....cn] such that C'=A'+B', where A',B',C' are integers represented by A,B,C.
*/



// To add two n-bit binary integers 
//Store result in binary form into an (n+1) element array C

import java.lang.Math.*;
import java.util.*;

public class Binary_Add_2_1_4_v1{
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter size of A & B:");
		int size = reader.nextInt();
		int[] A = new int[size];
                int[] B = new int[size];
		int[] C = new int[size+1];

		// Input n_bit arrays
		System.out.println("Enter elements of A:");
		for(int i=0; i<size; i++){
			A[i] = reader.nextInt();
		}
		System.out.println("Enter elements of B:");
                for(int i=0; i<size; i++){
                        B[i] = reader.nextInt();
                }
		int int_A = 0; int int_B = 0; int int_C = 0;
		// Convert binary to Decimal
		System.out.println("entering for A");
		for (int i=0; i<A.length; i++){
			int exponent_A = (A.length - 1) - i;
			int_A = int_A + (int)(Math.pow(2,exponent_A) * A[i]);
		}
		System.out.println("int_A" + int_A);
		// Convert binary to Decimal
		for (int j=0; j<A.length; j++){
			int exponent_B = (B.length - 1) - j; 
                        int_B = int_B + (int)(Math.pow(2,exponent_B) * B[j]);
                }
		System.out.println("int_B:" + int_B);
		// Compute 'C'
		int_C = int_A + int_B;
		System.out.println("int_C:" + int_C);
		//int length_C = A.length + 1;
		System.out.println("Length of array C:" + C.length);
		for(int k =(C.length - 1); k>=0; k--){
			C[k] = int_C % 2;
			int_C = int_C/2;
		}
		for(int i=0; i<C.length; i++){
		//	System.out.println("i:" + i);
			System.out.println("Elements of C:" + C[i]);
		}

	}
} 
