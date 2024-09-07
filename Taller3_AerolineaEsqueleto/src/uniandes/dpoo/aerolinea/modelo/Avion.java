package uniandes.dpoo.aerolinea.modelo;

public class Avion extends Aerolinea {

	public Avion(String nombre, int capacidad) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.capacidad = capacidad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getCapacidad() {
		return capacidad;
	}

	private String nombre;
	private int capacidad;
	
}
