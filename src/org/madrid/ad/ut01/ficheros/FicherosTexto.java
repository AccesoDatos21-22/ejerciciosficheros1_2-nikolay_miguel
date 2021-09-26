package org.madrid.ad.ut01.ficheros;

import org.madrid.ad.ut01.ficheros.interfaces.InterfazFicherosTexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        FileReader fr = null;
        try {
            fr = new FileReader(rutaFichero);
            int caracter = fr.read();
            while (caracter != -1) {
                System.out.println((char)caracter);
                caracter = fr.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (Exception e) {
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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int contarPalabras(String rutaFichero) {
        // TODO Auto-generated method stub
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
