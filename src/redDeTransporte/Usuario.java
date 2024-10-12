package redDeTransporte;

import java.util.Objects;

public class Usuario {
	private int id;
	private long dni;
	private String apellido;
	private String nombre;
	
	public Usuario(int id, long dni, String apellido, String nombre) {
		this.id = id;
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuario [getId()=" + getId() + ", getDni()=" + getDni() + ", getApellido()=" + getApellido()
				+ ", getNombre()=" + getNombre() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, dni, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellido, other.apellido) && dni == other.dni && id == other.id
				&& Objects.equals(nombre, other.nombre);
	} 
	
	
}
