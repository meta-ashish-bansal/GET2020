
/**
 * HexCalci is a class to perform various operations on hexadecimal numbers 
 * like addition,subtraction,multiplication,division of 2 hexadecimal number
 */


class HexCalci {

	String hexnum="0123456789ABCDEF";

	
	/**
	 * add function adds 2 hexadecimal number and return addition in form of Hexadecimal number as String	
	 * assumption is made that both the number are positive integer
	 */
	String add(String firstNumber,String secondNumber)
	{
		int sum = Integer.parseInt(toDecimal(firstNumber)) + Integer.parseInt(toDecimal(secondNumber));
		return toHexaDecimal((Integer.toString(sum)));
	}



	/**
	 * subtract function subtract the first hexadecimal number by second hexadecimal number
	 * and return hexadecimal number as String
	 */
	String subtract(String firstNumber,String secondNumber)
	{	
		if(isEqual(firstNumber, secondNumber))
			return "0";

		if(isLesser(firstNumber, secondNumber))
		{
			int subtraction = Integer.parseInt(toDecimal(secondNumber)) - Integer.parseInt(toDecimal(firstNumber));
			System.out.print("**Arguments order is reversed for subtraction** \t");
			return toHexaDecimal((Integer.toString(subtraction)));
		}

		int subtraction = Integer.parseInt(toDecimal(firstNumber)) - Integer.parseInt(toDecimal(secondNumber));
		return toHexaDecimal((Integer.toString(subtraction)));
	}



	/**
	 * multiply function multiplies two hexadecimal number and returns hexadecimal number in form of string
	 */
	String multiply(String firstNumber,String secondNumber)
	{
		int multiplie = Integer.parseInt(toDecimal(firstNumber)) * Integer.parseInt(toDecimal(secondNumber));
		return toHexaDecimal((Integer.toString(multiplie)));
	}



	/**
	 * divide function divides the hexadecimal numbers and return the hexadecimal number in form of string
	 */
	String divide(String firstNumber,String secondNumber)
	{

		if(isLesser(firstNumber, secondNumber))
			return "0";

		int division = Integer.parseInt(toDecimal(firstNumber)) / Integer.parseInt(toDecimal(secondNumber));
		return toHexaDecimal((Integer.toString(division)));
	}



	/**
	 * toDecimal function converts the hexadecimal no. into decimal no.
	 */
	String toDecimal(String number)
	{
		number=number.toUpperCase();
		int length=number.length();
		int decimal=0;
		float exponent=0;

		for(int i=length-1;i>=0;i--)
		{	
			if(hexnum.indexOf(number.charAt(i))>=0)    //indexOf returns index value if the char exists and return -1 if not exists
			{
				char character =  number.charAt(i);
				int  num       =  hexnum.indexOf(character);
				decimal 	   += num * (int)Math.pow(16, exponent); 
			}
			else
			{
				System.out.println("invalid input");
				break;
			}
			exponent++;			
		}
		return Integer.toString(decimal);
	}



	/**
	 * toHexaDecimal method convert the decimal number to hexadecimal
	 */
	String toHexaDecimal(String number)
	{
		String hex = "";
		int reminder;
		int integerOfNumber = Integer.parseInt(number);
		
		while(integerOfNumber>0)
		{
			reminder=integerOfNumber % 16;
			hex = hexnum.charAt(reminder) + hex;
			integerOfNumber = integerOfNumber/16;
		}
		return hex;
	}



	/**
	 * isGreater method returns true if the first number is greater than the second number else return false
	 */
	boolean isGreater(String firstNumber,String secondNumber)
	{
		if(firstNumber.length()>secondNumber.length())
			return true;
		else if(firstNumber.length()==secondNumber.length())
		{
			int flag=0;
			for(int i=0;i<firstNumber.length();i++)
			{
				if(firstNumber.charAt(i)>secondNumber.charAt(i))				
					return true;
				
				else if(firstNumber.charAt(i)<secondNumber.charAt(i) )			
					return false;
			
				else			
					continue;			
			}
		}

		return false;
	}



	/**
	 *isLesser method returns true if the first number is less than the second number else return false
	 */
	boolean isLesser(String firstNumber,String secondNumber)
	{
		if(!isEqual(firstNumber, secondNumber)&&!isGreater(firstNumber, secondNumber))
			return true;
		else
			return false;
	}



	/**
	 * isEqual method returns true if the first number is equal to the second number else return false
	 */
	boolean isEqual(String firstNumber,String secondNumber)
	{
		if(firstNumber.length()!=secondNumber.length())
			return false;

		else if(firstNumber.length()==secondNumber.length())
		{	
			for(int i=0;i<firstNumber.length();i++)
			{
				if(firstNumber.charAt(i)==secondNumber.charAt(i))				
					continue;
				
				else if(firstNumber.charAt(i)!=secondNumber.charAt(i) )				
					return false;				
			}
		}
		
		return true;
	}
}