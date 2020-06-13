/**
 * 
 */
package sample;

import java.util.Scanner;

/**
 * @author manjaripokala
 *
 */
public class Linear_search_Exercise_2_1_3{
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		//Input array elements
		System.out.println("Enter size of an array:");
		int num = reader.nextInt();
		int arr[] = new int[num];
		System.out.println("Enter elements of array");
		for(int i=0; i<arr.length; i++){
			arr[i] = reader.nextInt();
		}
		// Enter a number to search
		System.out.println("Enter a number:");
		int v = reader.nextInt();
		reader.close();
		//Linear Search
		boolean found_flag = false;
		for(int i=0; i<arr.length; i++){
			if (arr[i] == v){
				System.out.println(v + "Found at position" + i);
				found_flag = true;
			}
		}
		if (found_flag == false){
			System.out.println("NIL");
		}
	}
}

