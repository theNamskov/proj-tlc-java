package com.project.student;

import java.util.*;

public class NaughtyStudent extends Student {
  

  public NaughtyStudent(List<Double> grades, String name, Level level) {
    super(grades, name, level);
  }

  @Override
  public double getAverageGrade() {
    List<Double> grades = getGrades();
    return (grades.stream().reduce(0.0, (sum, grade) -> sum + grade) / grades.size()) * 1.1;
  }
}