package week3.day1;

public class CalculatorOverLoading {
	public void add(int a, int b) {
		System.out.println(a+b);
	}
	public void add(int a, int b, int c) {
		System.out.println(a+b+c);
	}
	public void multiply(int a, int b) {
		System.out.println(a*b);
	}
	public void Multiply(int a, double b) {
		System.out.println(a*b);
	}
	public void sub(int a, int b) {
		System.out.println(a-b);
	}
	public void sub(double a, double b) {
		System.out.println(a-b);
	}
public void divide(int a, int b) {
	System.out.println(a/b);
	}
public void divide(int a, double b) {
	System.out.println(a/b);
	}

public static void main(String[] args) {
	CalculatorOverLoading calc =new CalculatorOverLoading();
	calc.add(5, 6);
	calc.add(5, 6, 7);
	calc.Multiply(5, 6.5);
	calc.multiply(5, 5);
	calc.divide(10, 5);
	calc.divide(10, 5.5);
	calc.sub(6.5, 5.5);
	calc.sub(9, 4);
}
}
