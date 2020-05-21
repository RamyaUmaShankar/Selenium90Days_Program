package day8_class;

import java.util.*;

public class Count_Char_In_String_Map3 {
	public static void main(String[] args) {

		String str="Karma is powerful than God";
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();

		char[] ch = str.toCharArray();
		for (char c : ch)
		{
			if(map.containsKey(c))
			{
				map.put(c, map.get(c)+1);
			}
			else
			{
				map.put(c, 1);
			}
		}
		
		System.out.println(str+" : "+map);
	}	
}

