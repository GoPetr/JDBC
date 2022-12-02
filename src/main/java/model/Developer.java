package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Developer implements Serializable {
  private Long id;
  private String firstName;
  private String lastName;
  private List<Skill> skills;
  private Specialty specialty;

  Status  status = Status.ACTIVE;

  public Developer() {
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

  public List<Skill> getSkills() {
    return skills;
  }

  public void setSkills(Skill skill) {
    if (this.skills == null) {
      this.skills = new ArrayList<>();
    }
    this.skills.add(skill);
  }

  public Specialty getSpecialty() {
    return specialty;
  }

  public void setSpecialty(Specialty specialty) {
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


