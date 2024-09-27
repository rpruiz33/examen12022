package Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import modelo.SistemaSube;

public class Test {

	public static void main(String[] args) {
		SistemaSube sistema=new SistemaSube();
		try {
			System.out.println(sistema.agregarUsuario(11111111,"1", "1", false));
			System.out.println(sistema.agregarUsuario(22222222,"2", "2", false));
			System.out.println(sistema.agregarUsuario(33333333,"3", "3", true));
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		System.out.println(sistema.agregarUsuario(22222222,"2", "2", false));
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		try {
			System.out.println(sistema.agregarTargeta("1234567890",sistema.traerUsuario(11111111)));
			System.out.println(sistema.agregarTargeta("1234567891",sistema.traerUsuario(22222222)));
			System.out.println(sistema.agregarTargeta("1234567892",sistema.traerUsuario(33333333)));
			System.out.println(sistema.getTarjetas().toString());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			System.out.println(sistema.agregarTargeta("1234",sistema.traerUsuario(22222222)));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(sistema.agregarViaje(sistema.traerTarjeta("1234567890"), "1", "1",LocalDateTime.of(2023, 9, 1, 10, 0), 50));
		System.out.println(sistema.agregarViaje(sistema.traerTarjeta("1234567890"), "2", "2",LocalDateTime.of(2023, 9, 1, 10,30), 50));
		System.out.println(sistema.agregarViaje(sistema.traerTarjeta("1234567890"), "3", "3",LocalDateTime.of(2023, 9, 2, 9, 0), 100));
		
		System.out.println(sistema.agregarViaje(sistema.traerTarjeta("1234567891"), "1", "1",LocalDateTime.of(2023, 9, 1, 10, 0), 60));
		System.out.println(sistema.agregarViaje(sistema.traerTarjeta("1234567891"), "2", "2",LocalDateTime.of(2023, 9, 2, 15, 0), 60));
		System.out.println(sistema.agregarViaje(sistema.traerTarjeta("1234567891"), "3", "3",LocalDateTime.of(2023, 9, 3, 22, 0), 60));
		
		System.out.println(sistema.agregarViaje(sistema.traerTarjeta("1234567892"), "1", "1",LocalDateTime.of(2023, 9, 1, 10, 0), 100));
		System.out.println(sistema.agregarViaje(sistema.traerTarjeta("1234567892"), "2", "2",LocalDateTime.of(2023, 9, 2, 10, 30), 100));
		System.out.println(sistema.agregarViaje(sistema.traerTarjeta("1234567892"), "3", "3",LocalDateTime.of(2023, 9, 2, 10, 0), 100));
		
		System.out.print(sistema.getViaje().toString());
		
		System.out.println(sistema.traerViaje(LocalDateTime.of(2023, 9, 2, 10, 30), LocalDateTime.of(2023, 9,3, 10, 00)));
		System.out.println(sistema.calcularTotalFacturadoEntreFechas(LocalDateTime.of(2023, 9, 2, 10, 30), LocalDateTime.of(2023, 9,3, 10, 00)));
	}
}
}
