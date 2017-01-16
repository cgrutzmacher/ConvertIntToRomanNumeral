package roman_numeral;

import java.util.Scanner;

public class Validator {
	
	
	public static String getRequiredString(Scanner sc, String prompt) {
		boolean isValid = false;
		String s = "";
		
		while (!isValid) {
	        System.out.print(prompt);
	        s = sc.nextLine();
	        if(!s.isEmpty()) {
	        	isValid = true;
	        } else {
	        	System.out.println("!ERROR! This field is required.");
	        	continue;
	        }        
		}
		return s;
	}
	
    public static String getChoiceString(Scanner sc, String prompt, String choice1, String choice2) {
    	String s = "";
    	boolean isValid = false;
    	do {    	
	        System.out.print(prompt);
	        s = sc.next();
	        sc.nextLine();
	        if(s.equalsIgnoreCase(choice1) || s.equalsIgnoreCase(choice2)) {
	        	isValid = true;
	        } else {
	        	System.out.println("Error. Invalid Entry.");
	        }
	        
    	} while(!isValid); 
    	return s;
    }
    
    public static String getChoiceString(Scanner sc, String prompt, String[] choices) {
    	String s = "";
    	boolean isValid = false;
    	
    	while(!isValid) {
    		System.out.print(prompt);
    		s = sc.next();
    		sc.nextLine();
    		for (int i = 0; i < choices.length; i++) {
				if (choices[i].equalsIgnoreCase(s)) {
					isValid = true;
					break;
				}
				if (i == choices.length-1) {
					System.out.println("Invalid entry\n");
				}
			}
    	}
    	return s;    	
    }
    
    public static String getEmail(Scanner sc, String prompt) {
    	boolean isValid = false;
    	String email = "";
    	
    	while(!isValid) {
    		System.out.println(prompt);
    		email = sc.nextLine();
    		if (email.matches("^[a-zA-Z\\d_\\.-]*@{1}[a-zA-Z]*\\.{1}[a-zA-Z]{2,}")) {
    			isValid = true;
    		} else {
    			System.out.println("not a valid email address.");
    			continue;
    		}
    	}    	
    	return email;
    }
	
	public static String getSSN(Scanner sc, String prompt) {
		boolean isValid = false;
		String ssn = "";
		
		while(!isValid) {
			System.out.print(prompt);
			ssn = sc.nextLine();
			if (ssn.matches("\\d{3}[\\s|-]*\\d{2}[\\s|-]*\\d{4}|\\d{9}")){
				ssn = ssn.replaceAll("\\s+", " ");
				isValid = true;
			} else {
				System.out.println("not a valid SSN");
				continue;
			}			
		}		
		return ssn;
	}
	
    public static String getString(Scanner sc, String prompt) {
        System.out.print(prompt);
        String s = sc.next();
        sc.nextLine();
        return s;
    }

    public static String getLine(Scanner sc, String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine();
        return s;
    }

    public static int getInt(Scanner sc, String prompt) {
        boolean isValid = false;
        int i = 0;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();
        }
        return i;
    }

    public static int getInt(Scanner sc, String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = getInt(sc, prompt);
            if (i <= min) {
                System.out.println( "Error! Number must be greater than " + min);
            } else if (i >= max) {
                System.out.println( "Error! Number must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return i;
    }

    public static double getDouble(Scanner sc, String prompt) {
        boolean isValid = false;
        double d = 0;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();
        }
        return d;
    }

    public static double getDouble(Scanner sc, String prompt, double min, double max) {
        double d = 0;
        boolean isValid = false;
        while (isValid == false) {
            d = getDouble(sc, prompt);
            if (d <= min) {
                System.out.println( "Error! Number must be greater than " + min);
            } else if (d >= max) {
                System.out.println( "Error! Number must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return d;
    }
}