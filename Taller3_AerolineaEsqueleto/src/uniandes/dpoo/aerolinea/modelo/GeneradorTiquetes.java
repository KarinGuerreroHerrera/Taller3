package uniandes.dpoo.aerolinea.modelo;

import java.util.HashSet;
import java.util.Set;

public class GeneradorTiquetes {
    private Set<String> codigos = new HashSet<>();

    public Tiquete generarTiquete(Vuelo vuelo, Cliente cliente, int tarifa) {
        String codigo = generarCodigo();
        Tiquete tiquete = new Tiquete(codigo, vuelo, cliente, tarifa);
        registrarTiquete(tiquete);
        return tiquete;
    }

    private String generarCodigo() {
        String codigo = "TKT-" + (codigos.size() + 1);
        return codigo;
    }

    public void registrarTiquete(Tiquete unTiquete) {
        codigos.add(unTiquete.getCodigo());
    }

    public boolean validarTiquete(String codigoTiquete) {
        return codigos.contains(codigoTiquete);
    }
}