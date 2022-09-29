package es.educaand.evaluacion.actividad1;

import java.util.Random;

public final class DNIUtils {

  private static final Random RANDOM = new Random();

  /**
   * Represents the table char that the DNI algorithm follows
   * to generate the char.
   */
  private static final char[] CHAR_TABLE = new char[]{
      'T', 'R', 'W', 'A',
      'G', 'M', 'Y', 'F',
      'P', 'D', 'X', 'B',
      'N', 'J', 'Z', 'S',
      'Q', 'V', 'H', 'L',
      'C', 'K', 'E'
  };

  /**
   * Represents the digits that a DNI have.
   */
  private static final int DNI_DIGITS = 8;

  /**
   * Prevent from instantiating utility class.
   */
  private DNIUtils() {
  }

  public static String generateDNI() {
    int number = 0;
    for (int i = 0; i <= DNI_DIGITS; i++) {
      number += RANDOM.nextInt(10) * Math.pow(10, i);
    }

    final int mod = number % 23;
    return number + String.valueOf(CHAR_TABLE[mod]);
  }
}
