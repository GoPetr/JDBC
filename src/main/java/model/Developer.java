package model;

import java.io.Serializable;

public class Developer implements Serializable {
  private Long id;
  private String firstName;
  private String lastName;
  private Long skills;
  private Long specialty;

  Status status = Status.ACTIVE;

  public Developer() {
  }

  public Developer(String first_name) {
    this.firstName = first_name;
  }

  public Developer(String firstName, String lastName, Long skills, Long specialty) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.skills = skills;
    this.specialty = specialty;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Long getSkills() {
    return skills;
  }

  public void setSkills(Long skills) {
    this.skills = skills;
  }

  public Long getSpecialty() {
    return specialty;
  }

  public void setSpecialty(Long specialty) {
    this.specialty = specialty;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Developer{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", skills=" + skills + ", specialty=" + specialty + ", status=" + status + '}';
  }
}


