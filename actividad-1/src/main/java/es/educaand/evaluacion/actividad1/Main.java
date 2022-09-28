package es.educaand.evaluacion.actividad1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

  private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    if (args.length == 0) {
      LOGGER.severe("You must provide a file name.");
      return;
    }

    new Main().load(args[0]);
  }

  public void load(String filename) {
    final PrintWriter writer;
    try {
      writer = new PrintWriter(
          new FileWriter(
              filename,
              true
          )
      );
    } catch (IOException e) {
      LOGGER.severe("Could not create writer stream. error = " + e.getMessage());
      return;
    }

    System.out.println("Introduce el texto que quieras introducir en el fichero " + filename + ":");

    final Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
      final String line = scanner.nextLine();
      if (line.equalsIgnoreCase("exit")) {
        break;
      }

      writer.println(line);
      System.out.println("Escribe 'exit' para salir.");
    }

    writer.close();
    scanner.close();

    System.out.println("Se ha guardado todo en el fichero " + filename + ".");
  }
}