package com.cowboysmall.playful.math.v2;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class ObjectFileLoader {

    public Mesh loadFromObjectFile(String fileName) {

        List<String> lines = extracted("%s%s".formatted(System.getProperty("user.dir"), fileName));

        List<Vector4> vectors =
                lines.stream()
                        .map(line -> line.split(" "))
                        .filter(array -> array[0].equals("v"))
                        .map(array ->
                                new Vector4(
                                        parseDouble(array[1]),
                                        parseDouble(array[2]),
                                        parseDouble(array[3]))
                        )
                        .toList();

        List<Triangle> list =
                lines.stream()
                        .map(line -> line.split(" "))
                        .filter(array -> array[0].equals("f"))
                        .map(array ->
                                new Triangle(
                                        vectors.get(parseInt(array[1].split("/")[0]) - 1),
                                        vectors.get(parseInt(array[2].split("/")[0]) - 1),
                                        vectors.get(parseInt(array[3].split("/")[0]) - 1)
                                )
                        )
                        .toList();

        return new Mesh(list);
    }

    private static List<String> extracted(String filePath) {

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {

            return lines.toList();

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}
