package mosca;

import java.util.Scanner;

public class Mosca {
    public static void main(String[] args){
        System.out.println("La Mosca Vector");
        int numCasillas = 10;
        final int MOSCA = 1;

        int numIntentos = 5;

        numIntentos = getNumIntentos();


        // Pedir tamaño de Matriz
        numCasillas = pedirNumeroCasillas();

        // Crear la matriz
        int[][] casillas = new int[numCasillas][numCasillas];

        // Todas las casillas son 0 menos la de la mosca
        iniciarCasillas(casillas);

        // Situar la mosca en el vector
        situarMosca(casillas, MOSCA);
        imprimirCasillas(casillas);

        boolean estaMuerta = false;
        int[] posMosca = {0,0};

        do {
            // Pedirle la posición donde vas a dar un tortazo
            posMosca = posicionGolpear(casillas);

            // Anlizamos el Golpeo
            estaMuerta = analizarGolpeo(MOSCA, casillas, estaMuerta, posMosca);
            numIntentos --;
            System.out.println("Te quedan " + numIntentos + " intentos");
        } while(!estaMuerta && numIntentos>0);

        if (estaMuerta)
            System.out.println("¡Has cazado a la maldita mosca!");
        else
            System.out.println("¡Has perdido!");

        System.out.println("Estaba en: {"
                + (posMosca[0]+1) + ", "
                + (posMosca[1]+1) +
                "}");
        imprimirCasillas(casillas);

    }

    private static int getNumIntentos() {
        Scanner sc = new Scanner(System.in);
        int intentos = 0;

        do {
            System.out.println("Introduce el número de intentos máximos, mayor a 1");
            intentos = sc.nextInt() ;
        } while (intentos<1);

        return intentos;

    }

    private static boolean analizarGolpeo(int MOSCA, int[][] casillas, boolean estaMuerta, int[] posMosca) {
        // Logica del juego
        // Acertamos
        if(casillas[posMosca[0]][posMosca[1]] == MOSCA) {
            estaMuerta = true;

            // Analizamos los limites
        }
//        else {
//            // Eje X horizontal
//            boolean o = posMosca[0] != 0 && casillas[posMosca[0] -1][posMosca[1]]== MOSCA;
//            boolean e = posMosca[0] != casillas.length-1 && casillas[posMosca[0] +1][posMosca[1]]== MOSCA;
//            // Eje Y vertical
//            boolean n = posMosca[1] != 0 && casillas[posMosca[0]][posMosca[1]-1]== MOSCA;
//            boolean s = posMosca[1] != casillas.length-1 && casillas[posMosca[0]][posMosca[1]+1]== MOSCA;
//
//            // Diagonal superior izquierda
//            boolean no = posMosca[0] != 0 && posMosca[1] != 0 && casillas[posMosca[0]-1][posMosca[1]-1]== MOSCA;
//            // Diagonal superior derecha
//            boolean ne = posMosca[0] != 0 && posMosca[1] != casillas.length-1 && casillas[posMosca[0]-1][posMosca[1]+1]== MOSCA;
//            // Diagnal inferior izquierda
//            boolean so = posMosca[0] != casillas.length-1 && posMosca[1] != 0 && casillas[posMosca[0]+1][posMosca[1]-1]== MOSCA;
//            // Diagnal inferior derecha
//            boolean se = posMosca[0] != casillas.length-1 && posMosca[1] != casillas.length-1 && casillas[posMosca[0]+1][posMosca[1]+1]== MOSCA;
//
//            if(o || e || n || s || no || ne || so || se) {
//                // Revoloteamos
//                System.out.println("¡CASI!");
//                iniciarCasillas(casillas);
//                situarMosca(casillas, MOSCA);
//            }
//        }

        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if (posMosca[0] + i >=0 && posMosca[0] + i<casillas.length && posMosca[1]+j>=0 && posMosca[0]+j<casillas.length){
                    if (casillas[posMosca[0]+ i][posMosca[1] + j] == MOSCA) {
                        System.out.println("¡CASI!");
                        iniciarCasillas(casillas);
                        situarMosca(casillas, MOSCA);
                    }
                }
            }
        }

        if(!estaMuerta) {
            System.out.println("¡Has fallado!");
        }
        imprimirCasillas(casillas);
        return estaMuerta;
    }

    private static int[] posicionGolpear(int[][] casillas) {
        Scanner sc = new Scanner(System.in);
        int[] posMosca = {0,0};

        do {
            System.out.println("Introduce la posición de la Fila a atacar: ");
            posMosca[0] = sc.nextInt() -1;
            System.out.println("La posición Fila elegida es: " + (posMosca[0] +1));
        } while (posMosca[0]<0 || posMosca[0]>= casillas.length);

        do {
            System.out.println("Introduce la posición de la Columna a atacar: ");
            posMosca[1] = sc.nextInt() -1;
            System.out.println("La posición Columna elegida es: " + (posMosca[1] +1));
        } while (posMosca[1]<0 || posMosca[1]>= casillas.length);

        return (posMosca);
    }

    private static void situarMosca(int[][] casillas, int mosca) {

        int fila = getPosicion(casillas);
        int columna = getPosicion(casillas );

        casillas[fila][columna] = mosca;
    }

    private static int getPosicion(int[][] casillas) {
        int fila;
        do {
            fila = (int) (Math.random() * casillas.length);
            //System.out.println(s + (fila + 1));
        } while (fila < 0 || fila >= casillas.length);
        return fila;
    }

    private static void iniciarCasillas(int[][] casillas) {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
               casillas[i][j] = 0;
            }
        }
    }

    /**
     *
     * @return
     */
    private static int pedirNumeroCasillas() {
        Scanner sc = new Scanner(System.in);
        int numCasillas;
        do {
            System.out.println("Dime el número de casillas, siempre mayor a 5");
            numCasillas = sc.nextInt();
            System.out.println("Tamaño de vector es:" + numCasillas);
        } while (numCasillas<5);
        return numCasillas;
    }

    static void imprimirCasillas(int[][] casillas) {
        //System.out.print("{ ");
        for(int[] fila: casillas){
            System.out.print("{ ");
            for(int columna: fila){
                System.out.print(columna + " ");
            }
            System.out.println("} ");
        }
        //System.out.println("}");
    }
}
