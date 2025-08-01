import org.junit.jupiter.api.*;

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
        Assertions.assertEquals("Ana", cliente.getNombre());
    }

    @Test
    void testSetTelefono() {
        cliente.setTelefono("699999999");
        Assertions.assertEquals("699999999", cliente.getTelefono());
    }

    @Test
    void testSetEmailInvalido() {
        cliente.setEmail("noescorreo");
        Assertions.assertNotEquals("noescorreo@email.com", cliente.getEmail());
    }
}
