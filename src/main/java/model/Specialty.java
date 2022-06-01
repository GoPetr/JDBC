package model;

import java.io.Serializable;

public class Specialty implements Serializable {
  private Long id;
  private String specialty;

  public Specialty() {
  }

  public Specialty(String specialty) {
    this.specialty = specialty;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSpecialty() {
    return specialty;
  }

  public void setSpecialty(String specialty) {
    this.specialty = specialty;
  }
}
