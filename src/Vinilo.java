
import java.io.Serializable;
public class Vinilo implements Serializable {
    /**
     * Represnta el producto que vendemos
     * autor Gonzalo
     * version 1.0
     */
    private String titulo;
    private String artista;
    private double precio;
    private int stock;


    public Vinilo(String titulo, String artista, double precio, int stock) {
        this.titulo = titulo;
        this.artista = artista;
        this.precio = precio;
        this.stock = stock;
    }

    public String getTitulo() { return titulo; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public void reducirStock() { if (stock > 0) stock--; }

    @Override
    public String toString() {
        return "\"" + titulo + "\" de " + artista + " - " + precio + "€ - Stock: " + stock;
    }
}




