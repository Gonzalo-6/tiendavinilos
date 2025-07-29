import java.io.Serializable;

public class Cliente implements Serializable {
    /**
     * Represnta los clientes que tiene la tienda
     * autor Gonzalo-6
     * version 1.0
     */

    private String nombre;
    private String dni;
    private String telefono;
    private String email;

    public Cliente(String nombre, String dni, String telefono, String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return nombre + " - DNI: " + dni + " - Tel: " + telefono + " - Email: " + email;
    }
}
