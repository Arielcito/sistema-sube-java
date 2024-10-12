package redDeTransporte;

import java.time.LocalDate;

public class Carga {
	private LocalDate fecha;
	private double valor;
	public Carga(LocalDate fecha, double valor) {
		super();
		this.fecha = fecha;
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Carga [fecha=" + fecha + ", valor=" + valor + "]";
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
