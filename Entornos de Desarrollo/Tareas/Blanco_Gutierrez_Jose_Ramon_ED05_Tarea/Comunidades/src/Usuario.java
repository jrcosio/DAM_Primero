/**
 * Clase Abstracta Usuario es la plantilla usada para los datos personales de los vecinos y los trabjadores
 */
public abstract class Usuario {

	private String nombre;
	private String dni;
	private String email;
	private String direccion;

	/**
	 * Constructor de la clase
	 * @param nombre
	 * @param dni
	 * @param email
	 * @param direccion
	 */
	public Usuario(String nombre, String dni, String email, String direccion) {
		// TODO - implement Usuario.Usuario
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

	public String getDni() {
		return this.dni;
	}

	/**
	 * 
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
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

}