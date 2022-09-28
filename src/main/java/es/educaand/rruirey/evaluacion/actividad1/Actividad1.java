package es.educaand.rruirey.evaluacion.actividad1;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class Actividad1 {

  private static final Logger LOGGER = Logger.getLogger(Actividad1.class.getName());

  public static void main(String[] args) {
    if (args.length == 0) {
      LOGGER.severe("You must provide a file name.");
      return;
    }

    final String filename = args[0];
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