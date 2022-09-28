package es.educaand.rruirey.evaluacion.actividad2;

public class Persona {

  private final String name;
  private final String surname;

  private final String nif;
  private String email;

  private String street;
  private String postalCode;

  public Persona(String name, String surname, String nif, String email, String street, String postalCode) {
    this.name = name;
    this.surname = surname;
    this.nif = nif;
    this.email = email;
    this.street = street;
    this.postalCode = postalCode;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getNif() {
    return nif;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  @Override
  public String toString() {
    return "Persona{" +
        "name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", nif='" + nif + '\'' +
        ", email='" + email + '\'' +
        ", street='" + street + '\'' +
        ", postalCode=" + postalCode +
        '}';
  }
}
