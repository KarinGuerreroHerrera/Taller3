package uniandes.dpoo.aerolinea.modelo;
import java.util.List;

public abstract class Cliente {
public Cliente() {
	// Constructor
	}
	public abstract String getTipoCliente();
	public abstract String getIdentificador();

	public void agregarTiquete(Tiquete tiquete) {
	}

	public int calcularValorTotalTiquetes(List<Tiquete> tiquetes) {
	        return 0; 
	}

	public void usarTiquetes(Vuelo vuelo) {
	}
}