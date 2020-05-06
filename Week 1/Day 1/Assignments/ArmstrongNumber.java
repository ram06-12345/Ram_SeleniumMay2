package week1.day1;

public class ArmstrongNumber {
	
	public static void main(String[] args) {
		int num = 37;
		int reminder=0;
		int calculated=0;
		int original =num;
		while(num>0) {
			reminder=num%10;
			num=num/10;
			calculated= calculated+(reminder*reminder*reminder);
		}
		
		if (original==calculated)
		System.out.println(original +" is a armstrong number");		
		
		else{	
		System.out.println(original + " is not a armstrong number");
		}
			
		}
			
	}

