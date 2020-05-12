package CalculatorCurrency;

public class Currencies {
	
	/**
	 * Name
	 */
	private String Name;
	
	/**
	 * Wechselkurs
	 */
	private double ExchangeRate;
	
	/**
	 * W�hrungsk�rzel
	 */
	private char Code;
	
	/**
	 * Konstruktor
	 * @param name
	 * @param exchangeRate
	 */
	public Currencies(String name,char code, double exchangeRate) {
		Name = name;
		Code = code;
		ExchangeRate = exchangeRate;
	}
	
	/**
	 * Multipliziert zwei Flie�kommazahlen und gibt eine Zahl mit zwei signifikanten Dezimalstellen zur�ck
	 * @param value
	 * @param exchangeRate
	 * @return Umgerechnete Flie�kommazahl mit zwei Dezimalstellen
	 */
	public double convert(double amount) {
		return (double) Math.round(amount*ExchangeRate*100)/100;
	}

	/**
	 * 
	 * @return
	 */
	public char getCode() {
		return Code;
	}
	
}
