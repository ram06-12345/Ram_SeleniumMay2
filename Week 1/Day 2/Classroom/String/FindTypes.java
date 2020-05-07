package week1.day2;

public class FindTypes {
	
	public static void main(String[] args) {
		
		String test = "$$ Welcome to 2nd Class of Automation $$ ";
		
		char[] arr= test.toCharArray();
		int letter =0;
		int space=0;
		int num =0;
		int specialChar=0;
		
		for (int i = 0; i < arr.length; i++) {
			
			if(Character.isLetter(arr[i]))
				letter++;
			else if(Character.isDigit(arr[i]))
				num++;
			else if(Character.isSpaceChar(arr[i]))
				space++;
			else
				specialChar++;
			
		}
		
		System.out.println("letter: " + letter);
		System.out.println("space: " + space);
		System.out.println("number: " + num);
		System.out.println("specialCharcter: " + specialChar);

		
	}
	
	
}
