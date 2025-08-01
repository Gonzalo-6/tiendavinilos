import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Ana", "12345678A", "600000000", "ana@email.com");
    }

    @AfterEach
    void tearDown() {
        cliente = null;
    }

    @Test
    void testGetNombre() {
        assertEquals("Ana", cliente.getNombre());
    }

    @Test
    void testSetTelefono() {
        cliente.setTelefono("699999999");
        assertEquals("699999999", cliente.getTelefono());
    }

    @Test
    void testSetEmailInvalido() {
        cliente.setEmail("noescorreo");
        assertNotEquals("noescorreo@email.com", cliente.getEmail());
    }
}
