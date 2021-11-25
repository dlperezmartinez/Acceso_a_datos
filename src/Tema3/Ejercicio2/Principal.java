package Tema3.Ejercicio2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Principal {
    //INSTANCIAS
    static ArrayList<String> lista = new ArrayList<>();
    static ArrayList<String> listaSplited = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String fileName = "/home/nocend/IdeaProjects/Acceso_a_datos/src/Tema3/Ejercicio2/ejercicio2.txt";
        FileReader fileReader = new FileReader(fileName);

        try (BufferedReader br = new BufferedReader(fileReader)) {
            String line;

            //Lectura de archivo
            while ((line = br.readLine()) != null) {
                lista.add(line);
            }

            //Spliteo de la lista en listaSplited
            for (String n : lista) {
                for (String i : n.split(" "))
                {
                    listaSplited.add(i);
                }
            }

            //Tratamiento de listaSplited
            for (String n : listaSplited) {
                if (n.matches("^[a-z]*")) {
                    System.out.println("Palabra: " + n);
                } else {
                    System.out.println("Numero: " + n);
                }
            }
        }
    }
}
