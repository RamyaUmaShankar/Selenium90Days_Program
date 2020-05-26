package Day9_May_26;

import java.util.*;

public class Sort_Reverse_Array {
	public static void main(String[] args) {
		
		int[] array = {5,1,33,79,22,11,45};
		
		Arrays.sort(array);
		System.out.println("Sorted:");
		for(int i=0;i<array.length;i++)
		System.out.print(array[i] + " ");
		
		System.out.println("\nReversed:");
		for(int i=array.length-1; i>=0;i--)
		System.out.print(array[i] + " ");
		
	}

}
