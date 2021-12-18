package Tema3.ManejoDeFicheros.uno;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FileManager fm = new FileManager();

        //VARIABLES
        String ruta;

        //Petición de la ruta
        System.out.print("Introduce la ruta -> ");
        try {
            fm.comprobarFichero(ruta = in.next());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
