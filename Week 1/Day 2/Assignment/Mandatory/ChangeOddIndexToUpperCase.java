package week1.day2;

public class ChangeOddIndexToUpperCase {
	public static void main(String[] args) {
		String test = "changeme";
		char[] arr= test.toCharArray();
		char str;
		
		for (int i = 0; i < arr.length; i++) {
			if(i%2!=0) {
				str=Character.toUpperCase(arr[i]);
				arr[i]=str;
				}			
		}
		
		System.out.println(arr);
	}

}
