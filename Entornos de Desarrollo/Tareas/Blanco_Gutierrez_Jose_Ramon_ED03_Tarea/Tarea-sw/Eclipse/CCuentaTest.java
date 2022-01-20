import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * clase de prueba para Eclipse
 **/
class CCuentaTest {
	CCuenta miCuenta = new CCuenta();

	@ParameterizedTest
	/*
	 * Introducir en la línea siguiente los valores de prueba de entrada y
	 *  la salida esperada en forma de matriz de 2 dimensiones. 
	 *  IMPORTANTE: Los valores que están no son correctos y debes modificarlos
	 */
	@CsvSource({ "35.4, 11", "-13.0, 75", "1250.0, -100" })
	@DisplayName("Caja Blanca - Ingresar")
	void testIngreso(double cant, int resul) {
		assertEquals(resul, miCuenta.ingresar(cant));
	}
}