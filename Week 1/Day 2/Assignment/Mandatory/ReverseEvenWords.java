package week1.day2;

public class ReverseEvenWords {
	public static void main(String[] args) {
		
		String test ="I am a software tester";
		String[] word=test.split(" ");
		
		for (int i = 0; i < word.length; i++) {
			if(i%2!=0) {
				StringBuffer a = new StringBuffer(word[i]);
				StringBuffer rev=a.reverse();
				String b=rev.toString();				
				word[i]=b;									
			}
			
			System.out.print(word[i]+" ");
			}
					
				}
			}
			
	

