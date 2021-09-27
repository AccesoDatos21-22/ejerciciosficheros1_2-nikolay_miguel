package org.madrid.ad.ut01.ficheros;



public class Main {
	
	public static void main(String[] args) {
		//Ejercicio 3
		FicherosTexto ejer = new FicherosTexto();
		ejer.contarCaracteres(args[0]);
		ejer.contarPalabras(args[0]);
		ejer.palabraMasLarga(args[0]);
		ejer.frecuenciaLetras(args[0]);
	}

}
