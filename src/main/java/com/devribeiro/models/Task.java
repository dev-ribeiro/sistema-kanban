package com.devribeiro.models;

import com.devribeiro.enums.Status;

public class Task {

  private Integer id;
  private String name;
  private Status status;

  public Task(Integer id, String name, Status status) {
    this.id = id;
    this.name = name;
    this.status = status;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Status getStatus() {
    return status;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStatus(Status status) {
    this.status = status;
  }



}
