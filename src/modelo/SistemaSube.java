package modelo;

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
public SistemaSube(List<Usuario> usuarios, List<Tarjeta> tarjetas, List<Viaje> viaje) {
	super();
	this.usuarios = usuarios;
	this.tarjetas = tarjetas;
	this.viaje = viaje;
}



}
