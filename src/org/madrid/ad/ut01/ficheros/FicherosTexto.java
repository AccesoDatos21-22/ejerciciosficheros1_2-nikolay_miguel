package org.madrid.ad.ut01.ficheros;

import org.madrid.ad.ut01.ficheros.interfaces.InterfazFicherosTexto;

import java.io.*;
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
            int caracter=br.read();
            while(caracter!=-1){
                System.out.println((char)caracter);
                caracter=br.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(br!=null) br.close();
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
