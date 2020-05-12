package CalculatorCurrency;

import java.util.ArrayList;

public class Currencies {
	
	/**
	 * Name der W�hrung
	 */
	private String Name;
	
	/**
	 * Wechselkurs der W�hrung
	 */
	private double ExchangeRate;
	
	/**
	 * Konstruktor
	 * @param name
	 * @param exchangeRate
	 */
	public Currencies(String name,double exchangeRate) {
		this.Name = name;
		this.ExchangeRate = exchangeRate;
	}
	
	/**
	 * Multipliziert zwei Flie�kommazahlen und gibt eine Zahl mit zwei signifikanten Dezimalstellen zur�ck
	 * @param value
	 * @param exchangeRate
	 * @return Umgerechnete Flie�kommazahl mit zwei Dezimalstellen
	 */
	public double convert(double amount) {
		return (double) Math.round(amount*this.ExchangeRate*100)/100;
	}
	
	
}
