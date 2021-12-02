package Tema2.EntregaPracticaClase23;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //INSTANCIAS
        Scanner in = new Scanner(System.in);

        File ruta;
        File f;

        while(true) {
            //RUTA
            System.out.print("Introduce la ruta -> ");
            ruta = new File(in.next());

            if (!ruta.exists()) {
                System.out.print("Ese directorio no existe. ¿Quieres crearlo? [Y/N] ->");
                String sino = in.next();

                if (sino.equals("Y") || sino.equals("y")) {
                    ruta.mkdir();
                    System.out.println("Direcotorio creado.");
                }

                if (sino.equals("N") || sino.equals("n")) {
                    System.out.println("Saliendo...");
                    break;
                }
            }

            //FICHERO
            System.out.print("Introduce el nombre del fichero -> ");
            f = new File(ruta + "/" + in.next());

            if (!f.exists()) {
                System.out.print("Ese fichero no existe. ¿Quieres crearlo? [Y/N] ->");
                String sino = in.next();

                if (sino.equals("Y") || sino.equals("y")) {
                    try {
                        f.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Direcotorio creado.");
                }

                if (sino.equals("N") || sino.equals("n")) {
                    System.out.println("Saliendo...");
                    break;
                }
            } else {
                System.out.println(f.getName() + " " + f.length() + " bytes");
            }
        }
    }
}
