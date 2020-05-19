package day6_class;

import java.util.*;

public class Retrieve_Value_From_Set {

	public static void main(String[] args) {
		
		HashSet<Integer> s=new HashSet<Integer>();
		int t=7;
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		s.add(6);
		s.add(7);
		s.add(8);
		s.add(9);
		
		List<Integer> ls=new ArrayList<Integer>(s);
		System.out.println(ls.get(6));
		
		
	}
}
