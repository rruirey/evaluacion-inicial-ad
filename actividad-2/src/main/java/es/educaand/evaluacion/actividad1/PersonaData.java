package es.educaand.evaluacion.actividad1;

public enum PersonaData {

  NAME("nombres.csv"),
  SURNAME("surnames.csv"),
  EMAIL("emails.csv"),
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