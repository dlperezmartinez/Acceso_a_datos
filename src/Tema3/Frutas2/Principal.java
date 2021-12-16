package Tema3.Frutas2;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal {
    public static void main(String[] args) {
        final Path path = Paths.get("/home/nocend/IdeaProjects/Acceso_a_datos/src/Tema3/Frutas");
        final Path csv = path.resolve("frutas.csv");
        final Path csv2 = path.resolve("../Frutas2/frutas2.csv");
        try (
            final Stream<String> lines = Files.lines(csv);
            final PrintWriter pw = new PrintWriter(Files.newBufferedWriter(csv2, StandardOpenOption.CREATE_NEW))) {
                lines.map((line) -> line.split(" ")).
                map((line) -> Stream.of(line).collect(Collectors.joining(","))).
                forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
