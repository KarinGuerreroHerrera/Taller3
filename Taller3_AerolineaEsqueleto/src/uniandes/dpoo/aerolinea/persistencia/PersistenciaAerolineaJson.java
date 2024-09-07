package uniandes.dpoo.aerolinea.persistencia;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONTokener;
import uniandes.dpoo.aerolinea.modelo.Aerolinea; 
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Avion;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea {

    @Override
    public void cargarAerolinea(String archivo, Aerolinea aerolinea) {
        try (FileReader reader = new FileReader(archivo)) {
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject jsonAerolinea = new JSONObject(tokener);

            JSONArray jsonAviones = jsonAerolinea.getJSONArray("aviones");
            for (int i = 0; i < jsonAviones.length(); i++) {
                JSONObject jsonAvion = jsonAviones.getJSONObject(i);
                Avion avion = new Avion();
                avion.setModelo(jsonAvion.getString("modelo"));
                avion.setCapacidad(jsonAvion.getInt("capacidad"));
                aerolinea.addAvion(avion);
            }

            JSONArray jsonAeropuertos = jsonAerolinea.getJSONArray("aeropuertos");
            for (int i = 0; i < jsonAeropuertos.length(); i++) {
                JSONObject jsonAeropuerto = jsonAeropuertos.getJSONObject(i);
                Aeropuerto aeropuerto = new Aeropuerto();
                aeropuerto.setNombre(jsonAeropuerto.getString("nombre"));
                aeropuerto.setCiudad(jsonAeropuerto.getString("ciudad"));
                aerolinea.addAeropuerto(aeropuerto);
            }

            JSONArray jsonRutas = jsonAerolinea.getJSONArray("rutas");
            for (int i = 0; i < jsonRutas.length(); i++) {
                JSONObject jsonRuta = jsonRutas.getJSONObject(i);
                Ruta ruta = new Ruta();
                ruta.setCodigo(jsonRuta.getString("codigo"));
                ruta.setOrigen(jsonRuta.getString("origen"));
                ruta.setDestino(jsonRuta.getString("destino"));
                aerolinea.addRuta(ruta);
            }

            JSONArray jsonVuelos = jsonAerolinea.getJSONArray("vuelos");
            for (int i = 0; i < jsonVuelos.length(); i++) {
                JSONObject jsonVuelo = jsonVuelos.getJSONObject(i);
                Vuelo vuelo = new Vuelo();
                vuelo.setCodigo(jsonVuelo.getString("codigo"));
                vuelo.setRuta(jsonVuelo.getString("ruta"));
                vuelo.setFecha(jsonVuelo.getString("fecha"));
                aerolinea.addVuelo(vuelo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvarAerolinea(String archivo, Aerolinea aerolinea) {
        try (FileWriter writer = new FileWriter(archivo)) {
            JSONObject jsonAerolinea = new JSONObject();

            JSONArray jsonAviones = new JSONArray();
            for (Avion avion : aerolinea.getAviones()) {
                JSONObject jsonAvion = new JSONObject();
                jsonAvion.put("modelo", avion.getModelo());
                jsonAvion.put("capacidad", avion.getCapacidad());
                jsonAviones.put(jsonAvion);
            }
            jsonAerolinea.put("aviones", jsonAviones);

            JSONArray jsonAeropuertos = new JSONArray();
            for (Aeropuerto aeropuerto : aerolinea.getAeropuertos()) {
                JSONObject jsonAeropuerto = new JSONObject();
                jsonAeropuerto.put("nombre", aeropuerto.getNombre());
                jsonAeropuerto.put("ciudad", aeropuerto.getCiudad());
                jsonAeropuertos.put(jsonAeropuerto);
            }
            jsonAerolinea.put("aeropuertos", jsonAeropuertos);

            JSONArray jsonRutas = new JSONArray();
            for (Ruta ruta : aerolinea.getRutas()) {
                JSONObject jsonRuta = new JSONObject();
                jsonRuta.put("codigo", ruta.getCodigo());
                jsonRuta.put("origen", ruta.getOrigen());
                jsonRuta.put("destino", ruta.getDestino());
                jsonRutas.put(jsonRuta);
            }
            jsonAerolinea.put("rutas", jsonRutas);

            JSONArray jsonVuelos = new JSONArray();
            for (Vuelo vuelo : aerolinea.getVuelos()) {
                JSONObject jsonVuelo = new JSONObject();
                jsonVuelo.put("codigo", vuelo.getCodigo());
                jsonVuelo.put("ruta", vuelo.getRuta());
                jsonVuelo.put("fecha", vuelo.getFecha());
                jsonVuelos.put(jsonVuelo);
            }
            jsonAerolinea.put("vuelos", jsonVuelos);

            writer.write(jsonAerolinea.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
