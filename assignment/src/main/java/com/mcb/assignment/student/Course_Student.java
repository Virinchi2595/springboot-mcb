package com.mcb.assignment.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Course_Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course_Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer ID;

  private int student_id;
  private int course_id;
}
