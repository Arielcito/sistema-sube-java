package test;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import redDeTransporte.Sistema;
import redDeTransporte.Usuario;
import redDeTransporte.Tarjeta;

public class TestTema2 {

	public static void main(String[] args) throws Exception {
		System.out.println("1)");
		Sistema s = new Sistema();
		
		try{
			s.agregarUsuario(33333333,"Apellido","Nombre");
			}
			catch ( Exception e ){
			System.out.println( "Excepcion: " + e.getMessage() );
			}
		
		try {
			s.agregarUsuario(44444444, "Otro Apellido", "Otro Nombre");
		} catch (Exception e) {
			System.out.println( "Excepcion: " + e.getMessage() );
		}
		
		s.mostrarListaUsuarios();
		Usuario usuario1 = s.traerUsuario(33333333);
		Usuario usuario2 = s.traerUsuario(44444444);
		
		try {
			s.agregarTarjeta("111222", usuario1);
		}catch(Exception e) {
			System.out.println( "Excepcion: " + e.getMessage() );
		}
		try {
			s.agregarTarjeta("333444", usuario2);
		}catch(Exception e) {
			System.out.println( "Excepcion: " + e.getMessage() );
		}
		

		Tarjeta tarjeta1 = s.traerTarjeta("111222");
		s.mostrarListaTarjetas();
		
		tarjeta1.agregarCarga(LocalDate.of(2024, 9, 23), 200.0);
		tarjeta1.agregarCarga(LocalDate.of(2024, 9, 30), 800.0);
		
		tarjeta1.mostrarListaCargas();
		System.out.println(tarjeta1.getSaldoActual());
		
		tarjeta1.agregarViaje("1", 100, LocalDate.of(2024, 10, 01));
		tarjeta1.agregarViaje("1", 100, LocalDate.of(2024, 10, 02));
		tarjeta1.agregarViaje("2", 200, LocalDate.of(2024, 10, 02));
		tarjeta1.agregarViaje("3", 100, LocalDate.of(2024, 10, 02));
		tarjeta1.agregarViaje("4", 150, LocalDate.of(2024, 10, 02));
		tarjeta1.agregarViaje("1", 100, LocalDate.of(2024, 10, 03));
		tarjeta1.agregarViaje("1", 100, LocalDate.of(2024, 10, 04));
		tarjeta1.mostrarViajes();
		System.out.println("Saldo actual: "+tarjeta1.getSaldoActual());
		tarjeta1.agregarViaje("1", 175, LocalDate.of(2024, 10, 02));
		
		System.out.println("Gastos el 2 de Octubre: "+tarjeta1.calcularGastoTarjetaEnDia(LocalDate.of(2024, 10, 02)));
		List<Usuario> usuariosSinSaldo = s.traerUsuariosSinSaldo();
		System.out.println(usuariosSinSaldo);
	}

}
