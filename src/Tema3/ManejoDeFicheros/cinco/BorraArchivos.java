package Tema3.ManejoDeFicheros.cinco;

import java.io.File;
import java.util.Scanner;

public class BorraArchivos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        File file;
        String ruta;

        //Petición de la ruta
        System.out.print("Introduce la ruta -> ");
        file = new File(ruta = in.nextLine());

        if (!file.exists()) {
            System.out.println("Archivo no encontrado.");
        } else {
            System.out.print("Fichero encontrado. ¿Quieres eliminarlo? [Y/N] -> ");
            String sino = in.nextLine();

            if (sino.equals("Y") || sino.equals("y")) {
                file.delete(); //Borra el archivo
                System.out.println("Fichero eliminado.");
            }

            if (sino.equals("N") || sino.equals("n")) {
                System.out.println("Fichero NO eliminado.");
            }
        }
    }
}
