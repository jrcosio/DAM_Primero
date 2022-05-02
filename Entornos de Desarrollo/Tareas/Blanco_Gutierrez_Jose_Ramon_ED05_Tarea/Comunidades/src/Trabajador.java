
import java.util.ArrayList;

/**
 * Clase Trabajor es para almacenar los datos de los trabajadores. Tiene la particularidad que tambien vale para identificar a un trabajador que sea administrador de alguna o varias comunidades y en funci�n de si es administrador o no tiene una serie de metodos activos.
 */
public class Trabajador extends Usuario {

	private int codigo;
	private String cargo;
	private boolean esAdministrador;

	/**
	 * Constructor de la clase
	 * @param nombre
	 * @param dni
	 * @param email
	 * @param direccion
	 * @param cod
	 * @param cargo
	 */
	public Trabajador(String nombre, String dni, String email, String direccion, int cod, String cargo) {
            super(nombre, dni, email, direccion);
		// TODO - implement Trabajador.Trabajador
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

	public String getCargo() {
		return this.cargo;
	}

	/**
	 * 
	 * @param cargo
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void contratarEmpresa() {
		// TODO - implement Trabajador.contratarEmpresa
		throw new UnsupportedOperationException();
	}

	public boolean getEsAdministrador() {
		return this.esAdministrador;
	}

	/**
	 * 
	 * @param esAdministrador
	 */
	public void setEsAdministrador(boolean esAdministrador) {
		this.esAdministrador = esAdministrador;
	}

	/**
	 * Metodo para enviar cartas a los vecino de una comunidad convocandoles a una junta
	 * @param listaVecinos
	 */
	public void enviarCartas(ArrayList<Vecino> listaVecinos) {
		// TODO - implement Trabajador.enviarCartas
		throw new UnsupportedOperationException();
	}

}