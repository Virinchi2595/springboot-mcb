package com.mcb.assignment.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Course")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer ID;

  @NotNull
  @Length(
      max = 255,
      min = 3,
      message = "departmentName must be at least 3 and not more than 255 characters")
  @Column(name = "department_name")
  private String department_name;

  @Column(name = "instructor_id")
  private int instructor_id;

  @Column(name = "duration")
  @Max(value = 120, message = "duration cannot be more than 120")
  @Min(value = 30, message = "duration cannot be less than 30")
  private int duration;

  @NotNull
  @Length(
      max = 255,
      min = 3,
      message = "course name must be at least 3 and not more than 255 characters")
  @Column(name = "name")
  private String name;
}
