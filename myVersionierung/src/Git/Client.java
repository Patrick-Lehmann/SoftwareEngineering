/**
 * 
 */
package Git;

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
		
		//Frage Benutzer nach der W�hrung
		System.out.println("Welche W�hrung m�chten Sie umrechnen?");
		userCurrency = Benutzereingabe.next();
		System.out.println("");
		System.out.println("Eigegebene W�hrung: "+userCurrency);
		
		//Frage Benutzer nach dem Betrag
		System.out.println("Welchen Betrag m�chten Sie umrechnen?");
		userValue = Benutzereingabe.nextDouble();
		System.out.println("");
		System.out.println("Eigegebener Betrag: "+userValue);
		
	}

}
