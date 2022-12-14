package es.educaand.evaluacion.actividad1.util;

import java.util.Random;

public final class EmailUtils {

  private static final Random RANDOM = new Random();
  private static final String[] EMAIL_DOMAINS = new String[]{
      "gmail.com", "outlook.com", "yahoo.es"
  };

  /**
   * Prevent from instantiating utility class.
   */
  private EmailUtils() {
  }

  /**
   * Retrieves a random email by given name, surname and dni
   * which the first 3 chars are taken to generate the email.
   *
   * @param name    - the name of the person
   * @param surname - the surname of the person.
   * @param dni     - the DNI of the person
   * @return a random email generated by given parameters.
   */
  public static String randomEmail(String name, String surname, String dni) {
    return (substring(name, 3) +
        substring(surname, 3) +
        substring(dni, 3) +
        EMAIL_DOMAINS[RANDOM.nextInt(EMAIL_DOMAINS.length)]
    ).toLowerCase();
  }

  private static String substring(String value, int index) {
    return value.substring(0, Math.min(index, value.length()));
  }
}
