
import java.util.ArrayList;

/**
 * Clase Vecino, para almacenar los datos de los vecinos y los inmuebles que este posee, tiene la particularidad que tambien identifica si un vecino es o no es presidente y si lo es da acceso a ciertas funciones que solo el presidente puede hacer.
 */
public class Vecino extends Usuario {

	private String cuentaBancaria;
	private ArrayList<Inmueble> inmuebles;
	private boolean esPresidente;

	/**
	 * Constructor de la clase
	 * @param nombre
	 * @param dni
	 * @param email
	 * @param direccion
	 * @param cuentaB
	 * @param inmueble
	 */
	public Vecino(String nombre, String dni, String email, String direccion, String cuentaB, Inmueble inmueble) {
            super(nombre, dni, email, direccion);
		// TODO - implement Vecino.Vecino
		throw new UnsupportedOperationException();
	}

	public String getCuentaBancaria() {
		return this.cuentaBancaria;
	}

	/**
	 * 
	 * @param cuentaBancaria
	 */
	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public ArrayList<Inmueble> getInmuebles() {
		return this.inmuebles;
	}

	/**
	 * 
	 * @param inmuebles
	 */
	public void setInmuebles(ArrayList<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}

	/**
	 * metodo que lista los inmuebles de un vecino
	 */
	public void verInmuebles() {
		// TODO - implement Vecino.verInmuebles
		throw new UnsupportedOperationException();
	}

	/**
	 * metodo para pagar la deuda si la hubiera de un vecino
	 * @param deuda
	 * @param codInmueble
	 */
	public void pagarDeuda(float deuda, int codInmueble) {
		// TODO - implement Vecino.pagarDeuda
		throw new UnsupportedOperationException();
	}

	/**
	 * metodo para poder modificar los datos personales de un vecino
	 * @param nombre
	 * @param dni
	 * @param email
	 * @param direccion
	 * @param cuentaB
	 */
	public void modificarDatosPersonales(String nombre, String dni, String email, String direccion, String cuentaB) {
		// TODO - implement Vecino.modificarDatosPersonales
		throw new UnsupportedOperationException();
	}

	public boolean getEsPresidente() {
		return this.esPresidente;
	}

	/**
	 * 
	 * @param esPresidente
	 */
	public void setEsPresidente(boolean esPresidente) {
		this.esPresidente = esPresidente;
	}

	/**
	 * Metodo para convocar una junta, este metodo solo puede ser ejecutado si es presidente un vecino
	 */
	public void convocaJunta() {
		// TODO - implement Vecino.convocaJunta
		throw new UnsupportedOperationException();
	}

	/**
	 * Metodo para ver un acta
	 */
	public void verActa() {
		// TODO - implement Vecino.verActa
		throw new UnsupportedOperationException();
	}

}