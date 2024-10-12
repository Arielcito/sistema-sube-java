package redDeTransporte;

import java.time.LocalDate;

public class Viaje {
	private String medioYLinea;
	private double precio;
	private double descuento;
	private LocalDate fecha;
	
	public  Viaje(String medioYLinea, double precio, double descuento,LocalDate fecha) {
		this.medioYLinea = medioYLinea;
		this.precio = precio;
		this.descuento=descuento;
		this.fecha = fecha;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	

	public String getMedioYLinea() {
		return medioYLinea;
	}

	public void setMedioYLinea(String medioYLinea) {
		this.medioYLinea = medioYLinea;
	}

	@Override
	public String toString() {
		return "Viaje [getPrecio()=" + getPrecio() + ", getDescuento()=" + getDescuento() + ", getFecha()=" + getFecha()
				+ ", getMedioYLinea()=" + getMedioYLinea() + "]";
	}
	
	
}
