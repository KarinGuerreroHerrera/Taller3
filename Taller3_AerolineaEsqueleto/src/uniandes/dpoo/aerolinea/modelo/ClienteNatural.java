package uniandes.dpoo.aerolinea.modelo;

public class ClienteNatural extends Cliente {
    public static final String NATURAL = "Natural";
    private String nombre;

    public ClienteNatural(String nombre) {
    	// TODO Auto-generated constructor stub
        this.nombre = nombre;
    }

    @Override
    public String getTipoCliente() {
        return NATURAL;
    }

    @Override
    public String getIdentificador() {
        return nombre;
    }
	}

