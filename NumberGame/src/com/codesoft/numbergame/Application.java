package com.codesoft.numbergame;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
	System.out.println(	);
	String message="Great You Chose right Number";
	Scanner sc= new Scanner(System.in);
	System.out.println("please enter min number");
	int inputminnumber=sc.nextInt();
	System.out.println("please enter max number");
	int inputmanxnumber=sc.nextInt();
	int Generatednumber= NumberOperation.generateNumber(inputminnumber, inputmanxnumber);
	System.out.println("Now enter Your Choosen number");
	int ChoosenNumber=sc.nextInt();
	if(ChoosenNumber==Generatednumber) {
		System.out.println("congreatulation you guessed in first attempt");
	return;
	}
	System.out.println("NOT matched please enter Number");
	while(ChoosenNumber!=Generatednumber) {
	
		NumberOperation.CheckNumber(ChoosenNumber, Generatednumber);

	
	}
}
	}
