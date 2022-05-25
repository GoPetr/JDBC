package model;

import java.io.Serializable;

public class Specialty implements Serializable {
  String specialty;

  public Specialty(){

  }

  public Specialty(String specialty) {
    this.specialty = specialty;
  }

  public String getSpecialty() {
    return specialty;
  }

  public void setSpecialty(String specialty) {
    this.specialty = specialty;
  }
}
