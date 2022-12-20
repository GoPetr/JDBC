package model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Developer implements Serializable {
  private Long id;
  private String firstName;
  private String lastName;
  private List<Skill> skills;
  private String specialty;

  Status status = Status.ACTIVE;

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

  public void setSkills(List<Skill> skills) {
    this.skills = skills;
  }

  public String getSpecialty() {
    return specialty;
  }

  public void setSpecialty(String specialty) {
    this.specialty = specialty;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Developer developer = (Developer) o;
    return Objects.equals(id, developer.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Developer{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", skills=" + skills +
            ", specialty='" + specialty + '\'' +
            ", status=" + status +
            "\n" +
            '}';
  }
}


