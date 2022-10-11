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

    List<Persona> personas = manager.generate(total);
    personas.forEach(manager::createPersona);

    for (Persona persona : personas) {
      System.out.println(persona);
    }
  }
}
