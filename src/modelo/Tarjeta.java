package modelo;

public class Tarjeta {
private String codigo; 
private Usuario usuario;


public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public Usuario getUsuario() {
	return usuario;
}
public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}
public Tarjeta(String codigo, Usuario usuario) {
	super();
	this.codigo = codigo;
	this.usuario = usuario;
}

public boolean equals(Tarjeta tarjeta) {
	return tarjeta.getCodigo().equals(codigo)&& tarjeta.getUsuario().equals(usuario);
}
@Override
public String toString() {
	return "Tarjeta [codigo=" + codigo + ", usuario=" + usuario + "]";
}
}