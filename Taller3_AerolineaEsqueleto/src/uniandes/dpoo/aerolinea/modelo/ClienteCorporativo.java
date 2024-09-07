package uniandes.dpoo.aerolinea.modelo;

import org.json.JSONObject;

public class ClienteCorporativo extends Cliente {
    public String CORPORATIVO = "Corporativo";
    public int GRANDE = 1;
    public int MEDIANA = 2;
    public int PEQUENA = 3;

    private String nombreEmpresa;
    private int tamanoEmpresa;

    // Constructor
    public ClienteCorporativo(String nombreEmpresa, int tamano) {
        this.nombreEmpresa = nombreEmpresa;
        this.tamanoEmpresa = tamano;
    }
@Override
public String getTipoCliente() {
    return CORPORATIVO;
}

@Override
public String getIdentificador() {
    return nombreEmpresa;
}

public String getNombreEmpresa() {
    return nombreEmpresa;
}

public int getTamanoEmpresa() {
    return tamanoEmpresa;
}

public static ClienteCorporativo cargarDesdeJSON(JSONObject cliente) {
    String nombre = cliente.getString("nombreEmpresa");
    int tamano = cliente.getInt("tamanoEmpresa");
    return new ClienteCorporativo(nombre, tamano);
}

public JSONObject salvarEnJSON() {
    JSONObject json = new JSONObject();
    json.put("nombreEmpresa", nombreEmpresa);
    json.put("tamanoEmpresa", tamanoEmpresa);
    return json;
}
}