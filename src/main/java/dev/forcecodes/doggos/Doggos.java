package dev.forcecodes.doggos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;

@Getter
@Entity
@ToString
@Table(name = "doggos")
class Doggos {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String name;

  private String breed;

  public Doggos(String name, String breed) {
    this.name = name;
    this.breed = breed;
  }

  protected Doggos() {}
}
