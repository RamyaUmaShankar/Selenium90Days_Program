package day2_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfNumbers {
	public static void main(String[] args) {
		
		String str="asdf1qwer9as8d7";
		Pattern p = Pattern.compile("\\d");
		Matcher m = p.matcher(str);
		int count=0;
		while(m.find())
		{
			String group = m.group();
			int c = Integer.parseInt(group);
			count=count+c;
		}
		System.out.println(count);
		
	
	}

}
