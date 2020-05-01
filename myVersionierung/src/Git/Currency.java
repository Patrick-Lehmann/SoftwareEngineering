package Git;

/**
 * @author Patrick-Lehmann
 *
 */
public class Currency {
	
	/**
	 * Konstanter Name für Währung Euro
	 */
	public static final String euro = "Euro";
	
	/**
	 * Konstanter Name für Währung Dollar
	 */
	public static final String dollar = "Dollar";
	
	/**
	 * Konstanter Name für Währung Pfund
	 */
	public static final String pfund = "Pfund";
	
	/**
	 * Währungssymbol Euro
	 */
	public static final char euroSymbol = '€';
	
	/**
	 * Währungssymbol Dollar
	 */
	public static final char dollarSymbol = '$';
	
	/**
	 * Währungssymbol Pfund
	 */
	public static final char pfundSymbol = '£';
	
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
	 * Initialisiere Variable für Name der ausgewählten Währung
	 */
	private String currency = null;
	
	/**
	 * Initialisiere Variable für Symbol ausgewählten Währung
	 */
	private String currencySymbol;
	
	/**
	 * Konstruktor konfiguriert die Klasse mit der eingegebenen Währung
	 * @param curr
	 */
	public Currency(String curr) {
		switch(curr) {
		case euro: 
			System.out.println("Währung "+euro+" instanziiert...");
			this.currency = euro;
			this.currencySymbol = String.valueOf(euroSymbol);
			break;
		case dollar: 
			System.out.println("Währung "+dollar+" instanziiert...");
			this.currency = dollar;
			this.currencySymbol = String.valueOf(dollarSymbol);
			break;
		case pfund: 
			System.out.println("Währung "+pfund+" instanziiert...");
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
	 * @return Bestätigung (true), wenn die Eingabe der aktuellen Währung entspricht.
	 */
	public boolean validate(String input) {
		if(this.currency.equals(input) || this.currencySymbol.equals(input)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return Name der instanziierte Währung
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * 
	 * @return Währungssymbol der instanziierten Währung
	 */
	public String getCurrencySymbol() {
		return this.currencySymbol;
	}
	
	/**
	 * Rechnet die aktuelle Währung in Euro um
	 * @param value 
	 * @return Währung in Euro
	 */
	public double toEuro(double value) {
		//Initialisiere Ergebnisvariable
		double result;
		
		//Frage aktuelle Währung ab und führe entsprechende Umrechnung mit Konstanten aus. 
		//Für 2 Nachkommastellen wird der Wert vor dem Runden mit 100 multipliziert und anschließend wieder durch 100 geteilt
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
	 * Rechnet die aktuelle Währung in Dollar um
	 * @param value 
	 * @return Währung in Dollar
	 */
	public double toDollar(double value) {
		//Initialisiere Ergebnisvariable
		double result;
		
		//Frage aktuelle Währung ab und führe entsprechende Umrechnung mit Konstanten aus. 
		//Für 2 Nachkommastellen wird der Wert vor dem Runden mit 100 multipliziert und anschließend wieder durch 100 geteilt
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
	 * Rechnet die aktuelle Währung in Pfund um
	 * @param value 
	 * @return Währung in Pfund
	 */
	public double toPfund(double value) {
		//Initialisiere Ergebnisvariable
		double result;
		
		//Frage aktuelle Währung ab und führe entsprechende Umrechnung mit Konstanten aus. 
		//Für 2 Nachkommastellen wird der Wert vor dem Runden mit 100 multipliziert und anschließend wieder durch 100 geteilt
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
	 * Multipliziert zwei Fließkommazahlen und gibt eine Zahl mit zwei signifikanten Dezimalstellen zurück
	 * @param value
	 * @param exchangeRate
	 * @return Umgerechnete Fließkommazahl mit zwei Dezimalstellen
	 */
	public static double convert(double value, double exchangeRate) {
		return (double) Math.round(value*exchangeRate*100)/100;
	}
	
}
