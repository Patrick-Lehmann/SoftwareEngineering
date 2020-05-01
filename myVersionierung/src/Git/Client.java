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
		double userValue = 0.0;
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
		
<<<<<<< HEAD
		repeat = true;
		
		while(repeat) {
			//Frage Benutzer nach dem Betrag
			System.out.println("Welchen Betrag m�chten Sie umrechnen?");
			
			try  {
				userValue = Benutzereingabe.nextDouble();
				System.out.println("Eigegebener Betrag: "+userValue);
				repeat = false;
			}
			catch(InputMismatchException e) {
				String errStr = Benutzereingabe.next();
				System.out.println("'"+errStr+"' ist keine Zahl!");
			}
			
			System.out.println("");
=======
		//Frage Benutzer nach dem Betrag
		System.out.println("Welchen Betrag m�chten Sie umrechnen?");
		userValue = Benutzereingabe.nextDouble();
		System.out.println("");
		
		//Suche in instanziierten W�hrungen nach eingegebener W�hrung und rechne sie um
		if(Euro.validate(userCurrency)) {
			System.out.println("Eigegebener Betrag ("+Euro.getCurrency()+"): "+userValue);
			System.out.println("Eigegebener Betrag (Dollar): "+Euro.toDollar(userValue));
			System.out.println("Eigegebener Betrag (Pfund): "+Euro.toPfund(userValue));
		}
		else if(Dollar.validate(userCurrency)) {
			System.out.println("Eigegebener Betrag ("+Dollar.getCurrency()+"): "+userValue);
			System.out.println("Eigegebener Betrag (Euro): "+Dollar.toEuro(userValue));
			System.out.println("Eigegebener Betrag (Pfund): "+Dollar.toPfund(userValue));
		}
		else if(Pfund.validate(userCurrency)) {
			System.out.println("Eigegebener Betrag ("+Pfund.getCurrency()+"): "+userValue);
			System.out.println("Eigegebener Betrag (Euro): "+Pfund.toEuro(userValue));
			System.out.println("Eigegebener Betrag (Dollar): "+Pfund.toDollar(userValue));
		}
		else {
			System.out.println("Eingegebene W�hrung nicht gefunden.");
>>>>>>> calculation
		}
		
		
		Benutzereingabe.close();
		
	}

}
