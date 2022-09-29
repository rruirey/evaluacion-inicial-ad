package es.educaand.evaluacion.actividad1;

import es.educaand.evaluacion.actividad1.persona.Persona;
import es.educaand.evaluacion.actividad1.persona.PersonaData;
import es.educaand.evaluacion.actividad1.persona.PersonaManager;
import es.educaand.evaluacion.actividad1.util.DNIUtils;
import es.educaand.evaluacion.actividad1.util.EmailUtils;

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

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    PersonaManager manager = new PersonaManager();

    System.out.print("Introduce el numero de personas a generar: ");
    int total = scanner.nextInt();

    for (int i = 0; i < total; i++) {
      final String name = manager.randomDataFrom(PersonaData.NAME);
      final String surname = manager.randomDataFrom(PersonaData.SURNAME);
      final String dni = DNIUtils.generateDNI();
      final String email = EmailUtils.randomEmail(
          name,
          surname,
          dni
      );

      final Persona persona = new Persona(
          name,
          surname,
          dni,
          email,
          manager.randomDataFrom(PersonaData.CITY) + ", " + manager.randomDataFrom(PersonaData.ADDRESS),
          manager.randomDataFrom(PersonaData.POSTAL_CODE)
      );
      manager.createPersona(persona);
    }

    for (Persona persona : manager.getPersonas()) {
      System.out.println(persona);
    }
  }
}
