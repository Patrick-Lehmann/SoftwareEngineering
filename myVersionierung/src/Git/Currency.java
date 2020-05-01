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
	
	
	public Currency(String curr) {
		switch(curr) {
		case euro: System.out.println("W�hrung "+euro+" instanziiert..."); break;
		case dollar: System.out.println("W�hrung "+dollar+" instanziiert..."); break;
		case pfund: System.out.println("W�hrung "+pfund+" instanziiert..."); break;
		}
	}
	
}
