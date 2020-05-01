/**
 * 
 */
package Git;

import java.util.InputMismatchException;
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
		double userValue;
		double userValueCurrency;
		boolean repeat = true;
		String run;
		
		while(repeat) {
			//Frage Benutzer nach der W�hrung
			System.out.println("Welche W�hrung m�chten Sie umrechnen?");
			userCurrency = Benutzereingabe.next();
			
			//Suche in instanziierten W�hrungen nach eingegebener W�hrung und gebe Sie aus
			if(Euro.validate(userCurrency)) {
				System.out.println("Eingegebene W�hrung: "+Euro.getCurrency());
				repeat = false;
			}
			else if(Dollar.validate(userCurrency)) {
				System.out.println("Eingegebene W�hrung: "+Dollar.getCurrency());
				repeat = false;
			}
			else if(Pfund.validate(userCurrency)) {
				System.out.println("Eingegebene W�hrung: "+Pfund.getCurrency());
				repeat = false;
			}
			else {
				System.out.println("Eingegebene W�hrung nicht gefunden.");
				System.out.println("M�chten Sie das Programm beenden? (Y/N)");
				run = Benutzereingabe.next();
				if(run.equals("Y") || run.equals("y")) {
					repeat = false;
					System.out.println("Programm wurde beendet.");
					System.exit(1);
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
				if(Euro.validate(userCurrency)) {
					System.out.println("Eigegebener Betrag ("+Euro.getCurrency()+"): "+userValueCurrency+Currency.euroSymbol);
					System.out.println("Eigegebener Betrag (Dollar): "+Euro.toDollar(userValueCurrency)+Currency.dollarSymbol);
					System.out.println("Eigegebener Betrag (Pfund): "+Euro.toPfund(userValueCurrency)+Currency.pfundSymbol);
				}
				else if(Dollar.validate(userCurrency)) {
					System.out.println("Eigegebener Betrag ("+Dollar.getCurrency()+"): "+userValueCurrency+Currency.euroSymbol);
					System.out.println("Eigegebener Betrag (Euro): "+Dollar.toEuro(userValueCurrency)+Currency.dollarSymbol);
					System.out.println("Eigegebener Betrag (Pfund): "+Dollar.toPfund(userValueCurrency)+Currency.pfundSymbol);
				}
				else if(Pfund.validate(userCurrency)) {
					System.out.println("Eigegebener Betrag ("+Pfund.getCurrency()+"): "+userValueCurrency+Currency.euroSymbol);
					System.out.println("Eigegebener Betrag (Euro): "+Pfund.toEuro(userValueCurrency)+Currency.dollarSymbol);
					System.out.println("Eigegebener Betrag (Dollar): "+Pfund.toDollar(userValueCurrency)+Currency.pfundSymbol);
				}
				else {
					System.out.println("Eingegebene W�hrung nicht gefunden.");
				}
			}
			catch(InputMismatchException e) {
				String errStr = Benutzereingabe.next();
				System.out.println("'"+errStr+"' ist keine Zahl!");
			}
			
			System.out.println("");
		}
		
		Benutzereingabe.close();
		
	}

}
