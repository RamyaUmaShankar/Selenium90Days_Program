package day5_class;

import java.util.*;

public class Dup_Char_In_String {
	
	public static void main(String[] args) {
		
		String str="When life gives you lemons, make lemonade";
		str=str.replace(" ", "");
		Set<Character> ls=new HashSet<Character>();
		
		for(int i=0;i<str.length();i++)
		{
			for(int j=i+1;j<str.length();j++)
			{
				if(str.charAt(i) == str.charAt(j)) {
					ls.add(str.charAt(i));
					break;
				}
			}
		
		}
		
		System.out.println(ls);
	}

}
