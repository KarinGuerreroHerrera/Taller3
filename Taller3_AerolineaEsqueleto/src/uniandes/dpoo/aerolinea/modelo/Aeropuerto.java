package uniandes.dpoo.aerolinea.modelo;

import java.util.HashSet;
import java.util.Set;
import uniandes.dpoo.aerolinea.exceptions.AeropuertoDuplicadoException;

public class Aeropuerto {
    private String codigo;
    private String nombre;
    private String ciudad;
    private double latitud;
    private double longitud;

/**
 * Esta clase encapsula la información sobre los aeropuertos e implementa algunas operaciones relacionadas con la ubicación geográfica de los aeropuertos.
 * 
 * No puede haber dos aeropuertos con el mismo código.
 */
    // TODO completar
    private static double RADIO_TERRESTRE = 6371.0; 
    private static Set<String> codigosExistentes = new HashSet<>();

    public Aeropuerto(String nombre, String codigo, String ciudad, double latitud, double longitud) throws AeropuertoDuplicadoException {
        if (codigosExistentes.contains(codigo)) {
            throw new AeropuertoDuplicadoException("El código del aeropuerto ya existe: " + codigo);
        }
        this.nombre = nombre;
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.latitud = latitud;
        this.longitud = longitud;
        codigosExistentes.add(codigo);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }


    /**
     * Este método calcula la distancia *aproximada* entre dos aeropuertos. Hay fórmulas más precisas pero esta es suficientemente buena para el caso de la aerolínea.
     * 
     * Este método asume que las coordenadas (latitud y longitud) de los aeropuertos están expresadas en la forma que las hace más cercanas. Si no es así, la distancia entre
     * los dos aeropuertos podría ser la más larga posible.
     * 
     * Por ejemplo, dependiendo de cómo estén expresadas las longitudes, la distancia calculada entre Narita (Tokyo) y El Dorado (Bogotá) podría ser atravesando el Pacífico, o
     * atravesando el Atlántico y Asia (el camino largo)
     * 
     * @param aeropuerto1
     * @param aeropuerto2
     * @return La distancia en kilómetros entre los puntos
     */
	public static double calcularDistancia(Aeropuerto aeropuerto1, Aeropuerto aeropuerto2) {
        double lat1 = Math.toRadians(aeropuerto1.getLatitud());
        double lon1 = Math.toRadians(aeropuerto1.getLongitud());
        double lat2 = Math.toRadians(aeropuerto2.getLatitud());
        double lon2 = Math.toRadians(aeropuerto2.getLongitud());

        double deltaLat = lat2 - lat1;
        double deltaLon = lon2 - lon1;

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RADIO_TERRESTRE * c; 
    }
}