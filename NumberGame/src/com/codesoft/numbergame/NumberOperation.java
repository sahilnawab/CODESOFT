package com.codesoft.numbergame;

import java.security.SecureRandom;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class NumberOperation {

	
	public static int generateNumber(int min,int max) {
		
		SecureRandom random= new SecureRandom();
		return random.nextInt(min, max);
	}
	
	public static void CheckNumber(int ChoiceNumber,int generatednumber) {
		Scanner sc1= new Scanner(System.in);
		 ChoiceNumber=sc1.nextInt() ;
		 if(ChoiceNumber==generatednumber) {
				System.out.println("Great You Chose right Number "+ generatednumber);
			
			}
			else if(ChoiceNumber>generatednumber) {
				System.out.println("TOO HIGH");
				System.out.println(" NOT matched please enter Number");
				 
			}
			else {
				System.out.println("TOO LOW");
				System.out.println(" NOT matched please enter Number");
			}
	}
}
