package day3_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidation{
	
	public static void main(String[] args) {
		
		String str="Balaji1";
		//String str="Testleaf$123";
		//String str="testleaf";
		
			String pat="[a-zA-Z0-9._$@]{8,}";
			Pattern p = Pattern.compile(pat);
			Matcher m = p.matcher(str);
			System.out.println(m.matches());
			
		
	}

}
