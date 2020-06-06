package com.nirbhayram.org.accessingdatamysql.entity.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "userid")
  private Integer id;

  @Column(length = 100)
  private String name;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
  private Date dateOfBirth;

  @Column(length = 15)
  private String mobile;

  @Column(length = 20)
  private String place;

  public User(String name, Date dateOfBirth, String mobile, String place) {
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.mobile = mobile;
    this.place = place;
  }

  public User() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }
}
