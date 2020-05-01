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
		System.out.println("Willkommen im Währungsrechner!");
		System.out.println("");
		
		//Instanziiere Währungen
		Currency Euro = new Currency(Currency.euro);
		Currency Dollar = new Currency(Currency.dollar);
		Currency Pfund = new Currency(Currency.pfund);
		
		System.out.println("");
		
		//interaktive Benutzereingabe
		Scanner Benutzereingabe = new Scanner(System.in);
		String userCurrency = null;
		double userValue = 0.0;
		
		//Frage Benutzer nach der Währung
		System.out.println("Welche Währung möchten Sie umrechnen?");
		userCurrency = Benutzereingabe.next();
		System.out.println("");
		
		//Suche in instanziierten Währungen nach eingegebener Währung und gebe Sie aus
		if(Euro.validate(userCurrency)) {
			System.out.println("Eingegebene Währung: "+Euro.getCurrency());
		}
		else if(Dollar.validate(userCurrency)) {
			System.out.println("Eingegebene Währung: "+Dollar.getCurrency());
		}
		else if(Pfund.validate(userCurrency)) {
			System.out.println("Eingegebene Währung: "+Pfund.getCurrency());
		}
		else {
			System.out.println("Eingegebene Währung nicht gefunden.");
		}

		System.out.println("");
		
		//Frage Benutzer nach dem Betrag
		System.out.println("Welchen Betrag möchten Sie umrechnen?");
		userValue = Benutzereingabe.nextDouble();
		System.out.println("");
		
		//Suche in instanziierten Währungen nach eingegebener Währung und rechne sie um
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
			System.out.println("Eingegebene Währung nicht gefunden.");
		}
		
		System.out.println("");
		
		Benutzereingabe.close();
		
	}

}
