package CalculatorCurrency;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		boolean repeat = true;
		String aktion = null;
		
		Scanner benutzereingabe = new Scanner(System.in);
		Currencies currency = new Currencies();
		
		while(repeat) {
			//Frage Benutzer nach Aktion
			System.out.println("Welche Aktion möchten Sie durchführen?");
			aktion = benutzereingabe.next();
			
			if(aktion.equals("neue Währung")) {
				//Benutzer gibt neue Währung ein
				repeat = false;
				
			}
			else if(aktion.equals("Beenden")) {
				//Benutzer möchte das Programm beenden
				repeat = false;
				
			}
			else {
				//Benutzer wird eine Zielwährung umrechnen
				repeat = false;
				
			}
		}
		
		benutzereingabe.close();

	}


}
