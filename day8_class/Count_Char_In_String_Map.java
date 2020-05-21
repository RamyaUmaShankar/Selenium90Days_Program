package day8_class;

import java.util.*;

public class Count_Char_In_String_Map {
public static void main(String[] args) {
	
	String str="Karma is powerful than God";
	char[] c = str.toCharArray();
	int count=0;
	
	LinkedHashMap<Character,Integer> map=new LinkedHashMap<Character,Integer>();
	
	for(int i=0;i<str.length();i++)
	{
		for(int j=0;j<str.length();j++)
		{
		char ch=str.charAt(i);
		if(c[j]==ch)
		{
			count++;
			map.put(c[i], count);
			
		}
	}
		count=0;
	}
	
	
		System.out.println(map);

	
	
}
}
