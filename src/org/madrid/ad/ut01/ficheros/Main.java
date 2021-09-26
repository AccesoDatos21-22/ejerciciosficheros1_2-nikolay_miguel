package org.madrid.ad.ut01.ficheros;



public class Main {
	
	public static void main(String[] args) {
		FicherosTexto ft = new FicherosTexto();
		//ft.leer("bin/org/madrid/ad/ut01/ficheros/assets/el_quijote.txt");
		System.out.println("Lineas: "+ft.contarLineas("bin/org/madrid/ad/ut01/ficheros/assets/el_quijote.txt"));

	}

}
