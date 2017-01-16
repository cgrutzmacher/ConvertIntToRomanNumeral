package roman_numeral;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

// Integer to Roman Numeral Converter
// By: Christopher Grutzmacher
// 2016-10-28

public class ConvertIntToRomanNumeral {
	
	private static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		String cont = "y";
		int userNum = 0;
		String rnString = "";
		LinkedHashMap<String, Integer> romanNumerals;
		romanNumerals = buildMap();
		
		while(cont.equalsIgnoreCase("y")) {
		
			userNum = getInt("Please input a number: ");
			rnString = getAmount(romanNumerals, userNum);		
			System.out.println("Your number in Roman Numerals is:  " + rnString);
			cont = getChoiceString("Continue? ", "y", "n");
		
		}

	}
	
	private static LinkedHashMap buildMap() {
		LinkedHashMap<String, Integer> romanNumerals = new LinkedHashMap<String, Integer>(){{
			put("M", 1000);
			put("CM", 900);
			put("D", 500);
			put("CD", 400);
			put("C", 100);
			put("XC", 90);
			put("L", 50);
			put("XL", 40);
			put("X", 10);
			put("IX", 9);
			put("V", 5);
			put("IV", 4);
			put("I", 1);
		}};
		
		return romanNumerals;
		
	}
	
	private static String getAmount(LinkedHashMap<String, Integer> romanNumerals, int num){
		String rnString = "";
		int numOfChars = 0;
		
		for(Map.Entry<String, Integer> entry : romanNumerals.entrySet()) {
			numOfChars = num / entry.getValue();
			num = num % entry.getValue();
			for (int i = 0; i < numOfChars; i++) {
				rnString += entry.getKey();
			}			
		}
		
		return rnString;
	}
	
    public static String getChoiceString(String prompt, String choice1, String choice2) {
    	String s = "";
    	boolean isValid = false;
    	do {    	
	        System.out.print(prompt);
	        s = userInput.next();
	        userInput.nextLine();
	        if(s.equalsIgnoreCase(choice1) || s.equalsIgnoreCase(choice2)) {
	        	isValid = true;
	        } else {
	        	System.out.println("!Error! Invalid Entry.");
	        }
	        
    	} while(!isValid); 
    	return s;
    }
    
    public static int getInt(String prompt) {
        boolean isValid = false;
        int i = 0;
        while (isValid == false) {
            System.out.print(prompt);
            if (userInput.hasNextInt()) {
                i = userInput.nextInt();
                isValid = true;
            } else {
                System.out.println("!Error! Invalid integer value.");
            }
            userInput.nextLine();
        }
        return i;
    }
	
}
