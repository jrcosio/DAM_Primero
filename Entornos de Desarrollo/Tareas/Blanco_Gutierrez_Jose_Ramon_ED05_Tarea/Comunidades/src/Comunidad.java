
import java.util.ArrayList;

/**
 * Clase para cada comunidad de vecinos. El construcor de la clase los tiene que a�adir un codigo y una direcci�n y posteriormente se van a�adiendo los vecinos, facturas y las juntas.
 */
public class Comunidad {

	private int codigo;
	private String direccion;
	private float saldo;
	private ArrayList<Vecino> vecinos;
	private ArrayList<Facturas> facturas;
	private int administrador;
	private ArrayList<Junta> juntas;

	/**
	 * Constructor de la clase
	 * @param codigo
	 * @param direccion
	 */
	public Comunidad(int codigo, String direccion) {
		// TODO - implement Comunidad.Comunidad
		throw new UnsupportedOperationException();
	}

	public int getCodigo() {
		return this.codigo;
	}

	/**
	 * 
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * 
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public float getSaldo() {
		return this.saldo;
	}

	/**
	 * 
	 * @param saldo
	 */
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public ArrayList<Vecino> getVecinos() {
		return this.vecinos;
	}

	/**
	 * 
	 * @param vecinos
	 */
	public void setVecinos(ArrayList<Vecino> vecinos) {
		this.vecinos = vecinos;
	}

	public ArrayList<Facturas> getFacturas() {
		return this.facturas;
	}

	/**
	 * 
	 * @param facturas
	 */
	public void setFacturas(ArrayList<Facturas> facturas) {
		this.facturas = facturas;
	}

	public int getAdministrador() {
		return this.administrador;
	}

	/**
	 * 
	 * @param administrador
	 */
	public void setAdministrador(int administrador) {
		this.administrador = administrador;
	}

	public ArrayList<Junta> getJuntas() {
		return this.juntas;
	}

	/**
	 * 
	 * @param juntas
	 */
	public void setJuntas(ArrayList<Junta> juntas) {
		this.juntas = juntas;
	}

	/**
	 * Metodo para pagar facturas de la comunidad
	 * @param factura
	 */
	public void pagarFactura(Facturas factura) {
		// TODO - implement Comunidad.pagarFactura
		throw new UnsupportedOperationException();
	}

	/**
	 * metodo para visualizar un factura determinada
	 * @param codigo
	 */
	public void verFactura(int codigo) {
		// TODO - implement Comunidad.verFactura
		throw new UnsupportedOperationException();
	}

}