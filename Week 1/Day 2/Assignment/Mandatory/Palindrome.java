package week1.day2;

public class Palindrome {
	public static void main(String[] args) {
		String name="mom";
		char[] arr=name.toCharArray();
		String rev="";
		
		for (int i = arr.length-1; i >= 0; i--) {
		rev=rev.concat(String.valueOf(arr[i]));
		}	
		if(rev.equals(name)) { 
	System.out.println("palindrome");
		}
		else {
		System.out.println("not a palindrome");
	}
	
}
}

