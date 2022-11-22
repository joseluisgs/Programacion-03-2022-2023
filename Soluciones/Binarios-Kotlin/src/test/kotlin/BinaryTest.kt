import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Assertions.assertAll


@DisplayName("Test de Binarios")
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Para el Beforeall
class BinaryTest {

    @BeforeAll
    fun setUp() {
        println("Before All")
    }
    @Test
    fun isBinaryTest() {
        // True siempre es igual a true :)
        val isBinary = "01011010"
        val notBinaryLetters = "aaaa"
        val notBinaryNumbers = "aaaa"
        assertAll(
            { assertTrue(isBinary(isBinary), "Caso Correcto") },
            { assertFalse(isBinary(notBinaryNumbers), "Caso Falso con Numeros") },
            { assertFalse(isBinary(notBinaryLetters), "Caso Falso con Letras") }
        );
    }

    @Test
    fun toIntVectorTest() {
        val binary = "01011010"
        val vector = intArrayOf(0, 1, 0, 1, 1, 0, 1, 0)
        assertArrayEquals(vector, toIntVector(binary))
    }

    @Test
    fun reverseTest() {
        val vector = intArrayOf(0, 1, 0, 1, 1, 0, 1, 1)
        val vectorReverse = intArrayOf(1, 1, 0, 1, 1, 0, 1, 0)
        assertArrayEquals(vectorReverse, reverse(vector))
    }

    @Test
    fun binaryToDecimalTest() {
        val binary = intArrayOf(1, 0, 0)
        val decimal = 4
        assertEquals(decimal, binaryToDecimal(binary))
    }

    @Test
    fun resizeTest() {
        val binary = intArrayOf(1, 1, 0)
        val max = 4
        val binaryResize = intArrayOf(0, 1, 1, 0)
        assertArrayEquals(binaryResize, resize(binary, max))
    }

    @Test
    fun addTest() {
        val num1 = intArrayOf(1, 1, 1)
        val num2 = intArrayOf(1, 0, 0, 1)
        val res = intArrayOf(1, 0, 0, 0, 0)
        assertArrayEquals(res, add(num1, num2))
    }

    @Test
    fun subtractTest() {
        val num1 = intArrayOf(1, 0, 0, 0)
        val num2 = intArrayOf(1, 1, 1)
        val res = intArrayOf(0, 0, 0, 1)
        assertArrayEquals(res, subtract(num1, num2))
    }

}