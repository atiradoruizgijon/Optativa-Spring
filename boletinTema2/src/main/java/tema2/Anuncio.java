package tema2;

public class Anuncio {

	private String nombre;
	private String asunto;
	private String descripcion;
	
	public Anuncio(String nombre, String asunto, String descripcion) {
		super();
		this.nombre = nombre;
		this.asunto = asunto;
		this.descripcion = descripcion;
	}
	public Anuncio() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
