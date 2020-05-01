/**
 * 
 */
package Git;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

/**
 * @author Patrick-Lehmann
 *
 */
class CurrencyTests {
	
	private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
  
    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    @Order(1)
    public void FalscheFliesskommazahlTest() {
        final String testString = "Dollar\n0.5\n0,5";
        provideInput(testString);
        Client.main(new String[0]);
        System.out.println("-------------------------------------------");
        System.out.println("");
    }
    
    @Test
    @Order(2)
    public void KeineZahlTest() {
        final String testString = "Pfund\n0.a\n1000";
        provideInput(testString);
        Client.main(new String[0]);
        System.out.println("-------------------------------------------");
        System.out.println("");
    }
    
    @Test
    @Order(3)
    public void KeineZahl2Test() {
        final String testString = "Euro\nB1\n200";
        provideInput(testString);
        Client.main(new String[0]);
        System.out.println("-------------------------------------------");
        System.out.println("");
    }
    
    @Test
    @Order(4)
    public void NeueWaehrungTest() {
        final String testString = "Bananen\nY\n1\n2\n0,1\n10";
        provideInput(testString);
        Client.main(new String[0]);
        System.out.println("-------------------------------------------");
        System.out.println("");
    }
    
	@Test
    @Order(5)
	void ConverterTest() {
		assertEquals(5.0,Currency.convert((double) -5.0,(double) -1.0));
	}
	
	@Test
	@Order(6)
	void DollarTest() {
		Currency Euro = new Currency(Currency.euro);
		assertEquals(5473.0,Euro.toDollar((double) 5000.0));
	}
    
    @Test
    @Order(7)
    public void ProgrammBeendenTest() {
        final String testString = "DollAr\nN\nY";
        provideInput(testString);
        Client.main(new String[0]);
        System.out.println("-------------------------------------------");
        System.out.println("");
    }
    

}
