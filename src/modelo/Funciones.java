package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Funciones {
	public static boolean biciesto(int anio) {
		return ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0));
	}
	// esFechaValida (LocalDate fecha) : boolean
	// En el caso de ser bisiesto es válido el día 29/02

	public static boolean esFechaValida(LocalDate date) {
		int anio =date.getYear();
		boolean aux=false;
		if (biciesto(anio)) {
			if (date.getMonthValue()==2 && date.getDayOfMonth()==29) {
				System.out.println(date);
				aux=true;
			}
	
		}
		System.out.println(date);
		aux=true;
		return aux;
		
			
	
	}
	// + traerFechaCorta (LocalDate fecha) : String

	public static String traerFechaCorta(LocalDate date) {
		return date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear();
	}

	// traerHoraCorta (LocalTime hora) : String
	// Retorna “hh:mm”
	public static String traerHoraCorta(LocalTime hora) {
		return hora.getHour() + ":" + hora.getMinute();
	}

	public static boolean esDiaHabil(LocalDate fecha) {
		int d = fecha.getDayOfWeek().getValue();
		/*
		 * Help: LocalDate fecha=LocalDate.of (2019,9,30); int
		 * nroDiaSem=fecha.getDayOfWeek().getValue(); //nroDiaSem=1,from 1 (Monday) to 7
		 * (Sunday)
		 */
		return ((d >= 1) && (d <= 5));
	}

	// + traerDiaDeLaSemana (LocalDate) : String
	public static String traerDiaDeLaSemana(LocalDate fecha) {
		return fecha.getDayOfWeek().toString();
	}

//+ traerMesEnLetras (LocalDate fecha) : String
	public static String traerMesEnLetras(LocalDate fecha) {

		return fecha.getMonth().toString();
	}

//traerFechaLarga (LocalDate fecha) : String
//Ejemplo: “Sábado 20 de Agosto del 2016
	public static String traerFechaLarga(LocalDate fecha) {

		return fecha.getDayOfWeek() + " " + fecha.getDayOfMonth() + " " + " de " + fecha.getMonth() + " del "
				+ fecha.getYear();
	}

//+ traerCantDiasDeUnMes (int anio, int mes) : int
	public static int traerCantDiasDeUnMes(int anio, int mes) {
		int aux=-1;
		LocalDate date = LocalDate.of(anio, mes, 1);
		if(biciesto(anio)&&mes==2) {
			aux=29;
		}
		
		else {
			aux= date.lengthOfMonth();
		}
		
		return aux;
	}
//	+ aproximar2Decimal (double valor) : double
//	Si el tercer decimal es mayor o igual 5, suma 1 al segundo decimal
	public static double aproximar2Decimal(double valor) {
	   
	    double valorMultiplicado = valor * 100;

	    int tercerDecimal = (int) valorMultiplicado % 10;

	    if (tercerDecimal >= 5) {
	        valorMultiplicado = Math.ceil(valorMultiplicado ) ;
	    } else {
	        valorMultiplicado = Math.floor(valorMultiplicado );
	    }


	    double valorRedondeado = valorMultiplicado / 100;

	    return valorRedondeado;
	}
		
//	+ esNumero(char c) : boolean+
	 public static boolean esNumero(char c) {
	        return (c >= '0' && c <= '9');
	    }
	 //+ esLetra(char c) : boolean
	 public static boolean esLetra(char c) {
		 
		return !(c >= '0' && c <= '9');
	 }
	// + esCadenaNros(String cadena) : boolean
	 
	 public static boolean esCadenaNros(String cadena) {
		 boolean aux=false;
		 for (int i = 0; i < cadena.length(); i++) {
		 char letra=cadena.charAt(i);
			 if(!Funciones.esLetra(letra)) {
				 aux=true;
			 }
		 }
		 return aux;
		
			 
		
	 }
	 //+ esCandenaLetras(String cadena) : boolean
	 
	 public static boolean esCadenaLetras(String cadena) {
		 boolean aux=false;
	for (int i = 0; i <cadena.length(); i++) {
		 char letra=cadena.charAt(i);
		if(!Funciones.esNumero(letra)) {
			aux=true;
		}
		
	}
	return aux;
	 }
	 public static LocalDate traerFechasEntre(LocalDate desde , LocalDate hasta, LocalDate fecha) {
		 LocalDate f=null;
		 if ((fecha.isEqual(desde)||fecha.isAfter(desde))&& (fecha.isEqual(hasta)|| fecha.isBefore(hasta))) {
			 f=fecha;
		 }
		 return f;
	 }
	 public static LocalDateTime traerFechasEntreYhora(LocalDateTime desde , LocalDateTime hasta, LocalDateTime fecha) {
		 LocalDateTime f=null;
		 if ((fecha.isEqual(desde)||fecha.isAfter(desde))&& (fecha.isEqual(hasta)|| fecha.isBefore(hasta))) {
			 f=fecha;
		 }
		 return f;
	 }
}	 
	 