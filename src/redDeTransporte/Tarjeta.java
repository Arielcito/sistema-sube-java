package redDeTransporte;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Tarjeta {
	private String codigo;
	private Usuario usuario;
	private List<Viaje> viajes;
	private List<Carga> cargas;
	private double saldoActual;

	public Tarjeta(String codigo, Usuario usuario) {
		this.codigo = codigo;
		this.usuario = usuario;
		this.viajes = new ArrayList<Viaje>();
		this.cargas = new ArrayList<Carga>();
		this.saldoActual = 0;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) throws Exception {
		if (codigo.length() < 6)
			throw new Exception("El codigo debe ser mayor a 6 digitos");
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}

	public List<Carga> getCargas() {
		return cargas;
	}

	public void setCargas(List<Carga> cargas) {
		this.cargas = cargas;
	}

	public double getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}

	public boolean agregarCarga(LocalDate fecha, double valor) {
		Carga c = new Carga(fecha, valor);
		this.cargas.add(c);
		saldoActual += valor;
		return true;
	}

	public void mostrarListaCargas() {
		for (Iterator<Carga> iter = this.cargas.iterator(); iter.hasNext();) {
			System.out.println(iter.next().toString());
		}
	}

	public void mostrarViajes() {
		for (Iterator<Viaje> iter = this.viajes.iterator(); iter.hasNext();) {
			System.out.println(iter.next().toString());
		}
	}

	public List<Viaje> traerViajes(LocalDate fecha) {
		List<Viaje> viajeEnFecha = new ArrayList<>();
		for (int i = 0; i < this.viajes.size() - 1; i++) {
			Viaje viajeActual = this.viajes.get(i);
			if (fecha.equals(viajeActual.getFecha())) {
				viajeEnFecha.add(viajeActual);
			}
		}
		return viajeEnFecha;
	}

	public boolean agregarViaje(String medioYLinea, double precio, LocalDate fecha) throws Exception {
		double descuento = 0;
		List<Viaje> viajesMismoDia = traerViajes(fecha);

		if (viajesMismoDia.size() > 2)
			descuento = precio * 0.5;
		else if (viajesMismoDia.size() == 1)
			descuento = precio * 0.25;

		double nuevoPrecio = precio - descuento;
		if (this.saldoActual < nuevoPrecio)
			throw new Exception("El saldo es insuficiente");

		Viaje viaje = new Viaje(medioYLinea, precio, descuento, fecha);
		this.viajes.add(viaje);

		this.saldoActual -= nuevoPrecio;
		return true;
	}
	
	public double calcularGastoTarjetaEnDia(LocalDate fecha) {
		List<Viaje> viajes = traerViajes(fecha);
		int gasto = 0;
		for(Viaje v : viajes) {
			gasto += v.getPrecio() - v.getDescuento();
		}
		return gasto;
	}
	@Override
	public String toString() {
		return "Tarjeta [getCodigo()=" + getCodigo() + ", getUsuario()=" + getUsuario() + ", getViajes()=" + getViajes()
				+ ", getCargas()=" + getCargas() + ", getSaldoActual()=" + getSaldoActual() + "]";
	}

}
