package week1.day2;

public class SumOfDigitsFromString {
	public static void main(String[] args) {
		String text = "Tes12Le79af65";
		int sum = 0;
		String replace=text.replaceAll("[A-Za-z]", "");
		char[] s1=replace.toCharArray();
		for (int i = 0; i < s1.length; i++) {
			sum=sum+Character.getNumericValue(s1[i]);
		}
		System.out.println("Sum of the numeric values in String: "+sum);
	}
}
