package es.educaand.evaluacion.actividad1.persona;

/**
 * References a data type with a file name.
 */
public enum PersonaData {

  NAME("names.csv"),
  SURNAME("surnames.csv"),
  CITY("cities.csv"),
  ADDRESS("addresses.csv"),
  POSTAL_CODE("postalcodes.csv");

  private final String fileName;

  PersonaData(String fileName) {
    this.fileName = fileName;
  }

  public String getFileName() {
    return fileName;
  }
}