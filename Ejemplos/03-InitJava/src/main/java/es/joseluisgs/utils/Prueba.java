package es.joseluisgs.utils;

public class Prueba {
    public static int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por 0");
        }
        return a / b;
    }
}
