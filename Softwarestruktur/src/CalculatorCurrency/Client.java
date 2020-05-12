package CalculatorCurrency;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		boolean repeat = true;
		String action = null;
		String targetCurrency = null;
		double amount = 0;
		double amountConverted = 0;
		
		//Initiiere Scanner
		Scanner benutzereingabe = new Scanner(System.in);
		
		/**
		 * Instanziiere W�hrung Dollar
		 * {@link} https://www.finanzen.net/waehrungsrechner/euro_us-dollar (01.05.2020)
		 */
		Currencies Dollar = new Currencies("Dollar",1.0946);

		/**
		 * Instanziiere W�hrung Pfund
		 * {@link} https://www.finanzen.net/waehrungsrechner/euro_britische-pfund (01.05.2020)
		 */
		Currencies Pfund = new Currencies("Pfund",0.8714);
		
		while(repeat) {
			//Frage Benutzer nach Aktion
			System.out.println("Welche Aktion m�chten Sie durchf�hren?");
			action = benutzereingabe.next();
			
			if(action.equals("neue W�hrung")) {
				//Benutzer gibt neue W�hrung ein
				repeat = false;
				
			}
			else if(action.equals("Beenden")) {
				//Benutzer m�chte das Programm beenden
				repeat = false;
				System.exit(1);
			}
			else {
				//Benutzer wird eine Zielw�hrung umrechnen
				while(repeat) {
					System.out.println("In welche W�hrung m�chten Sie umrechnen?");
					targetCurrency = benutzereingabe.next();
					
					if(targetCurrency.equals("Dollar") || targetCurrency.equals("Pfund")) {
						while(repeat) {
							System.out.println("Welchen Betrag m�chten Sie umrechnen?");
							try {
								amount = benutzereingabe.nextDouble();
								switch(targetCurrency) {
								case "Dollar": 
									//Wert berechnen
									amountConverted = Dollar.convert(amount);
									//Wert ausgeben
									System.out.println("Das sind "+amountConverted+" $");
									repeat = false;
									break;
								case "Pfund": 
									//Wert berechnen
									amountConverted = Pfund.convert(amount); 
									//Wert ausgeben
									System.out.println("Das sind "+amountConverted+" �");
									repeat = false;
									break;
								}
							}
							catch(InputMismatchException e) {
								System.err.println(e);
							}
						}
					}
				}
				repeat = true;
			}
		}
		
		benutzereingabe.close();

	}


}
