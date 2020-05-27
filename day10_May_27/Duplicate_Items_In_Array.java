package day10_May_27;

import java.util.*;

public class Duplicate_Items_In_Array {
	public static void main(String[] args) {
		
		int[] array1 ={1, 2, 5, 5, 6, 6, 7, 2};

		Arrays.sort(array1);
		
		System.out.print("\nArray1: ");
		for(int i=0; i<array1.length; i++)
		{
			System.out.print(array1[i] + " ");
			
		}
		
		
		System.out.print("\n\nDuplicate numbers: ");
		for(int i=0; i<array1.length; i++)
		{
	
			for(int j=i+1; j<array1.length; j++)
			{
			if(array1[i]==array1[j])
			{
			System.out.print(array1[i] + " ");
			
		}
	}
		}
	}
}
