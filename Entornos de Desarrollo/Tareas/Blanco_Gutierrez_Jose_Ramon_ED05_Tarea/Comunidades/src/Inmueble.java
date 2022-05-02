/**
 * Clase Inmueble utilizada para almacenar los datos de cada tipo de inmueble
 */
public class Inmueble {

	private int codigo;
	private float saldo;
	private int cuotasPendientes;
	private TipoInmueble tipo;

	/**
	 * Constructor de la clase
	 * @param cod
	 * @param saldo
	 * @param cuotasPend
	 * @param tipo
	 */
	public Inmueble(int cod, float saldo, int cuotasPend, TipoInmueble tipo) {
		// TODO - implement Inmueble.Inmueble
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

	public int getCuotasPendientes() {
		return this.cuotasPendientes;
	}

	/**
	 * 
	 * @param cuotasPendientes
	 */
	public void setCuotasPendientes(int cuotasPendientes) {
		this.cuotasPendientes = cuotasPendientes;
	}

	public TipoInmueble getTipo() {
		return this.tipo;
	}

	/**
	 * 
	 * @param tipo
	 */
	public void setTipo(TipoInmueble tipo) {
		this.tipo = tipo;
	}

}