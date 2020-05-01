package Git;

/**
 * @author Patrick-Lehmann
 *
 */
public class Currency {
	
	/**
	 * Konstanter Name f�r W�hrung Euro
	 */
	public static final String euro = "Euro";
	
	/**
	 * Konstanter Name f�r W�hrung Dollar
	 */
	public static final String dollar = "Dollar";
	
	/**
	 * Konstanter Name f�r W�hrung Pfund
	 */
	public static final String pfund = "Pfund";
	
	/**
	 * W�hrungssymbol Euro
	 */
	public static final char euroSymbol = '�';
	
	/**
	 * W�hrungssymbol Dollar
	 */
	public static final char dollarSymbol = '$';
	
	/**
	 * W�hrungssymbol Pfund
	 */
	public static final char pfundSymbol = '�';
	
	/**
	 * Konstante zur Umrechnung von Euro in Dollar. 
	 * {@link} https://www.finanzen.net/waehrungsrechner/euro_us-dollar (01.05.2020)
	 */
	public static final double euro2dollar = 1.0946;
	
	/**
	 * Konstante zur Umrechnung von Euro in Pfund. 
	 * {@link} https://www.finanzen.net/waehrungsrechner/euro_britische-pfund (01.05.2020)
	 */
	public static final double euro2pfund = 0.8714;
	
	/**
	 * Konstante zur Umrechnung von Dollar in Euro. 
	 * {@link} https://www.finanzen.net/waehrungsrechner/us-dollar_euro (01.05.2020)
	 */
	public static final double dollar2euro = 0.9137;
	
	/**
	 * Konstante zur Umrechnung von Dollar in Pfund. 
	 * {@link} https://www.finanzen.net/waehrungsrechner/us-dollar_britische-pfund (01.05.2020)
	 */
	public static final double dollar2pfund = 0.7965;
	
	/**
	 * Konstante zur Umrechnung von Pfund in Euro. 
	 * {@link} https://www.finanzen.net/waehrungsrechner/britische-pfund_euro (01.05.2020)
	 */
	public static final double pfund2euro = 1.1495;
	
	/**
	 * Konstante zur Umrechnung von Pfund in Dollar. 
	 * {@link} https://www.finanzen.net/waehrungsrechner/britische-pfund_us-dollar (01.05.2020)
	 */
	public static final double pfund2dollar = 1.2582;
	
	/**
	 * Initialisiere Variable f�r Name der ausgew�hlten W�hrung
	 */
	private String currency = null;
	
	/**
	 * Initialisiere Variable f�r Symbol ausgew�hlten W�hrung
	 */
	private String currencySymbol;
	
	/**
	 * Konstruktor konfiguriert die Klasse mit der eingegebenen W�hrung
	 * @param curr
	 */
	public Currency(String curr) {
		switch(curr) {
		case euro: 
			System.out.println("W�hrung "+euro+" instanziiert...");
			this.currency = euro;
			this.currencySymbol = String.valueOf(euroSymbol);
			break;
		case dollar: 
			System.out.println("W�hrung "+dollar+" instanziiert...");
			this.currency = dollar;
			this.currencySymbol = String.valueOf(dollarSymbol);
			break;
		case pfund: 
			System.out.println("W�hrung "+pfund+" instanziiert...");
			this.currency = pfund;
			this.currencySymbol = String.valueOf(pfundSymbol);
			break;
		default: 
			break;
		}
	}
	
	/**
	 * 
	 * @param input
	 * @return Best�tigung (true), wenn die Eingabe der aktuellen W�hrung entspricht.
	 */
	public boolean validate(String input) {
		if(this.currency.equals(input) || this.currencySymbol.equals(input)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return Name der instanziierte W�hrung
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * 
	 * @return W�hrungssymbol der instanziierten W�hrung
	 */
	public String getCurrencySymbol() {
		return this.currencySymbol;
	}
	
	/**
	 * Rechnet die aktuelle W�hrung in Euro um
	 * @param value 
	 * @return W�hrung in Euro
	 */
	public double toEuro(double value) {
		//Initialisiere Ergebnisvariable
		double result;
		
		//Frage aktuelle W�hrung ab und f�hre entsprechende Umrechnung mit Konstanten aus. 
		//F�r 2 Nachkommastellen wird der Wert vor dem Runden mit 100 multipliziert und anschlie�end wieder durch 100 geteilt
		switch(this.currency) {
		case euro:
			result = value;
			break;
		case dollar: 
			result = (double) Math.round(value*dollar2euro*100)/100;;
			break;
		case pfund:
			result = (double) Math.round(value*pfund2euro*100)/100;
			break;
		default:
			result = 0;
			break;
		}
		return result;
	}
	
	/**
	 * Rechnet die aktuelle W�hrung in Dollar um
	 * @param value 
	 * @return W�hrung in Dollar
	 */
	public double toDollar(double value) {
		//Initialisiere Ergebnisvariable
		double result;
		
		//Frage aktuelle W�hrung ab und f�hre entsprechende Umrechnung mit Konstanten aus. 
		//F�r 2 Nachkommastellen wird der Wert vor dem Runden mit 100 multipliziert und anschlie�end wieder durch 100 geteilt
		switch(this.currency) {
		case euro:
			result = (double) Math.round(value*euro2dollar*100)/100;
			break;
		case dollar: 
			result = value;
			break;
		case pfund:
			result = (double) Math.round(value*pfund2dollar*100)/100;
			break;
		default:
			result = 0;
			break;
		}
		return result;
	}
	
	/**
	 * Rechnet die aktuelle W�hrung in Pfund um
	 * @param value 
	 * @return W�hrung in Pfund
	 */
	public double toPfund(double value) {
		//Initialisiere Ergebnisvariable
		double result;
		
		//Frage aktuelle W�hrung ab und f�hre entsprechende Umrechnung mit Konstanten aus. 
		//F�r 2 Nachkommastellen wird der Wert vor dem Runden mit 100 multipliziert und anschlie�end wieder durch 100 geteilt
		switch(this.currency) {
		case euro:
			result = (double) Math.round(value*euro2pfund*100)/100;
			break;
		case dollar: 
			result = (double) Math.round(value*dollar2pfund*100)/100;
			break;
		case pfund:
			result = value;
			break;
		default:
			result = 0;
			break;
		}
		return result;
	}
	
	/**
	 * Multipliziert zwei Flie�kommazahlen und gibt eine Zahl mit zwei signifikanten Dezimalstellen zur�ck
	 * @param value
	 * @param exchangeRate
	 * @return Umgerechnete Flie�kommazahl mit zwei Dezimalstellen
	 */
	public static double convert(double value, double exchangeRate) {
		return (double) Math.round(value*exchangeRate*100)/100;
	}
	
}
