package com.mcb.assignment.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer ID;

  @NotNull
  @Length(
      max = 255,
      min = 3,
      message = "first name must be at least 3 and not more than 255 characters")
  @Column(name = "first_name")
  private String first_name;

  @NotNull
  @Length(
      max = 255,
      min = 3,
      message = "last name must be at least 3 and not more than 255 characters")
  @Column(name = "last_name")
  private String last_name;

  @NotNull
  @Length(max = 10, min = 10, message = "phone name must be at 10 characters")
  @Column(name = "phone")
  private String phone;
}
