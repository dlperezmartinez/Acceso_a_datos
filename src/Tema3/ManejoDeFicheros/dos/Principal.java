package Tema3.ManejoDeFicheros.dos;

import Tema3.ManejoDeFicheros.uno.FileManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Principal {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();

        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("C:\\Users\\Nocen\\IdeaProjects\\Acceso_a_datos\\src\\Tema3\\ManejoDeFicheros\\dos\\Restaurants.csv"));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (List<String> n : records){
            System.out.println(n);

            if (n.get(4).matches("^Z*")) {
                System.out.println(n);
            }

            for (String i : n) {
                if (i.matches("^*")) {
                    System.out.println(n);
                }
            }
        }
    }

    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
