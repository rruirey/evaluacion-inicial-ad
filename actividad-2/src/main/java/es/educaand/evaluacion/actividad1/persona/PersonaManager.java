package es.educaand.evaluacion.actividad1.persona;

import es.educaand.evaluacion.actividad1.util.DNIUtils;
import es.educaand.evaluacion.actividad1.util.EmailUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class PersonaManager {

  private static final Random RANDOM = new Random();
  private final Set<Persona> personas = new HashSet<>();

  /**
   * Stores a person in our registry to mantain
   * the life cycle of the {@link Persona} instance.
   *
   * @param persona the persona to store in our registry.
   */
  public void createPersona(Persona persona) {
    personas.add(persona);
  }

  /**
   * Generates given {@code number} amount of {@link Persona}
   *
   * @param number - the number of personas to generate.
   * @return a list of generated personas.
   * @throws FileNotFoundException - when random data accessor could not find its file.
   */
  public List<Persona> generate(int number) throws FileNotFoundException {
    final List<Persona> personas = new ArrayList<>(number);
    for (int i = 0; i < number; i++) {
      final String name = randomDataFrom(PersonaData.NAME);
      final String surname = randomDataFrom(PersonaData.SURNAME);
      final String dni = DNIUtils.generateDNI();
      personas.add(new Persona(
          name,
          surname,
          dni,
          EmailUtils.randomEmail(
              name,
              surname,
              dni
          ),
          randomDataFrom(PersonaData.CITY) + ", " + randomDataFrom(PersonaData.ADDRESS),
          randomDataFrom(PersonaData.POSTAL_CODE)
      ));
    }
    return personas;
  }

  /**
   * Reads a random value by given {@link PersonaData}
   * that contains a file name, where a random line
   * gets selected.
   *
   * @param data - the data to read from.
   * @return a random value by given person data.
   * @throws FileNotFoundException - if given person data file does not exists.
   */
  public String randomDataFrom(PersonaData data) throws FileNotFoundException {
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

  /**
   * Retrieves an immutable set containing
   * all the persons previously registered.
   *
   * @return an immutable set with all the persons.
   */
  public Set<Persona> getPersonas() {
    return Collections.unmodifiableSet(personas);
  }
}
