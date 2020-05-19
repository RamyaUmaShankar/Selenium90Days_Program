package day6_class;

import java.util.*;

public class Remove_Duplicate_Character_From_List {

	public static void main(String[] args) {

		List<Character> ls=new ArrayList<Character>();
		ls.add('A');
		ls.add('B');
		ls.add('C');
		ls.add('D');
		ls.add('A');
		ls.add('D');
		ls.add('E');
		ls.add('F');

		Set<Character> s=new HashSet<Character>(ls);
		System.out.println(s);

	}

}
