
import java.util.Date;

/**
 * Clase Facturas, para almacenar los datos de las facturas que emiten las empresas a cada comunidad por los servicios contratados.
 */
public class Facturas {

	private String descripcio;
	private Date fecha;
	private float importe;
	private boolean estado;
	private Empresa empresa;
	private int codigoFactura;

	/**
	 * 
	 * @param coid
	 * @param descripcion
	 * @param fecha
	 * @param importe
	 * @param empresa
	 */
	public Facturas(int coid, String descripcion, Date fecha, float importe, Empresa empresa) {
		// TODO - implement Facturas.Facturas
		throw new UnsupportedOperationException();
	}

	public String getDescripcio() {
		return this.descripcio;
	}

	/**
	 * 
	 * @param descripcio
	 */
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public Date getFecha() {
		return this.fecha;
	}

	/**
	 * 
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getImporte() {
		return this.importe;
	}

	/**
	 * 
	 * @param importe
	 */
	public void setImporte(float importe) {
		this.importe = importe;
	}

	public boolean getEstado() {
		return this.estado;
	}

	/**
	 * 
	 * @param estado
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	/**
	 * 
	 * @param empresa
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public int getCodigoFactura() {
		return this.codigoFactura;
	}

	/**
	 * 
	 * @param codigoFactura
	 */
	public void setCodigoFactura(int codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

}