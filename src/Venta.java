import java.util.ArrayList;
import java.io.Serializable;

public class Venta implements Serializable {
    /**
     * Represnta la venta de vinilos
     * autor Gonzalo-6
     * version 1.0
     */
    private Cliente cliente;
    private ArrayList<Vinilo> vinilos;
    private String fecha;

    public Venta(Cliente cliente, String fecha) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.vinilos = new ArrayList<>();
    }


    public void anadirVinilo(Vinilo vinilo) {
        vinilos.add(vinilo);
    }

    public double calcularTotal() {
        double total = 0;
        for (Vinilo v : vinilos) {
            total += v.getPrecio();
        }
        return total;
    }
    public ArrayList<Vinilo> getVinilos() {
        return vinilos;
    }

    @Override
    public String toString() {
        return "Venta a " + cliente.getNombre() + " el " + fecha + " - Total: " + calcularTotal() + "€";
    }

    public Cliente getCliente() { return cliente; }
}



