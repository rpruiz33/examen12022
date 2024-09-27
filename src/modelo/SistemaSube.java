package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaSube {
private List <Usuario> usuarios;
private List <Tarjeta> tarjetas;
private List <Viaje> viaje;
public List<Usuario> getUsuarios() {
	return usuarios;
}
public void setUsuarios(List<Usuario> usuarios) {
	this.usuarios = usuarios;
}
public List<Tarjeta> getTarjetas() {
	return tarjetas;
}
public void setTarjetas(List<Tarjeta> tarjetas) {
	this.tarjetas = tarjetas;
}
public List<Viaje> getViaje() {
	return viaje;
}
public void setViaje(List<Viaje> viaje) {
	this.viaje = viaje;
}
public SistemaSube() {
	super();
	this.usuarios = new ArrayList<Usuario>();
	this.tarjetas = new ArrayList<Tarjeta>();
	this.viaje = new ArrayList<Viaje>();
}


public Usuario traerUsuario(long dni) {
	int i=0;
	Usuario usuarioAux=null;
	while(i<usuarios.size()&& usuarioAux==null) {
		if(usuarios.get(i).getDni()==dni) {
			usuarioAux=usuarios.get(i);
		}
		i++;
		
	}
	return usuarioAux;
}

public boolean agregarUsuario(long dni, String nomnbre, String apellido, boolean tieneDescuento) throws Exception{
	
	int id=1;
	boolean aux=false;
	Usuario user=traerUsuario( dni);
	if(user!=null) {
		throw new Exception ("ya existe ese usuario con ese dni");
	}
	else {
		usuarios.add(new Usuario(id,dni, nomnbre, apellido, tieneDescuento));
		aux=true;
	}
	
	return aux;
	
	
}


public Tarjeta traerTarjeta(String codigo) {
	Tarjeta card=null;
	int i=0; 
	while(i<tarjetas.size()&& card==null) {
		if(tarjetas.get(i).getCodigo().equals(codigo)) {
		card=tarjetas.get(i);
	}
	
	i++;

}
	return card;
}

public boolean agregarTargeta(String codigo, Usuario usuario)throws Exception {
	boolean auxCard=false;

	Tarjeta card=traerTarjeta(codigo);
	if(card==null) {
		if (codigo.length()>=10) {
			auxCard=tarjetas.add(new Tarjeta ( codigo,usuario));
		}else {
			throw new Exception("tiene menos de 10 digitos la tarjeta");
			
		}
		
	}
	
	return auxCard;
}

public List<Viaje>traerViaje(LocalDateTime desde , LocalDateTime hasta){
List<Viaje> viaj=new ArrayList<Viaje>();
LocalDateTime fecha=null;
for (int i=0;i<viaje.size();i++) {
	
		fecha=Funciones.traerFechasEntreYhora(desde, hasta, viaje.get(i).getFechaHoraViaje());
		if(fecha!=null) {
			viaj.add(viaje.get(i));
		}
	
	}
return viaj;
}
public boolean agregarViaje(Tarjeta tarjeta, String linea, String medio, LocalDateTime fechaHoraViaje, double precio){
	boolean aux=false;
	List<Viaje> viaj=getViaje();

	
		return aux=viaj.add(new Viaje(tarjeta, linea, medio, fechaHoraViaje, precio));

	
}


@Override
public String toString() {
	return "SistemaSube [usuarios=" + usuarios + " tarjetas=" + tarjetas + "viaje=" + viaje + "]";
}


public double totalAPagar() {
    double total = 0.0;
    List<Viaje> viajes = getViaje();  

    for (int i=0;i<viajes.size();i++){
        double precio = viajes.get(i).getPrecio();
        if (usuarios.get(i).isTieneDescuento()) {
            precio = precio * 0.9; 
        }
        total += precio;
    }
    return total;
}
public double calcularTotalFacturadoEntreFechas(LocalDateTime desde , LocalDateTime hasta) {
List<Viaje> viajes2=new ArrayList<Viaje>();
double total=0;
viajes2=traerViaje(desde, hasta);
for (int i=0;i<viajes2.size();i++){
    total += viajes2.get(i).getPrecio();
  
}
return total;

}
}