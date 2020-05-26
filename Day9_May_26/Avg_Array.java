package Day9_May_26;

import java.util.*;

public class Avg_Array {
	public static void main(String[] args) {
		
		int[] array =  {20, 30, 25, 35, -16, 60, -100};
int sum=0;
		
		Arrays.sort(array);
		
		for(int i=0;i<array.length;i++)
		sum++;
		
		System.out.println("Average: " + sum);
	}

}
