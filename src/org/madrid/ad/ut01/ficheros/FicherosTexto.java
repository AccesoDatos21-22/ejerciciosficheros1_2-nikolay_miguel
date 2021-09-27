package org.madrid.ad.ut01.ficheros;

import org.madrid.ad.ut01.ficheros.interfaces.InterfazFicherosTexto;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 * @author Miguel Y Nikolay
 * @date 
 * @version 64a7a45e0c092887834f1f77c5694830455e47cd
 * @license GPLv3
 */
public class FicherosTexto implements InterfazFicherosTexto {

    @Override
    public void leer(String rutaFichero) {
        // TODO Auto-generated method stub
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(rutaFichero));
            int caracter = br.read();
            while (caracter != -1) {
                System.out.print((char) caracter);
                caracter = br.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	@Override
	public int contarCaracteres(String rutaFichero) {
		// TODO Auto-generated method stub
		//En este paso abro un try catch en el cual declaro la lectura del fichero
		try(FileReader fichero = new FileReader(rutaFichero);){

			//Declaro el siguiente contador para contabilizar el número de caracteres en el fichero el_quijote.txt
			int cont = 0;

			//Creo una variable de tipo int para guardar la lectura del primer caracter del fichero que es de tipo unicode
			int caracter = fichero.read();

			/*
			//Declaro un bucle while que le indico que tiene que dar vueltas hasta recibir el valor -1 el cual signifiaca que le fichero no tiene más caracteres
			while(caracter != -1){
				//Una vez que lee el primer caracter aumento el contador +1 y le digo al programa que lea el siguiente caracter
				cont++;
				caracter = fichero.read();
			}
			*/

			//En este paso he refactorizado el código anterior haciendo uso de la clase Character para poder indicar al programa que solo cuento los caracteres visibles
			while(caracter != -1){
				if(Character.isAlphabetic(caracter)) {
					cont++;
				}
				caracter = fichero.read();
			}

			//Por último imprimo el número de caracteres que he conseguido recopilar.
			System.out.println("El Quijote contiene " + cont + " caracteres.");
		} catch(Exception e){
			System.out.println(e.toString());
		}

		return 0;
	}

    @Override
    public int contarLineas(String rutaFichero) {
        BufferedReader br = null;
        int lineas = 0;
        try {
            br = new BufferedReader(new FileReader(rutaFichero));
            lineas = (int) br.lines().count();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return lineas;
        }
    }
	@Override
	public int contarPalabras(String rutaFichero) {
		// TODO Auto-generated method stub
		//En primer lugar declaro la lectura del fichero mediante un buffered reader
		try(BufferedReader fichero = new BufferedReader(new FileReader(new File(rutaFichero)));){
			//En este paso declaro la variable caracter la cual guarda el caracter leído por el programa de tipo unicode
			int caracter = fichero.read();

			//Declaro la variable palabra la cual va a contener cada palabra antes de meter la en el ArrayList
			String palabra = "";
			ArrayList <String> palabrasCompletas = new ArrayList<String>();

			//Declaro un bucle para poder identificar todas las palabras que se encuentran en el programa
			while(caracter != -1){
				//Compruebo si el caracter obtenido es una letra y en caso afirmativo lo concateno con la parte de la palabra que se encuentra en la variable
				if(Character.isLetter(caracter)){
					palabra += (char) caracter;
				} else {
					//En caso negativo significa que la palabra ya se a completado por lo cual guardo la palabra en el ArrayList y vacío la variable
					palabrasCompletas.add(palabra);
					palabra = "";
				}
				//Y por último antes de acabar con la vuelta le indico que tiene que leer el siguiente caracter
				caracter = fichero.read();
			}

			//Y para finalizar imprimo el número de palabras que contiene el texto que obtengo mediante las posiciones del ArrayList
			System.out.println("El Quijote contiene " + palabrasCompletas.size() + " palabras.");
		} catch(Exception e) {
			System.out.println(e.toString());
		}

		return 0;
	}
    @Override
    public int palabrasPentavocalica(String rutaFichero) {
        Scanner sc = null;
        String palabra = null;
        int a = 0, e = 0, i = 0, o = 0, u = 0, h = 0;
        try {
            sc = new Scanner(new File(rutaFichero));
            while (sc.hasNext()) {
                palabra = sc.next();
                palabra.toLowerCase();
                for (int j = 0; j < palabra.length(); j++) {
                    if (palabra.charAt(j) == 'a') {
                        a = 1;
                    } else if (palabra.charAt(j) == 'e') {
                        e = 1;
                    } else if (palabra.charAt(j) == 'i') {
                        i = 1;
                    } else if (palabra.charAt(j) == 'o') {
                        o = 1;
                    } else if (palabra.charAt(j) == 'u') {
                        u = 1;
                    }
                }
                if (a == 1 && e == 1 && i == 1 && o == 1 && u == 1) {
                    h++;
                }
                a = 0;
                e = 0;
                i = 0;
                o = 0;
                u = 0;
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return h;
    }
	@Override
	public int palabraMasLarga(String rutaFichero) {
		// TODO Auto-generated method stub
		//Primero declaro un bueffered reader con el cual voy a poder leer el fichero
		try(BufferedReader fichero = new BufferedReader(new FileReader(new File(rutaFichero)))){
			//Declaro la varible caracter la cual me sirve para guardar el valor unicode del primer caracter
			int caracter = fichero.read();

			//Declaro los dos siguientes string los cuales van a contener las palabras deseadas
			String palabraLarga = "";
			String palabra = "";

			while(caracter != -1){
				//En primer lugar le indico al programa que si el caracter leido es una letra que lo concatene con el contenido de la variable palabra
				if(Character.isLetter(caracter)){
					palabra += (char) caracter;
				} else {
					//En caso contrario comprueba si la nueva palabra es más larga que la que ya esta guardada en la varibale y en caso afirmativo asigna la nueva palabra a la variable
					if(palabraLarga.length() < palabra.length()){
						palabraLarga = palabra;
					}
					//Vacío la variable para poder guardar la siguiente palabra
					palabra = "";
				}
				//Indico al programa que tiene que leer el siguiente caracter
				caracter = fichero.read();
			}

			//Y por último imprimo la palabra más larga
			System.out.println("La palabra más larga es: " + palabraLarga);
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}
    @Override
    public int frecuenciaVocales(String rutaFichero) {
        BufferedReader br = null;
        int a, e, i, o, u;
        a = e = i = o = u = 0;
        try {
            br = new BufferedReader(new FileReader(rutaFichero));
            String linea = br.readLine();
            while (linea != null) {
                linea = linea.toLowerCase();
                for (int j = 0; j < linea.length(); j++) {
                    switch (linea.charAt(j)) {
                        case 'a':
                            a++;
                            break;
                        case 'e':
                            e++;
                            break;
                        case 'i':
                            i++;
                            break;
                        case 'o':
                            o++;
                            break;
                        case 'u':
                            u++;
                            break;
                    }
                }
                linea = br.readLine();
            }
            System.out.println("A: " + a);
            System.out.println("E: " + e);
            System.out.println("I: " + i);
            System.out.println("O: " + o);
            System.out.println("U: " + u);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return 1;
    }
	@Override
	public int frecuenciaLetras(String rutaFichero) {
		// TODO Auto-generated method stub
		//Primero declaro un bueffered reader con el cual voy a poder leer el fichero
		try(BufferedReader fichero = new BufferedReader(new FileReader(new File(rutaFichero)))){
			//En este paso asigno el primer caracter unicode a la variable numérica
			int caracter = fichero.read();

			//En este paso declaro todos los contadores para cada una de las letras del abecedario
			int contA = 0, contB = 0, contC = 0, contD = 0, contE = 0, contF = 0, contG = 0, contH = 0, contI = 0, contJ = 0, contK = 0, contL = 0, contM = 0, contN = 0, contÑ = 0, contO = 0, contP = 0, contQ = 0, contR = 0, contS = 0, contT = 0, contU = 0, contV = 0, contW = 0, contX = 0, contY = 0, contZ = 0;

			while(caracter != -1){
				//Convierto el caracter unicode a tipo char y lo paso a minúscula
				char letra = (char) caracter;
				letra = Character.toLowerCase(letra);

				//En este paso compruebo cual es la letra y en caso de que exista aumento su contador +1
				switch(letra){
					case 'a':
						contA++;
						break;
					case 'b':
						contB++;
						break;
					case 'c':
						contC++;
						break;
					case 'd':
						contD++;
						break;
					case 'e':
						contE++;
						break;
					case 'f':
						contF++;
						break;
					case 'g':
						contG++;
						break;
					case 'h':
						contH++;
						break;
					case 'i':
						contI++;
						break;
					case 'j':
						contJ++;
						break;
					case 'k':
						contK++;
						break;
					case 'l':
						contL++;
						break;
					case 'm':
						contM++;
						break;
					case 'n':
						contN++;
						break;
					case 'ñ':
						//Aun que haya convertido el archivo de el_quijote.txt a UTF-8 no me consigue identificar la "Ñ"
						contÑ++;
						break;
					case 'o':
						contO++;
						break;
					case 'p':
						contP++;
						break;
					case 'q':
						contQ++;
						break;
					case 'r':
						contR++;
						break;
					case 's':
						contS++;
						break;
					case 't':
						contT++;
						break;
					case 'u':
						contU++;
						break;
					case 'v':
						contV++;
						break;
					case 'w':
						contW++;
						break;
					case 'x':
						contX++;
						break;
					case 'y':
						contY++;
						break;
					case 'z':
						contZ++;
						break;
					default: ;
				}

				//En este paso le indico al programa que lea el siguiente caracter
				caracter = fichero.read();
			}

			//Y por último imprimo cada uan de las letras junto al número de veces que apaece en el texto
			System.out.println("a: " + contA + "\n" + "b: " + contB + "\n" + "c: " + contC + "\n" + "d: " + contD + "\n" + "e: " + contE + "\n" + "f: " + contF + "\n" + "g: " + contG + "\n" + "h: " + contH + "\n" + "i: " + contI + "\n" + "J: " + contJ + "\n" + "k: " + contK + "\n" + "l: " + contL + "\n" + "m: " + contM + "\n" + "n: " + contN + "\n" + "ñ: " + contÑ + "\n" + "o: " + contO + "\n" + "p: " + contP + "\n" + "q: " + contQ + "\n" + "r: " + contR + "\n" + "s: " + contS + "\n" + "t: " + contT + "\n" + "u: " + contU + "\n" + "v: " + contV + "\n" + "w: " + contW + "\n" + "x: " + contX + "\n" + "y: " + contY + "\n" + "z: " + contZ);
		} catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}


}
