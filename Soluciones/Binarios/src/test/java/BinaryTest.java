import es.dam.joseluisgs.Binary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test de Binarios")
public class BinaryTest {

    @Test
    public void isBinaryTest() {
        // True siempre es igual a true :)
        String isBinary = "01011010";
        String notBinaryLetters = "aaaa";
        String notBinaryNumbers = "aaaa";
        Assertions.assertAll(
                () -> assertTrue(Binary.isBinary(isBinary), "Caso Correcto"),
                () -> assertFalse(Binary.isBinary(notBinaryNumbers), "Caso Falso con Numeros"),
                () -> assertFalse(Binary.isBinary(notBinaryLetters), "Caso Falso con Letras")
        );
    }

    @Test
    public void toIntVectorTest() {
        String binary = "01011010";
        int[] vector = {0,1,0,1,1,0,1,0};
        assertArrayEquals(vector, Binary.toIntVector(binary));
    }

    @Test
    public void reverseTest() {
        int[] vector = {0,1,0,1,1,0,1,1};
        int[] vectorReverse = {1,1,0,1,1,0,1,0};
        assertArrayEquals(vectorReverse, Binary.reverse(vector));
    }

    @Test
    public void binaryToDecimalTest() {
        int[] binary = {1,0,0};
        int decimal = 4;
        assertEquals(decimal, Binary.binaryToDecimal(binary));
    }

    @Test
    public void resizeTest() {
        int[] binary = {1,1,0};
        int max = 4;
        int[] binaryResize = {0,1,1,0};

        assertArrayEquals(binaryResize, Binary.resize(binary, max));
    }

    @Test
    public void addTest() {
        int[] num1 = {1,1,1};
        int[] num2 = {1,0,0,1};
        int[] res = {1,0,0,0,0};

        assertArrayEquals(res, Binary.add(num1, num2));
    }

    @Test
    public void subtractTest() {
        int[] num1= {1,0,0,0};
        int[] num2= {1,1,1};
        int[] res = {0,0,0,1};

        assertArrayEquals(res, Binary.subtract(num1, num2));
    }

}
