package day8_class;

import java.util.*;

public class Count_Char_In_String_Map2 {
public static void main(String[] args) {
	
	String str="Karma is powerful than God";
    LinkedHashMap <Character, Integer> map = new LinkedHashMap<>();
    for (int i = str.length() - 1; i >= 0; i--) {
       if (map.containsKey(str.charAt(i))) {
          int count = map.get(str.charAt(i));
          map.put(str.charAt(i), ++count);
       } else {
          map.put(str.charAt(i),1);
       }
    }
    System.out.println(map);
	
	
}
}
