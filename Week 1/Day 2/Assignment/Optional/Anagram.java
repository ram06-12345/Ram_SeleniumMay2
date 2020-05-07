package week1.day2;

import java.util.Arrays;

public class Anagram {
	public static void main(String[] args) {
		String text1 = "stops";
		String text2 = "potss";
		String text3="";
		String text4="";
		
		char[] word1=text1.toCharArray();
		Arrays.sort(word1);
		char[] word2=text2.toCharArray();
		Arrays.sort(word2);
		
		if(text1.length()==text2.length()) {
		
		for (int i = 0; i < word1.length; i++) {
			for (int j = 0; j < word2.length; j++) {
				if(word1[i]==word2[j]) {
					 text3=text3.concat(String.valueOf(word1[i]));
					 text4=text4.concat(String.valueOf(word1[j]));
					break;}				
			}			
			
		}if(text3.equals(text4)) {System.out.println("Given words are Anagram");}
			else {System.out.println("Given words are not an Anagram");}
		}else
			System.out.println("Given words are not an Anagram");
		}
	
	}
