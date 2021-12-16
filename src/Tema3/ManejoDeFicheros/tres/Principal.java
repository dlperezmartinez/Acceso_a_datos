package Tema3.ManejoDeFicheros.tres;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        System.out.println("\n -DATA INTRODUCTION- \n");

        try {
            FileWriter fw = new FileWriter("/home/nocend/IdeaProjects/Acceso_a_datos/src/Tema3/ManejoDeFicheros/dos/Restaurants.csv");
            fw.append("dasdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //He hecho un método por que mi idea era aprovecharlo para más cosas
    static String[] dataIntroduction() {
        Scanner in = new Scanner(System.in);

        String[] tipoDato = new String[5];
        String[] dato = new String[5];
        tipoDato[0] = "Restaurant: ";
        tipoDato[1] = "Address: ";
        tipoDato[2] = "City: ";
        tipoDato[3] = "State: ";
        tipoDato[4] = "Zipcode: ";

        for (int i = 0; i <= 4; i++) {
            System.out.print(tipoDato[i]);

            dato[i] = in.nextLine();
        }

        in.close();

        return dato;
    }
}
