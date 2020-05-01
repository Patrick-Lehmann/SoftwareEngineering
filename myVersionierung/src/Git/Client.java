/**
 * 
 */
package Git;

/**
 * @author Patrick-Lehmann
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Willkommen im Währungsrechner!");
		System.out.println("");
		
		Currency Euro = new Currency(Currency.euro);
		Currency Dollar = new Currency(Currency.dollar);
		Currency Pfund = new Currency(Currency.pfund);
		
	}

}
