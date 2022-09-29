package es.educaand.evaluacion.actividad1;

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

public class Main {

  private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
  private static final Random RANDOM = new Random();

  private final List<Persona> personas = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    new Main().load();
  }

  public void load() throws Exception {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Introduce el numero de personas a generar: ");
    int total = scanner.nextInt();

    for (int i = 0; i < total; i++) {
      final String dni = DNIUtils.generateDNI();
      final String address = randomData(PersonaData.CITY) + ", " + randomData(PersonaData.ADDRESS);

      final Persona persona = new Persona(
          randomData(PersonaData.NAME),
          randomData(PersonaData.SURNAME),
          dni,
          randomData(PersonaData.EMAIL),
          address,
          randomData(PersonaData.POSTAL_CODE)
      );
      personas.add(persona);
    }

    for (Persona persona : personas) {
      System.out.println(persona);
    }
  }

  private String randomData(PersonaData data) throws Exception {
    final String fileName = data.getFileName();
    final URL url = getClass().getClassLoader().getResource(fileName);
    if (url == null) {
      throw new FileNotFoundException("Could not find provided file named " + fileName);
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
