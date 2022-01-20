
import ccuenta.CCuenta;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 
 * clase de prueba para Netbeans
 */
@RunWith(Parameterized.class)
public class CCuentaTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
	/*
	 * Introducir en la línea siguiente los valores de prueba de entrada y
	 *  la salida esperada en forma de matriz de 2 dimensiones. 
	 *  IMPORTANTE: Los valores que están no son correctos y debes modificarlos
	 */
            {-1, 1}, {-3.0, 2}, {100, 0} 
        });
    }

    private final CCuenta miCuenta;
    private final double cant;
    private final int expResult;

    public CCuentaTest(double cant, int expResult) {

        this.miCuenta = new CCuenta();
        this.cant = cant;
        this.expResult = expResult;
    }

    /**
     * Test of ingresar method, of class CCuenta.
     */
    @Test
    public void testIngresar() {
        System.out.println("ingresar");

        int result = miCuenta.ingresar(cant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
