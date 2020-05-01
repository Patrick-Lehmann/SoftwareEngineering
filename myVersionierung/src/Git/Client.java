/**
 * 
 */
package Git;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Patrick-Lehmann
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Willkommenstext
		System.out.println("Willkommen im W�hrungsrechner!");
		System.out.println("");
		
		//Instanziiere W�hrungen
		Currency Euro = new Currency(Currency.euro);
		Currency Dollar = new Currency(Currency.dollar);
		Currency Pfund = new Currency(Currency.pfund);
		
		System.out.println("");
		
		//interaktive Benutzereingabe
		Scanner Benutzereingabe = new Scanner(System.in);
		String userCurrency = null;
		double userValue = 0;
		double userValueCurrency = 0;
		double exchangeRateEuro = 0;
		double exchangeRateDollar = 0;
		double exchangeRatePfund = 0;
		boolean repeat = true;
		boolean supported = false;
		String run;
		
		while(repeat) {
			//Frage Benutzer nach der W�hrung
			System.out.println("Welche W�hrung m�chten Sie umrechnen?");
			userCurrency = Benutzereingabe.next();
			
			//Suche in instanziierten W�hrungen nach eingegebener W�hrung und gebe Sie aus
			if(Euro.validate(userCurrency)) {
				System.out.println("Eingegebene W�hrung: "+Euro.getCurrency());
				repeat = false;
				supported = true;
			}
			else if(Dollar.validate(userCurrency)) {
				System.out.println("Eingegebene W�hrung: "+Dollar.getCurrency());
				repeat = false;
				supported = true;
			}
			else if(Pfund.validate(userCurrency)) {
				System.out.println("Eingegebene W�hrung: "+Pfund.getCurrency());
				repeat = false;
				supported = true;
			}
			else {
				System.out.println("Eingegebene W�hrung nicht gefunden.");
				
				//W�hrung interaktiv hinzuf�gen
				System.out.println("M�chten Sie diese W�hrung hinzuf�gen? (Y/N)");
				run = Benutzereingabe.next();
				if(run.equals("Y") || run.equals("y")) {
				    System.out.println("W�hrung wurde hinzugef�gt.");
				    System.out.println("");
				    
					while(repeat) {
					    System.out.println("Bitte geben Sie den aktuellen Wechselkurs zu Euro an:");
						try {
							exchangeRateEuro = Benutzereingabe.nextDouble();
							repeat = false;
						}
						catch(InputMismatchException e) {
							String errStr = Benutzereingabe.next();
							if(String.valueOf(errStr.charAt(1)).equals(".")) {
								System.out.println("'"+errStr+"' wird aufgrund der eingestellten Sprache nicht als Flie�kommazahl erkannt!");
							}
							else {
								System.out.println("'"+errStr+"' ist keine Zahl!");
							}
						}
					}
					
					repeat = true;
					
					while(repeat) {
					    System.out.println("Bitte geben Sie den aktuellen Wechselkurs zu Dollar an:");
						try {
							exchangeRateDollar = Benutzereingabe.nextDouble();
							repeat = false;
						}
						catch(InputMismatchException e) {
							String errStr = Benutzereingabe.next();
							if(String.valueOf(errStr.charAt(1)).equals(".")) {
								System.out.println("'"+errStr+"' wird aufgrund der eingestellten Sprache nicht als Flie�kommazahl erkannt!");
							}
							else {
								System.out.println("'"+errStr+"' ist keine Zahl!");
							}
						}
					}
					
					repeat = true;
					
					while(repeat) {
					    System.out.println("Bitte geben Sie den aktuellen Wechselkurs zu Pfund an:");
						try {
							exchangeRatePfund = Benutzereingabe.nextDouble();
							repeat = false;
						}
						catch(InputMismatchException e) {
							String errStr = Benutzereingabe.next();
							if(String.valueOf(errStr.charAt(1)).equals(".")) {
								System.out.println("'"+errStr+"' wird aufgrund der eingestellten Sprache nicht als Flie�kommazahl erkannt!");
							}
							else {
								System.out.println("'"+errStr+"' ist keine Zahl!");
							}
						}
					}
				
				}
				else {
					System.out.println("M�chten Sie das Programm beenden? (Y/N)");
					run = Benutzereingabe.next();
					if(run.equals("Y") || run.equals("y")) {
						repeat = false;
						System.out.println("Programm wurde beendet.");
						System.exit(1);
					}
				}
			}
			System.out.println("");
		}
		
		repeat = true;
		
		while(repeat) {
			//Frage Benutzer nach dem Betrag
			System.out.println("Welchen Betrag m�chten Sie umrechnen?");
			
			try  {
				userValue = Benutzereingabe.nextDouble();
				userValueCurrency = (double) Math.round(userValue*100)/100;
				repeat = false;
				
				//Suche in instanziierten W�hrungen nach eingegebener W�hrung und rechne sie um
				if(supported) {
					if(Euro.validate(userCurrency)) {
						System.out.println("Eingegebener Betrag ("+Euro.getCurrency()+"): "+userValueCurrency+Currency.euroSymbol);
						System.out.println("Eingegebener Betrag (Dollar): "+Euro.toDollar(userValueCurrency)+Currency.dollarSymbol);
						System.out.println("Eingegebener Betrag (Pfund): "+Euro.toPfund(userValueCurrency)+Currency.pfundSymbol);
					}
					else if(Dollar.validate(userCurrency)) {
						System.out.println("Eingegebener Betrag ("+Dollar.getCurrency()+"): "+userValueCurrency+Currency.dollarSymbol);
						System.out.println("Eingegebener Betrag (Euro): "+Dollar.toEuro(userValueCurrency)+Currency.euroSymbol);
						System.out.println("Eingegebener Betrag (Pfund): "+Dollar.toPfund(userValueCurrency)+Currency.pfundSymbol);
					}
					else if(Pfund.validate(userCurrency)) {
						System.out.println("Eingegebener Betrag ("+Pfund.getCurrency()+"): "+userValueCurrency+Currency.pfundSymbol);
						System.out.println("Eingegebener Betrag (Euro): "+Pfund.toEuro(userValueCurrency)+Currency.euroSymbol);
						System.out.println("Eingegebener Betrag (Dollar): "+Pfund.toDollar(userValueCurrency)+Currency.dollarSymbol);
					}
					else {
						System.out.println("Eingegebene W�hrung nicht gefunden.");
					}
				}
				else {
					System.out.println("Eingegebener Betrag ("+userCurrency+"): "+userValueCurrency);
					System.out.println("Eingegebener Betrag (Euro): "+Currency.convert(userValueCurrency,exchangeRateEuro)+Currency.euroSymbol);
					System.out.println("Eingegebener Betrag (Dollar): "+Currency.convert(userValueCurrency,exchangeRateDollar)+Currency.dollarSymbol);
					System.out.println("Eingegebener Betrag (Pfund): "+Currency.convert(userValueCurrency,exchangeRatePfund)+Currency.pfundSymbol);
				}
			}
			catch(InputMismatchException e) {
				String errStr = Benutzereingabe.next();
				if(String.valueOf(errStr.charAt(1)).equals(".")) {
					System.out.println("'"+errStr+"' wird aufgrund der eingestellten Sprache nicht als Flie�kommazahl erkannt!");
				}
				else {
					System.out.println("'"+errStr+"' ist keine Zahl!");
				}
			}
			
			System.out.println("");
		}
		
		Benutzereingabe.close();
		
	}

}
