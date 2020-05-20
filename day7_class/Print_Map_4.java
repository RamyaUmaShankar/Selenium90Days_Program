package day7_class;

import java.util.*;
import java.util.Map.Entry;

public class Print_Map_4 {
	
	public static void main(String[] args) {
		
		Map<String,Integer> m=new HashMap<String,Integer>();
		m.put("A", 1);
		m.put("B", 2);
		m.put("C", 3);
		m.put("D", 4);
		m.put("E", 5);
		
		
		m.entrySet().forEach( entry -> {
		    System.out.println( entry.getKey() + " => " + entry.getValue() );
		});
		}

}
