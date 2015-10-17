package is.ru.stringcalculator;

public class Calculator {
	
	public static int add(String text) throws Exception{
		if(text.equals("")){
			return 0;
		}

		String [] textArray = splitNumbers(text);

		return sum(textArray);
/*
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}

		else if(text.contains("\n")){
			return sum(splitNumbers(text));
		}

		else if(text.startsWith("//")){
			return sum(splitNumbers(text));
		}

		else
			//ef það er bara ein tala slegin inn
			return toInt(text);

			*/
	}

	private static int toInt(String number) throws Exception{
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers) throws Exception{
		String delimiter = ",|\n";
		if (numbers.startsWith("//")) {
			
			String newDelimeter = "";
			newDelimeter += numbers.charAt(2);
			String newString = numbers.substring(4, numbers.length());
			
			return newString.split(newDelimeter);
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