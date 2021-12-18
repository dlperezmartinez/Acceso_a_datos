package Tema3.ManejoDeFicheros.cuatro;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Principal {
    public static void main(String[] args) throws IOException {
        File restaurantscsv = new File("C:\\Users\\Nocen\\IdeaProjects\\Acceso_a_datos\\src\\Tema3\\ManejoDeFicheros\\dos\\Restaurants.csv");
        File rutaDestino = new File("C:\\Users\\Nocen\\IdeaProjects\\Acceso_a_datos\\src\\Tema3\\ManejoDeFicheros\\cuatro\\Restaurants2.csv");
        BufferedReader fileReader = new BufferedReader(new FileReader(restaurantscsv));
        FileWriter fileWriter = new FileWriter(rutaDestino, true);
        ArrayList<String[]> lineas = new ArrayList<>();
        String linea;

        while ((linea = fileReader.readLine()) != null)
        {
            String[] campos = linea.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)"); //Regex fusilado
            if(!campos[4].matches("^6.*")) {
                fileWriter.write(Arrays.toString(campos) + "\n");
            }
        }

        fileWriter.flush();
        fileWriter.close();
    }
}
