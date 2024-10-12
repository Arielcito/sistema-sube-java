package redDeTransporte;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Sistema {

	private List<Usuario> usuarios;
	private List<Tarjeta> tarjetas;
	
	public Sistema() {
		this.usuarios = new ArrayList<Usuario>();
		this.tarjetas = new ArrayList<Tarjeta>();
	}
	
	public Usuario traerUsuario(long dni) {
	    Usuario usuarioEncontrado = null;
	    int i = 0;
	    while (i < usuarios.size() && usuarioEncontrado == null) {
	        Usuario usuario = usuarios.get(i);
	        if (usuario.getDni() == dni) {
	            usuarioEncontrado = usuario;
	        }
	        i++;
	    }
	    return usuarioEncontrado;
	}

	
	public boolean agregarUsuario(long dni, String apellido, String nombre) throws Exception {
		if(traerUsuario(dni) != null) throw new Exception("El usuario ya existe");
		int id = 1;  
	    if (this.usuarios.size() > 0) {
	        id = this.usuarios.get(this.usuarios.size() - 1).getId() + 1;
	    }
		Usuario nuevoUsuario = new Usuario(id,dni,apellido,nombre);
		this.usuarios.add(nuevoUsuario);

		return true;
	}
	
	public List<Usuario> traerUsuariosSinSaldo(){
		List<Usuario> usuariosSinSaldo = new ArrayList<Usuario>();

		for(Tarjeta t : tarjetas) {
			if(t.getSaldoActual() == 0) usuariosSinSaldo.add(t.getUsuario());
		}
		return usuariosSinSaldo;
	}
	
	public Tarjeta traerTarjeta(String codigo) {
	    Tarjeta tarjetaEncontrada = null;
	    int i = 0;
	    while (i < tarjetas.size() && tarjetaEncontrada == null) {
	        Tarjeta tarjeta = tarjetas.get(i);
	        if (tarjeta.getCodigo().equals(codigo)) {
	            tarjetaEncontrada = tarjeta;
	        }
	        i++;
	    }
	    return tarjetaEncontrada;
	}

	
	public boolean agregarTarjeta(String codigo, Usuario usuario) throws Exception {
		Tarjeta nuevaTarjeta = new Tarjeta(codigo,usuario);
		this.tarjetas.add(nuevaTarjeta);

		return true;
	}
	
	
	public void mostrarListaUsuarios() {
		for (Iterator<Usuario> iter = this.usuarios.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
			}
	}
	
	public void mostrarListaTarjetas() {
		for (Iterator<Tarjeta> iter = this.tarjetas.iterator(); iter.hasNext();) {
			System.out.println(iter.next());
			}
	}
}


