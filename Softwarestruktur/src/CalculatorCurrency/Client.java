package CalculatorCurrency;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		boolean repeat = true;
		String targetCurrency;
		double amount;
		double amountConverted;
		String currencyName = null;
		char currencyCode;
		double exchangeRate;
		
		Scanner benutzereingabe = new Scanner(System.in);
		
		Currencies Dollar = new Currencies("Dollar",'$',1.0946);
		Currencies Pfund = new Currencies("Pfund",'�',0.8714);
		Currencies myCurrency = null;
		
		while(repeat) {
			System.out.println("Welche Aktion m�chten Sie durchf�hren?");
			String token = benutzereingabe.nextLine();				
			
			if(token.equals("Beenden")) {
				repeat = false;
				System.exit(1);
			}
			else if(token.equals("neue W�hrung")) {
				while(repeat) {
					System.out.println("Wie hei�t die W�hrung?");
					currencyName = benutzereingabe.next();
					System.out.println("Welches W�hrungsk�rzel hat diese W�hrung?");
					currencyCode = benutzereingabe.next().charAt(0);
					System.out.println("Welchen Umrechnungsfaktor hat diese W�hrung?");
					try {
						exchangeRate = benutzereingabe.nextDouble();
						myCurrency = new Currencies(currencyName,currencyCode,exchangeRate);
						repeat = false;
					}
					catch(InputMismatchException e) {
						System.err.println(e);
					}
				}
			}
			else {
				while(repeat) {
					System.out.println("In welche W�hrung soll umgerechnet werden?");
					targetCurrency = benutzereingabe.next();
					
					if(targetCurrency.equals("Dollar") || targetCurrency.equals("Pfund") || targetCurrency.equals(currencyName)) {
						while(repeat) {
							System.out.println("Welcher Betrag soll umgerechnet werden?");
							try {
								amount = benutzereingabe.nextDouble();
								if(targetCurrency.equals("Dollar")) {
									amountConverted = Dollar.convert(amount);
									System.out.println(amount +" � sind "+amountConverted+" "+Dollar.getCode());
									repeat = false;
								}
								else if(targetCurrency.equals("Pfund")) {
									amountConverted = Pfund.convert(amount);
									System.out.println(amount +" � sind "+amountConverted+" "+Pfund.getCode());
									repeat = false;
								}
								else if(targetCurrency.equals(currencyName)) {
									amountConverted = myCurrency.convert(amount);
									System.out.println(amount +" � sind "+amountConverted+" "+myCurrency.getCode());
									repeat = false;
								}
							}
							catch(InputMismatchException e) {
								System.err.println(e);
							}
						}
					}
				}
			}
			repeat = true;
			benutzereingabe.nextLine(); //prevent jump
			System.out.println("");
		}
		
		benutzereingabe.close();
		
	}

}
