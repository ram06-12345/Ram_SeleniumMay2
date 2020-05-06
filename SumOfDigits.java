package week1.day1;

public class SumOfDigits {
	public static void main(String[] args) {
		int num =123;
		int sum=0;
		int	rem=0;
		
		System.out.print("Sum of the digit "+num+" = ");
		while(num>0) {
			rem = num%10;
			num=num/10;
			sum=sum+rem;
		}
		System.out.print(sum);
		}
		}
