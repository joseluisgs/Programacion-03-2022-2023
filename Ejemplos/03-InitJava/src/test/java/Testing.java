import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static es.joseluisgs.utils.Prueba.dividir;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Testing {


    @BeforeAll
    // cuidado con el static!!!
    static void initAll() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    void setUpTest() {
        System.out.println("setUpTest");
    }

    @Test
    public void trueIsTrue() {
        assertTrue(true);
    }

    @Test
    public void falseIsFalse() {
        assertEquals("Hola", "Hola");
    }

    @Test
    public void assertAllTest() {
        assertAll(
                () -> assertEquals("Hola", "Hola"),
                () -> assertEquals("Adios", "Adios")
        );
    }

    @Test
    public void testException() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            dividir(5, 0);
        });
        String expectedMessage = "No se puede dividir por 0";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

}
