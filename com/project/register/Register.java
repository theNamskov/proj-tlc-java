package com.project.register;

import java.util.*;
// import java.util.stream.*;

import com.project.student.*;

public class Register {
  private List<Nameable> register;
  
  public Register(List<Nameable> students) {
    register = students;
  }

  public List<String> getRegister() {
    return register
      .stream()
      .map(student -> student.getName())
      .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
  }

  public List<String> getRegisterByLevel(Level level) {
    return register
    .stream()
      .filter(student -> student.getLevel() == level)
      .map(student -> student.getName())
      .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
  }

  public String printReport() {
    StringBuilder sb = new StringBuilder();

    Level[] levels = Level.values();

    for(Level item : levels) {
      sb.append("\n\n\t"+item);
      sb.append("\n================\n");
      
      List<String> filtered = register
        .stream()
        .filter(student -> student.getLevel() == item)
        .map(student -> student.getName()).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

      for(String name : filtered) {
        sb.append(name);
        sb.append("\n");
      }
    }

    return sb.toString();
  }
}