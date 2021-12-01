package Tema3.ManejoDeFicheros.dos;

import Tema3.ManejoDeFicheros.uno.FileManager;

import java.io.FileReader;

public class Principal {
    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        FileManager fileManager = new FileManager();

        csvReader.getCssText(new FileReader());
    }
}
