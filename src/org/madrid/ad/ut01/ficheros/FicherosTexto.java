package org.madrid.ad.ut01.ficheros;

import org.madrid.ad.ut01.ficheros.interfaces.InterfazFicherosTexto;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

/**
 * @author Escribe_aqui_tu_nombre
 * @date
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
                System.out.println((char) caracter);
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
