package org.madrid.ad.ut01.ficheros;

public class Main {

    public static void main(String[] args) {
        FicherosTexto ejer = new FicherosTexto();
        String rutaFichero = "src/org/madrid/ad/ut01/ficheros/assets/el_quijote.txt";
        System.out.println("-EJERCICIO 1 Y 2-");
        ejer.leer(rutaFichero);
        System.out.println("-EJERCICIO 3 Y 4-");
        ejer.contarCaracteres(rutaFichero);
        System.out.println("-EJERCICIO 5-");
        System.out.println("Lineas: " + ejer.contarLineas(rutaFichero));
        System.out.println("-EJERCICIO 6-");
        ejer.contarPalabras(rutaFichero);
        System.out.println("-EJERCICIO 7-");
        System.out.println("Palabras pentavocalicas: " + ejer.palabrasPentavocalica(rutaFichero));
        System.out.println("-EJERCICIO 8-");
        ejer.palabraMasLarga(rutaFichero);
        System.out.println("-EJERCICIO 9-");
        ejer.frecuenciaVocales(rutaFichero);
        System.out.println("-EJERCICIO 10-");
        ejer.frecuenciaLetras(rutaFichero);
    }

}
