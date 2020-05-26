package Day9_May_26;

import java.util.*;

public class Common_Num_2Arrays {
	public static void main(String[] args) {
		
		int[] array1 = { 1, 2, 5, 5, 8, 9, 7, 10 };
		int[] array2 = { 1, 0, 6, 15, 6, 4, 7, 0 };
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		System.out.print("\nArray1: ");
		for(int i=0; i<array1.length; i++)
		{
			System.out.print(array1[i] + " ");
			
		}
		System.out.print("\nArray2: ");
		for(int i=0; i<array2.length; i++)
		{
			
			System.out.print(array2[i]+ " ");
		}
		
		System.out.print("\n\nCommon numbers: ");
		for(int i=0; i<array1.length; i++)
		{
	
			for(int j=0; j<array2.length; j++)
			{
			if(array1[i]==array2[j])
			{
			System.out.print(array1[i] + " ");
			
		}
	}
		}
	}
}
