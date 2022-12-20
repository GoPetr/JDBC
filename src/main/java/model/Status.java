package model;

import java.io.Serializable;

public enum Status implements Serializable {
  ACTIVE("ACTIVE"), DELETED("DELETED");

  private Status(String value) {
  }
}
