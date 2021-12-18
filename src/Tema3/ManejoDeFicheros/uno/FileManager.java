package Tema3.ManejoDeFicheros.uno;

import java.io.File;
import java.io.FileNotFoundException;

public class FileManager {
    private File ruta;

    //MÉTODOS
    void comprobarFichero(String in) throws FileNotFoundException {
        ruta = new File(in);
        String read = "-";
        String write = "-";
        String execute = "-";

        //COMPROBACIÓN existencia del fichero
        if (!ruta.exists()) {
            throw new FileNotFoundException("Fichero no encontrado.");
        } else {
            //COMPROBACIÓN es directorio
            if (ruta.isDirectory()) {
                System.out.println("DIRECTORIO encontrado.");
            } else { //Es ARCHIVO

                //COMPROBACIÓN permisos
                if (ruta.canRead()) {read = "r";}
                if (ruta.canWrite()) {write = "w";}
                if (ruta.canExecute()) {execute = "x";}

                System.out.println(read + write + execute + " " + ruta.getName() + " " + ruta.length() + " bytes");

            }
        }
    }
}
