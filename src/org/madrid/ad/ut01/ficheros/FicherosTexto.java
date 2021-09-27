package org.madrid.ad.ut01.ficheros;

import org.madrid.ad.ut01.ficheros.interfaces.InterfazFicherosTexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 
 * @author Escribe_aqui_tu_nombre
 * @date 
 * @version 
 * @license GPLv3
 *
 */
public class FicherosTexto implements InterfazFicherosTexto{

	@Override
	public void leer(String rutaFichero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int contarCaracteres(String rutaFichero) {
		// TODO Auto-generated method stub
		try{
			int cont = 0;
			FileReader fichero = new FileReader(new File(rutaFichero));

			int finalizar = 0;

			/*
			while(fichero.read() != -1){
				finalizar++;
			}
			*/

			while(fichero.read() != -1){
				if(fichero.read() != ' ') {
					finalizar++;
				}
			}
			System.out.println("El quijote contiene " + finalizar + " caracteres");

			fichero.close();
		} catch(Exception e){
			System.out.println(e.toString());
		}

		return 0;
	}

	@Override
	public int contarLineas(String rutaFichero) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int contarPalabras(String rutaFichero) {
		// TODO Auto-generated method stub
		try{
			BufferedReader fichero = new BufferedReader(new FileReader(new File(rutaFichero)));

			int cont = 0;

			while(fichero.readLine() != null){
				String linea = fichero.readLine();
				String[] palabras = linea.split(" ");

				cont += palabras.length;
			}

			System.out.println("El quijote contiene " + cont + " palabras.");

			fichero.close();
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		return 0;
	}

	@Override
	public int palabrasPentavocalica(String rutaFichero) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int palabraMasLarga(String rutaFichero) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int frecuenciaVocales(String rutaFichero) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int frecuenciaLetras(String rutaFichero) {
		// TODO Auto-generated method stub
		return 0;
	}



}
