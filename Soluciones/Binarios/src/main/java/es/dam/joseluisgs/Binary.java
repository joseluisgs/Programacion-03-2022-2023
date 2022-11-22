package es.dam.joseluisgs;

import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        System.out.println("Números Binarios");

        // Leemos un número binario y lo transformamos a vector de enteros
        // importante ver como una operación la he ido descomponiendo en pasos
        //int[] binary = readBinary();
        //System.out.print("Binary: ");
        //printBinary(binary);

        // Pasamos a decimal
        //int dec = binaryToDecimal(binary);
        //System.out.println("Decimal: " + dec);

        // A partir de aquí voy a usar dos numeros para no meterlos siempre
        int[] num1 = {1,1,1};
        int[] num2 = {1,0,0,0};

        // Vamos a sumar
        System.out.print("num1: ");
        printBinary(num1);
        System.out.print("num2: ");
        printBinary(num2);
        System.out.print("Suma: ");
        int[] sum = add(num1, num2);
        printBinary(sum);

        int [] sub = subtract(num2, num1);
        System.out.print("Resta: ");
        printBinary(sub);

    }

    public static int[] add(int[] num1, int[] num2) {
        // Debemos tener el mismo tamaño
        int max = Math.max(num1.length, num2.length);
        // con el ternario
        //int max = num1.length > num2.length ? num1.length : num2.length;

        // Ahora los dos vectores deben tener el mismo tamaño
        if (num1.length < num2.length)
            num1 = resize(num1, max);
        else
            num2 = resize(num2, max);

//        printBinary(num1);
//        printBinary(num2);

        // Ahora los sumamos, es uno mas para el acarreo
        int[] res = new int[max+1];
        int carry = 0;
        // Lo voy a hacer sin invertir
        int j = max;
        for (int i = num1.length -1; i>=0; i--) {
            // sumamos el carry y el elemento de la posición i
            int sum = num1[i] + num2[i] + carry;
            // si la suma es mayor que 1, el carry es 1
            carry = sum > 1 ? 1 : 0;
            // el resto es el resultado, porque el módulo es 1 o 2
            res[j] = sum % 2;
            j--;
        }
        // si el carry es 1, lo metemos al final (o posición 0)
        if(carry == 1) {
            res[0] = 1;
        }

//        printBinary(res);

        return res;

    }

    public static int[] subtract(int[] num1, int[] num2) {
        // Debemos tener el mismo tamaño
        int max = Math.max(num1.length, num2.length);
        // con el ternario
        //int max = num1.length > num2.length ? num1.length : num2.length;

        // Ahora los dos vectores deben tener el mismo tamaño
        if (num1.length < num2.length)
            num1 = resize(num1, max);
        else
            num2 = resize(num2, max);

//        printBinary(num1);
//        printBinary(num2);

        // Ahora los restamos, el tamaño siempre es el del mayor
        int[] res = new int[max];
        int carry = 0;
        // Lo voy a hacer sin invertir
        int j = max-1;
        for (int i = num1.length -1; i>=0; i--) {
            // restamos el carry y el elemento de la posición i
            int sum = num1[i] - num2[i] - carry;
            // si la resta es menor que 0, el carry es 1
            carry = sum < 0 ? 1 : 0;
            res[j] = Math.abs(sum % 2);
            j--;
        }
//        printBinary(res);
        return res;

    }

    public static int[] resize(int[] num, int max) {
        int[] res = new int[max];
        // lo coloco de atras adelante, los 0 que añado se quedan al comienzo
        int j = max - 1;
        for (int i = num.length -1 ; i >= 0; i--) {
            res[j] = num[i];
            j--;
        }
        return res;
    }

    public static int binaryToDecimal(int[] num) {
        // Tal y como hemos visto en clase hay que hacerle un reverse
//        int[] numReverse = reverse(num);
//        int res = 0;
//        for (int i = 0; i < numReverse.length; i++) {
//            // cada elemento lo multiplicamos por 2 elevado a la potencia
//            // de su posición
//            res += numReverse[i] * Math.pow(2, i);
//        }
        // sin invertir
        int res = 0;
        for (int i = num.length -1; i>= 0; i--) {
            res += num[i]*Math.pow(2,num.length-i-1);
        }

        return res;
    }

    public static int[] reverse(int[] num) {
        int[] res = new int[num.length];
        // invertimos el vector
        for (int i = 0; i < num.length; i++) {
            res[i] = num[num.length - 1 - i];
        }
        return res;
    }

    public static int[] readBinary() {
        Scanner in = new Scanner(System.in);
        String line;
        // Leemos un número y solo debe tener 0s y 1s
        do {
            System.out.println("Intrdouzca el número binario: ");
            line = in.nextLine();
        } while(!isBinary(line));

        // Ahora los tranformamos a vector de enteros
        return toIntVector(line);
    }

    public static int[] toIntVector(String line) {
        int[] res = new int[line.length()];
        for (int i = 0; i < res.length; i++) {
            // cada caracter lo tengo que pasar a entero
            res[i] = Character.getNumericValue(line.charAt(i));
        }
        return res;
    }

    public static boolean isBinary(String line) {
        boolean isBinary = true;
        for (int i = 0; i < line.length() && isBinary; i++) {
            isBinary = line.charAt(i) == '0' || line.charAt(i) == '1';
        }
        return isBinary;
    }

    public static void printBinary(int[] binary) {
        for (int i: binary) {
            System.out.print(i);
        }
        System.out.println();
    }
}
