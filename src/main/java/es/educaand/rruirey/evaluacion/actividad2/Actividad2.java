package es.educaand.rruirey.evaluacion.actividad2;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Actividad2 {

  private static final Logger LOGGER = Logger.getLogger(Actividad2.class.getName());
  private static final Random RANDOM = new Random();

  private final List<Persona> personas = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      LOGGER.severe("You must provide a file name.");
      return;
    }

    new Actividad2().load();
  }

  public void load() throws Exception {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Introduce el numero de personas a generar: ");
    int total = scanner.nextInt();

    for (int i = 0; i < total; i++) {
      personas.add(
          new Persona(
              randomData(PersonaData.NAME),
              randomData(PersonaData.SURNAME),
              DNIUtils.generateDNI(),
              randomData(PersonaData.EMAIL),
              randomData(PersonaData.CITY) + ", " + randomData(PersonaData.ADDRESS),
              randomData(PersonaData.POSTAL_CODE)
          )
      );
    }

    for (Persona persona : personas) {
      System.out.println(persona);
    }
  }

  private String randomData(PersonaData data) throws Exception {
    final URL url = getClass().getClassLoader().getResource(data.getFileName());
    if (url == null) {
      throw new FileNotFoundException("Could not find provided file");
    }

    Supplier<Stream<String>> supplier = () -> {
      try {
        return Files.lines(
            Paths.get(url.toURI())
        );
      } catch (IOException | URISyntaxException e) {
        throw new RuntimeException(e);
      }
    };

    int total = (int) supplier.get().count();
    int selected = RANDOM.nextInt(total + 1);

    return supplier.get()
        .skip(selected)
        .findFirst()
        .orElse("not found");
  }
}
