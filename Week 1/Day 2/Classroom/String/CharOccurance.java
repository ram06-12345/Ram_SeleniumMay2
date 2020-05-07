package week1.day2;

public class CharOccurance {
	public static void main(String[] args) {
		String str = "welcome to chennai";		
		char[] arr= str.toCharArray();
		String str1 ="";
		int count=1;
		
		for (int i = 0; i < arr.length; i++) {
			if(!str1.contains(String.valueOf(arr[i]))){
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]==arr[j]) 
					count++;
			}
			str1=str1.concat(String.valueOf(arr[i]));
			System.out.println(arr[i] +"-"+ count);
			count=1;
		}
		}
	}
}
