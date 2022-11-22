package es.joseluisgs;

import java.util.Arrays;
import java.util.Scanner;

import static es.joseluisgs.utils.Prueba.dividir;

public class Main {
    // Variable global
    private static final int SOY_GLOBAL = 0;


    public static void main(String[] args) {
        System.out.println("Hola Java!");
        System.out.println("args = " + Arrays.toString(args));

        // Var y val?
        var miVariable = "Hola";
        System.out.println("miVariable = " + miVariable);
        var edad = 10;
        int edad2 = 10;

        // val es final
        final var miVariable2 = "Hola";
        System.out.println("miVariable2 = " + miVariable2);
        final var edad3 = 10;
        // miVariable2 = "Adios";
        // edad3 = 20;

        // entradaSalidaConsola();

        // Como llamar a funciones
        // int res = sumar(5, 6);
        // System.out.println("res = " + res);

        // Condicionales
        // condicionales();

        // Bucles
        // bucles();

        // Arrays
        //arrays();

        // Strings
        // myStrings();

        // Regex
        // myRegex();

        // Excepciones y paquetes
        // miDivision();

        var cadena = """
                Hola
                Adios
                """;

        //castings();

        // igualdad e identidad
        // igualdadIdentidad();

        // modifiarVariable(34);

        // No existen valores por defecto, debo sobrecargar todo
        valorPorDefecto();
        valorPorDefecto(10);
        valorPorDefecto(10, true);

    }

    // en Kotlin
    // fun valorPorDefecto(num: Int = 0, b: Boolean = false) {

    // en Java debo sobrecargar todo
    private static void valorPorDefecto() {
        int num = 0;
        boolean valor = false;
        System.out.println("numero = " + num);
        System.out.println("valor = " + valor);
    }

    private static void valorPorDefecto(int num) {
        boolean valor = false;
        System.out.println("numero = " + num);
        System.out.println("valor = " + valor);
    }

    private static void valorPorDefecto(int num, boolean valor) {
        System.out.println("numero = " + num);
        System.out.println("valor = " + valor);
    }


    // aunque modifique el valor de la variable este no se refleja al pasar por valor
    private static void modifiarVariable(int num) {
        num = 10; // no se refleja en el valor de la variable al salir de la función
        System.out.println("num = " + num);
    }

    private static void igualdadIdentidad() {
        String nombre = "Pepe";
        String nombre2 = "Pepe";
        var nombre3 = nombre;

        // SOLO CON OBJETOS
        // Esto en Kotlin si es valido == compara la igualdad de los objetos (contenido es igual)
        // En kotlin tenemos el === es decir la identidad (referencia es igual), eso es == en Java
        if (nombre == nombre3) {
            System.out.println("Son identicos: misma referencia y mismo contenido es === en Kotlin");
        } else {
            System.out.println("Son diferentes");
        }

        if (nombre.equals(nombre2)) {
            System.out.println("Son iguales: misma mismo contenido es == en Kotlin");
        } else {
            System.out.println("Son diferentes");
        }

        // Con tipos primitivos
        int edad = 10;
        int edad2 = 10;
        int edad3 = edad;
        if (edad == edad2) {
            System.out.println("Son iguales: misma mismo contenido es == en Kotlin");
        } else {
            System.out.println("Son diferentes");
        }
        // Como averiguames esto?
        if (edad == edad3) {
            System.out.println("Son indenticos: misma referencia y mismo contenido es === en Kotlin");
        } else {
            System.out.println("Son diferentes");
        }
    }

    private static void castings() {
        float f = 1.234f;
        int i = (int) f;
        System.out.println("i = " + i);
        f = i; // Int to double?? Sí el casting es implícito

        String s = "1234";
        i = Integer.parseInt(s);
        System.out.println("i = " + i);
        f = Float.parseFloat(s);

        s = String.valueOf(i); // ""+ i;
        System.out.println("s = " + s);
        s = String.valueOf(f); // ""+ i;
        System.out.println("s = " + s);
    }

    private static void miDivision() {
        var res = dividir(5, 2);
        System.out.println("res = " + res);

        try {
            res = dividir(5, 0);
            System.out.println("res = " + res);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void myRegex() {
        var sc = new Scanner(System.in);
        var dniPattern = "[0-9]{8}[A-Z]"; // Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
        System.out.println("Dime tu DNI");
        var dni = sc.nextLine();
        if (dni.matches(dniPattern)) {
            System.out.println("DNI correcto");
        } else {
            System.out.println("DNI incorrecto");
        }


    }

    private static void myStrings() {
        String s = "Hola";
        String s2 = "Adios";
        var s3 = s + s2;
        System.out.println("s3 = " + s3);

    }

    private static void arrays() {
        int[] vector = new int[5];
        // Asigna valores
        vector[0] = 1;
        vector[1] = 2;
        vector[2] = 3;
        vector[3] = 4;
        vector[4] = 5;

        int[] v2 = {1, 2, 3, 4, 5};

        // Recorrer un array
        for (int i = 0; i < vector.length; i++) {
            System.out.println("vector[" + i + "] = " + vector[i]);
        }

        // hacia atrás
        for (int i = vector.length - 1; i >= 0; i--) {
            System.out.println("vector[" + i + "] = " + vector[i]);
        }

        // Recorrer un array con for each
        for (int elemento : vector) {
            System.out.println("valor = " + elemento);
        }

        int[][] matriz = new int[3][3];
        // Inicio con valores aleatorios
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * 10);
            }
        }

        // Recorrer una matriz a
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // Solo si no necesitáis el índice
        for (int[] ints : matriz) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }

    private static void bucles() {
        // while
        int i = 0;
        while (i < 10) {
            System.out.println("i = " + i);
            i++;
        }

        // do while
        int j = 0;
        do {
            System.out.println("j = " + j);
            j++;
        } while (j < 10);

        // for
        for (int k = 0; k < 10; k++) {
            System.out.println("k = " + k);
        }

        // for each
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int numero : numeros) {
            System.out.println("numero = " + numero);
        }
    }

    private static void condicionales() {
        int a = 5;
        int b = 6;

        // if else if
        if (a > b) {
            System.out.println("a es mayor que b");
        } else if (a < b) {
            System.out.println("a es menor que b");
        } else {
            System.out.println("a es igual que b");
        }

        // switch
        int c = 3;
        switch (c) {
            case 1 -> {
                System.out.println("c es 1");
                System.out.println("Si pongo varias lineas de código");
                break;
            }
            case 2 -> System.out.println("c es 2");
            case 3 -> System.out.println("c es 3");
            default -> System.out.println("c es otro valor");
        }

        // Operador ternario
        int res = (a > b) ? a : b;
        System.out.println("res = " + res);

    }

    private static int sumar(int a, int b) {
        return a + b;
    }

    private static void entradaSalidaConsola() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime tu nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Hola " + nombre);
        boolean salir = false;
        do {
            try {
                System.out.println("Dime tu edad: ");
                int edad = sc.nextInt();
                System.out.println("Tu edad es " + edad);
                salir = true;
            } catch (Exception e) {
                System.out.println("Error, no has introducido un número");
            } finally {
                sc.nextLine();
            }
        } while (!salir);

    }
}