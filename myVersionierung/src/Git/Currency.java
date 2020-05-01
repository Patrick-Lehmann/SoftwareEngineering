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
	 * Konstante zur Umrechnung von Euro in Dollar. 
	 * {@link} https://www.finanzen.net/waehrungsrechner/euro_us-dollar
	 */
	public static final double euro2dollar = 1.0946;
	
	/**
	 * Konstante zur Umrechnung von Euro in Dollar. 
	 * {@link} https://www.finanzen.net/waehrungsrechner/us-dollar_euro
	 */
	public static final double dollar2euro = 0.9137;
	
	/**
	 * Konstante zur Umrechnung von Euro in Dollar. 
	 * {@link} https://www.finanzen.net/waehrungsrechner/euro_britische-pfund
	 */
	public static final double euro2pfund = 0.8698;
	
	/**
	 * Konstante zur Umrechnung von Euro in Dollar. 
	 * {@link} https://www.finanzen.net/waehrungsrechner/britische-pfund_euro
	 */
	public static final double pfund2euro = 1.1495;
	
	/**
	 * Initialisiere Variable f�r Name der ausgew�hlten W�hrung
	 */
	private String currency = null;
	
	/**
	 * Initialisiere Variable f�r Symbol ausgew�hlten W�hrung
	 */
	private String currencySymbol = null;
	
	
	public Currency(String curr) {
		switch(curr) {
		case euro: 
			System.out.println("W�hrung "+euro+" instanziiert...");
			this.currency = euro;
			this.currencySymbol = "�";
			break;
		case dollar: 
			System.out.println("W�hrung "+dollar+" instanziiert...");
			this.currency = dollar;
			this.currencySymbol = "$";
			break;
		case pfund: 
			System.out.println("W�hrung "+pfund+" instanziiert...");
			this.currency = pfund;
			this.currencySymbol = "�";
			break;
		default: 
			break;
		}
	}
	
	public boolean validate(String input) {
		if(this.currency.equals(input) || this.currencySymbol.equals(input)) {
			return true;
		}
		return false;
	}
	
	public String getCurrency() {
		return this.currency;
	}
	
}
