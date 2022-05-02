
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase Junta, utilizada para guardar todos los datos de una junta de vecinos y que con esos datos genera las actas,
 */
public class Junta {

	private Date fecha;
	private boolean votacion;
	private ArrayList<Vecino> vecinosAsistieron;
	private ArrayList<String> ordenDelDia;
	private int codigoComunidad;
	private Trabajador trabajador;

	/**
	 * Constructor de la clase
	 * @param fecha
	 * @param codifoComunidad
	 */
	public Junta(Date fecha, int codifoComunidad) {
		// TODO - implement Junta.Junta
		throw new UnsupportedOperationException();
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

	public boolean getVotacion() {
		return this.votacion;
	}

	/**
	 * 
	 * @param votacion
	 */
	public void setVotacion(boolean votacion) {
		this.votacion = votacion;
	}

	public ArrayList<Vecino> getVecinosAsistieron() {
		return this.vecinosAsistieron;
	}

	/**
	 * 
	 * @param vecinosAsistieron
	 */
	public void setVecinosAsistieron(ArrayList<Vecino> vecinosAsistieron) {
		this.vecinosAsistieron = vecinosAsistieron;
	}

	public ArrayList<String> getOrdenDelDia() {
		return this.ordenDelDia;
	}

	/**
	 * 
	 * @param ordenDelDia
	 */
	public void setOrdenDelDia(ArrayList<String> ordenDelDia) {
		this.ordenDelDia = ordenDelDia;
	}

	public int getCodigoComunidad() {
		return this.codigoComunidad;
	}

	/**
	 * 
	 * @param codigoComunidad
	 */
	public void setCodigoComunidad(int codigoComunidad) {
		this.codigoComunidad = codigoComunidad;
	}

	public Trabajador getTrabajador() {
		return this.trabajador;
	}

	/**
	 * 
	 * @param trabajador
	 */
	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	/**
	 * Metodo para generar actas en base a los datos del objeto JUNTA
	 */
	public void GenerarActa() {
		// TODO - implement Junta.GenerarActa
		throw new UnsupportedOperationException();
	}

}