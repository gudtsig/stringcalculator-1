package is.ru.stringcalculator;

public class Calculator {
	
	public static int add(String text) throws Exception{
		if(text.equals("")){
			return 0;
		}

			String [] textArray = splitNumbers(text);

			return sum(textArray);
		
		

	}

	private static int toInt(String number) throws Exception{
		return Integer.parseInt(number);
	}

	private static String[] splitDelimiterNumbers(String numbers, String delimiter) throws Exception{
		
		return numbers.split(delimiter);

	}

	private static String[] splitNumbers(String numbers) throws Exception{
		String delimiter = ",|\n";
		String newDelimiter = "";

		if (numbers.startsWith("//")) {
			/*
			if (numbers.contains("[") ) {
				int delimiterStart = numbers.indexOf("[")+1;
				int delimiterEnd = numbers.indexOf("]");
				int newStringLength = numbers.indexOf("n")+1;

				newDelimiter += numbers.substring(delimiterStart, delimiterEnd);
				String newString = numbers.substring(newStringLength);

			
				return newString.split(newDelimiter);
				
			}

			else {*/
			newDelimiter += numbers.charAt(2);
		
			String newString = numbers.substring(4);
		
			return newString.split(newDelimiter);
		//}
			
		}

		else {
			
			return numbers.split(delimiter);
		}
	    
	}

	private static void isNegative(String[] numbers) throws Exception  {
		String stringOfNegative = ""; 
        
        for(int number = 0; number < numbers.length; number++){

        	if (toInt(numbers[number]) < 0) {
        		
        		stringOfNegative += numbers[number];	
        		
        		if (number + 1 < numbers.length){
        			
        			stringOfNegative += ", ";
        		}
        	}

		}

		if (stringOfNegative.length() > 0) {
        		
        		throw new Exception ( "Negatives not allowed:" + stringOfNegative);
        	}

	}	

	 	private static int sum(String[] numbers) throws Exception{
	   isNegative(numbers);
	    int total = 0;

    	for(String number : numbers){
	    
		    if(toInt(number) <= 1000) {
		    	total += toInt(number);
			}
	    }

		return total;
    }

}