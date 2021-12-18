package Tema3.ManejoDeFicheros.tres;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, CsvException {
        File restaurantscsv = new File("C:\\Users\\Nocen\\IdeaProjects\\Acceso_a_datos\\src\\Tema3\\ManejoDeFicheros\\tres\\Restaurants.csv");
        CSVWriter csvWriter = new CSVWriter(new FileWriter(restaurantscsv, true));

        csvWriter.writeNext(dataIntroduction(restaurantscsv));
        csvWriter.flush();
        csvWriter.close();
    }

    //He hecho un método por que mi idea era aprovecharlo para cualquier csv
    static String[] dataIntroduction(File file) throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(file));
        Scanner in = new Scanner(System.in);

        //Obtención de nCampos a escribir
        int nCampos = 5; //csvReader.readAll().get(0).length; //He intentado cambiarlo a un ArrayList pero
                                                        //me daba más problemas.
        String[] campos = new String[nCampos];
        //campos = csvReader.readNext();

        System.out.println("\n -DATA INTRODUCTION- \n");

        String[] dato = new String[nCampos];
        campos[0] = "Restaurant: ";
        campos[1] = "Address: ";
        campos[2] = "City: ";
        campos[3] = "State: ";
        campos[4] = "Zipcode: ";

        for (int i = 0; i < nCampos; i++) {
            System.out.print(campos[i]);

            dato[i] = in.nextLine();
        }

        in.close();

        return dato;
    }
}
