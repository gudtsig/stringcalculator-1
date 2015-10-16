package is.ru.stringcalculator;

public class Calculator {

	//	private String delimeter = (",|\n");

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}

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
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){

		if (numbers.startsWith("//")) {
			String newDelimeter = "";
			newDelimeter += numbers.charAt(2);
			String newString = numbers.substring(4, numbers.length());
			
			return newString.split(newDelimeter);
		}

		else {
			return numbers.split(",|\n");
		}
	    
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }



}