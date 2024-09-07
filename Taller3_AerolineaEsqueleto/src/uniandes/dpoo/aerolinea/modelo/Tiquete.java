package uniandes.dpoo.aerolinea.modelo;

public class Tiquete {
    private String codigo;
    private Vuelo vuelo;
    private Cliente clienteComprador;
    private int tarifa;
    private boolean usado;

    public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) {
    	// TODO Auto-generated constructor stub
        this.codigo = codigo;
        this.vuelo = vuelo;
        this.clienteComprador = clienteComprador;
        this.tarifa = tarifa;
        this.usado = false;
    }

    public Cliente getCliente() {
        return clienteComprador;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void marcarComoUsado() {
        this.usado = true;
    }

    public boolean esUsado() {
        return usado;
    }

}
