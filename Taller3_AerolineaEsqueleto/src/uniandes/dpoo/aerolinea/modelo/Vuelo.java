package uniandes.dpoo.aerolinea.modelo;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Objects;

public class Vuelo {

    private String fecha;
    private Ruta ruta;
    private Avion avion;
    private Collection<Tiquete> tiquetes;

    // Constructor
    public Vuelo(Ruta ruta, String fecha, Avion avion) {
        this.ruta = ruta;
        this.fecha = fecha;
        this.avion = avion;
        this.tiquetes = new ArrayList<>();
    }

    public Ruta getRuta() {
        return ruta;
    }

    public String getFecha() {
        return fecha;
    }

    public Avion getAvion() {
        return avion;
    }

    public Collection<Tiquete> tiquetes() {
        return tiquetes;
    }

    public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) {
        int vendidos = 0;
        for (int i = 0; i < cantidad; i++) {
            Tiquete tiquete = new Tiquete(cliente, ruta, avion, calculadora.calcularTarifa(ruta, avion));
            tiquetes.add(tiquete);
            vendidos++;
        }
        return vendidos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vuelo vuelo = (Vuelo) obj;
        return fecha.equals(vuelo.fecha) && ruta.equals(vuelo.ruta) && avion.equals(vuelo.avion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ruta, fecha, avion);
    }
}
