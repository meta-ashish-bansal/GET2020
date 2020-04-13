package chemistryproblem;

/**
 * 
 * @author Ashish
 *
 */

public class OrganicProblem {
	private static int noOfC, noOfH, noOfO;
	
	private static void massCalculate(String str, int value) {
		int i=0; 
		while (i < str.length()){
			char ch = str.charAt(i);
			if (ch == '('){
				String subString = "";
				while (str.charAt(++i) != ')')
					subString += str.charAt(i);
				if (Character.isDigit(str.charAt(++i))){
					int value1 = Integer.valueOf(str.charAt(i++))-'0';
					massCalculate(subString, value1);
				}
				else
					massCalculate(subString, value);
				ch = str.charAt(i);
			}
			
			if (ch == 'c'){
				if (Character.isDigit(str.charAt(i+1)) && str.charAt(i+1) != ' ')
					noOfC += (Integer.valueOf(str.charAt(i+1))-'0')*value;
				else
					noOfC += 1*value;
			}
			if (ch == 'o'){
				if (Character.isDigit(str.charAt(i+1)) && str.charAt(i+1) != ' ')
					noOfO += (Integer.valueOf(str.charAt(i+1))-'0')*value;
				else
					noOfO += 1*value;
			}
			if (ch == 'h'){
				if (Character.isDigit(str.charAt(i+1)) && str.charAt(i+1) != ' ')
					noOfH += (Integer.valueOf(str.charAt(i+1))-'0')*value;
				else
					noOfH += 1*value;
			}
			i++;
		}
	}
	
	private static void massFormula() {
		int massOfCarbon=12, massOfHydrogen=1, massOfOxygen=16;
		System.out.println("molecular mass of compound is: "+ (massOfCarbon*noOfC + massOfHydrogen*noOfH + massOfOxygen*noOfO));
	}

	public static void main(String[] args){
		String str = "c2h3(ch3)4c2h4";
		massCalculate(str+" ", 1);
		massFormula();
	}

}