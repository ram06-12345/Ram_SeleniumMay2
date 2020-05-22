package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
	public static void main(String[] args) {
		String text = "PayPal India";
		char[] charArray = text.toCharArray();
		
		Set<Character> charset=new LinkedHashSet<Character>();
		Set<Character> dupCharset=new LinkedHashSet<Character>();
		
		for (Character eachChar : charArray) {
			
			if(!charset.add(eachChar)) {
				dupCharset.add(eachChar);
			}
			
		}
		charset.removeAll(dupCharset);
		for (Character character : charset) {
			if(character!= ' ') {
			System.out.print(character);
		}
		}
	}

}
