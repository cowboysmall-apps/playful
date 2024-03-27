package com.cowboysmall.playful.assets;

import com.cowboysmall.playful.graphics.Mesh;
import com.cowboysmall.playful.graphics.Triangle;
import com.cowboysmall.playful.math.v1.Vector4D;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class ObjectFileLoader {

    public Mesh loadFromObjectFile(String fileName) {

//        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(fileName);

        String filePath = System.getProperty("user.dir") + fileName;

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {

            List<Vector4D> v =
                    stream.map(line -> line.split(" "))
                            .filter(array -> array[0].equals("v"))
                            .map(array -> new Vector4D(parseDouble(array[1]), parseDouble(array[2]), parseDouble(array[3])))
                            .collect(Collectors.toList());

            try (Stream<String> stream2 = Files.lines(Paths.get(filePath))) {

                List<Triangle> f =
                        stream2.map(line -> line.split(" "))
                                .filter(array -> array[0].equals("f"))
                                .map(array ->
                                        new Triangle(
                                                v.get(parseInt(array[1].split("/")[0]) - 1),
                                                v.get(parseInt(array[2].split("/")[0]) - 1),
                                                v.get(parseInt(array[3].split("/")[0]) - 1)
                                        )
                                )
                                .collect(Collectors.toList());

                return new Mesh(f);

            } catch (Exception e) {

                throw new RuntimeException(e);
            }

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}
