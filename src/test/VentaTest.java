import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


public class VentaTest {

    Cliente cliente;
    Venta venta;
    Vinilo vinilo;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Juan", "87654321B", "611111111", "juan@mail.com");
        venta = new Venta(cliente, "29/07/2025");
        vinilo = new Vinilo("Thriller", "Michael Jackson", 20.0, 5);
    }

    @AfterEach
    void tearDown() {
        cliente = null;
        venta = null;
        vinilo = null;
    }

    @Test
    void testAñadirVinilo() {
        venta.añadirVinilo(vinilo);
        List<Vinilo> lista = venta.getVinilos();
        assertTrue(lista.contains(vinilo));
    }

    @Test
    void testCalcularTotal() {
        venta.añadirVinilo(vinilo);
        venta.añadirVinilo(vinilo);
        assertEquals(40.0, venta.calcularTotal());
    }
}
