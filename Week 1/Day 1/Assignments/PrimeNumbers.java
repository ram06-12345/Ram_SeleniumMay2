package week1.day1;

public class PrimeNumbers {
	public static void main(String[] args) {
		int input = 14;
		boolean flag = true;
		
		for (int i = 2; i <= input/2; i++) {
			
			if(input%i==0) {
				flag =false;
				break;
			}
		}
	if(flag)
		System.out.println(input+ " is a prime number");
		
		else 
			System.out.println(input+" is not a prime number");
		
	}
		
}

