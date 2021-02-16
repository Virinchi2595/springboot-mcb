package com.mcb.assignment.department;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
  @Autowired private DepartmentRepo departmentRepo;

  Iterable<Department> getAllDepartments() {

    return departmentRepo.findAll();
  }

  Department getDepartmentById(Integer id) {
    return departmentRepo
        .findById(id)
        .orElseThrow(
            () ->
                new DepartmentException(
                    DepartmentExceptionEnum.DEPARTMENT_NOTFOUND_EXCEPTION.message,
                    DepartmentExceptionEnum.DEPARTMENT_NOTFOUND_EXCEPTION.code));
  }

  Department createDepartment(Department Department) {
    Department savedDepartment = departmentRepo.save(Department);
    log.info("created Department with id :{}", savedDepartment.getID());
    return savedDepartment;
  }

  Department updateDepartment(Department Department) {
    if (Department.getID() == null) {
      throw new DepartmentException(
          DepartmentExceptionEnum.ID_REQUIRED_EXCEPTION.message,
          DepartmentExceptionEnum.ID_REQUIRED_EXCEPTION.code);
    }
    departmentRepo
        .findById(Department.getID())
        .orElseThrow(
            () ->
                new DepartmentException(
                    DepartmentExceptionEnum.DEPARTMENT_NOTFOUND_EXCEPTION.message,
                    DepartmentExceptionEnum.DEPARTMENT_NOTFOUND_EXCEPTION.code));
    Department updatedDepartment = departmentRepo.save(Department);
    log.info("updated Department with id :{}", updatedDepartment.getID());
    return updatedDepartment;
  }

  void deleteDepartment(int id) {
    departmentRepo.deleteById(id);
    log.info("deleted Department with id :{}", id);
  }
}
