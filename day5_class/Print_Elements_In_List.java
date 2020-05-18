package day5_class;

import java.util.*;

public class Print_Elements_In_List {
	
	public static void main(String[] args) {
		
		List<Character> ls=new ArrayList<Character>();
		
		char c[]= {'B','u','g','a','t','t','i',' ','C','h','i','r','o','n'};
		
		for(int i=0;i<c.length;i++)
		{
			ls.add(i, c[i]);
		}
		System.out.println("First Approach: " + ls);
		
		System.out.println("***************");
		System.out.print("Second Approach:");
		for(int i=0;i<c.length;i++)
		{
			System.out.print(ls.get(i).toString());
		}
		
		System.out.println("\n***************");
		System.out.print("Third Approach:");
		int t=0;
		while(t<c.length)
		{
			System.out.print(c[t]);
			t++;
		}
		
		System.out.println("\n***************");
		System.out.print("Fourth Approach:");
		for (char d : ls) {
			System.out.print(d);			
		}
		
	}

}
