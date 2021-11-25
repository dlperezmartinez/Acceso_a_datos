package Tema3.Ejercicio1;

import java.io.*;

public class Principal {
    public static void main(String[] args) throws IOException {
        String fileName = "/home/nocend/IdeaProjects/Acceso_a_datos/src/Tema3/Ejercicio1/ejercicio1.txt";
        FileReader fileReader = new FileReader(fileName);

        try (BufferedReader br = new BufferedReader(fileReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
