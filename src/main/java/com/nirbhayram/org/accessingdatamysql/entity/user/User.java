package com.nirbhayram.org.accessingdatamysql.entity.user;


import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class User {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "userid")
  private Integer id;

  @Column(name = "lastname")
  private String lastName;

  @Column(name = "firstname")
  private String firstName;

  @Column(name = "email")
  private String email;



  public String getLastName() {
    return lastName;
  }

  public User(Integer id, String lastName, String firstName, String email) {
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
    this.email = email;
  }

  public User(String lastName, String firstName, String email) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.email = email;
  }

  public User() {
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
