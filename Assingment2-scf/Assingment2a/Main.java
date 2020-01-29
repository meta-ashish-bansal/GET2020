import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		HexCalci hexa       = new HexCalci();
		Scanner sc          = new Scanner(System.in);

		System.out.println(" enter first Hexadecimal number ");		
		String firstNumber  = sc.nextLine();

		System.out.println("Enter second Hexadecimal number");
		String secondNumber = sc.nextLine();

		System.out.println("decimal of first number is\t"+ hexa.toDecimal(firstNumber));
		System.out.println("decimal of second number is\t"+ hexa.toDecimal(secondNumber));
		System.out.println("\nsum of both number in hexadecimal is\t"+hexa.add(firstNumber, secondNumber));
		System.out.println("difference of both the number is\t"+hexa.subtract(firstNumber, secondNumber));
		System.out.println("multiplication of both the number is\t"+hexa.multiply(firstNumber, secondNumber));
		System.out.println("division of both the number is\t"+hexa.divide(firstNumber, secondNumber));
		System.out.println("\nfirst number is equal to second\t\t"+hexa.isEqual(firstNumber, secondNumber));
		System.out.println("first number is greater than second\t"+hexa.isGreater(firstNumber, secondNumber));
		System.out.println("first number is less than  second\t"+hexa.isLesser(firstNumber, secondNumber));
		
		System.out.println("Enter any decimal no. to convert it into hexadecimal no.");
		String decNumber = sc.nextLine();
		System.out.println("After conversion\t"+hexa.toHexaDecimal(decNumber));
		

	}

}