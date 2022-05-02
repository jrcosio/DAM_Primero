
import java.util.Date;

/**
 * Clase Empresa almacena los datos de una empresa, es decir su nombre y cif
 */
public class Empresa {

	private String nombre;
	private String cif;

	/**
	 * Constructor de la clase
	 * @param nombre
	 * @param cif
	 */
	public Empresa(String nombre, String cif) {
		// TODO - implement Empresa.Empresa
		throw new UnsupportedOperationException();
	}

	public String getNombre() {
		return this.nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCif() {
		return this.cif;
	}

	/**
	 * 
	 * @param cif
	 */
	public void setCif(String cif) {
		this.cif = cif;
	}

	/**
	 * Metodo para Generar una factura por un servicio realizado
	 * @param descripcion
	 * @param fecha
	 * @param importe
	 */
	public Facturas hacerFactura(String descripcion, Date fecha, float importe) {
		// TODO - implement Empresa.hacerFactura
		throw new UnsupportedOperationException();
	}

}