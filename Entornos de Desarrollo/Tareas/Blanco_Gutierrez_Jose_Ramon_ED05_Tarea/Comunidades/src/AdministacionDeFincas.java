
import java.util.ArrayList;

/**
 * Clase principal del programa donde se almacenan los datos de todas las comunidades 
 * y de los empleados de la administraci�n de fincas.
 * 
 * Por JRBLANCO
 */
public class AdministacionDeFincas {

	private ArrayList<Comunidad> comunidades;
	private ArrayList<Trabajador> empleados;

	public ArrayList<Comunidad> getComunidades() {
		return this.comunidades;
	}

        /**
	 * Constructor de la clase
	 */
	public AdministacionDeFincas() {
		// TODO - implement AdministacionDeFincas.AdministacionDeFincas
		throw new UnsupportedOperationException();
	}
	/**
	 * 
	 * @param comunidades
	 */
	public void setComunidades(ArrayList<Comunidad> comunidades) {
		this.comunidades = comunidades;
	}

	public ArrayList<Trabajador> getEmpleados() {
		return this.empleados;
	}

	/**
	 * 
	 * @param empleados
	 */
	public void setEmpleados(ArrayList<Trabajador> empleados) {
		this.empleados = empleados;
	}

	

}