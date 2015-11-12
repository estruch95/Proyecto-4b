package Modelo;

public class Actividad {
	//Atributos de la clase
	private int id;
	private String asignatura;
	private String nombre;
	private String inicio;
	private String fin;
	private boolean entregada;

	public Actividad() {
		// TODO Auto-generated constructor stub
		//Constructor de la clase
	}

	//GETTERS AND SETTERS de los atributos de la clase
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public boolean isEntregada() {
		return entregada;
	}

	public void setEntregada(boolean entregada) {
		this.entregada = entregada;
	}
	
	public String toString(){
		return this.nombre;
	}
	
}
