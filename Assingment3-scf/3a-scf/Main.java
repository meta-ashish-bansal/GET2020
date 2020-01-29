
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {


		MyString string = new MyString();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter two strings");
		String s1 = in.nextLine();
		String s2 = in.nextLine();
	
		System.out.println("Are both Strings equal = "+string.isEqual(s1,s2));
		
		System.out.println("Reverse of first String is = "+string.reverse(s1));
		System.out.println("Reverse of second String is = "+string.reverse(s2));
		
		System.out.println("After changing case of string 1 = "+string.changeCases(s1));
		System.out.println("After changing case of string 2 = "+string.changeCases(s2));
		
		System.out.println("Largest word in string 1 = "+string.largestWord(s1));
		System.out.println("Largest word in string 2 = "+string.largestWord(s2));


	}

}
