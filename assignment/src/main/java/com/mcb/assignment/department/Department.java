package com.mcb.assignment.department;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Department")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer ID;

  @Column(name = "location")
  @NotNull
  @Length(
      max = 255,
      min = 3,
      message = "department location must be at least 3 and not more than 255 characters")
  private String location;

  @Column(name = "name")
  @NotNull
  @Length(
      max = 255,
      min = 3,
      message = "department name must be at least 3 and not more than 255 characters")
  private String name;
}
