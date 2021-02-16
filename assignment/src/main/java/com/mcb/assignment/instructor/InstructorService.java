package com.mcb.assignment.instructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InstructorService {

  @Autowired private InstructorRepo instructorRepo;

  Iterable<Instructor> getAllInstructors() {

    return instructorRepo.findAll();
  }

  Instructor getInstructorById(Integer id) {
    return instructorRepo
        .findById(id)
        .orElseThrow(
            () ->
                new InstructorException(
                    InstructorExceptionEnum.INSTRUCTOR_NOTFOUND_EXCEPTION.message,
                    InstructorExceptionEnum.INSTRUCTOR_NOTFOUND_EXCEPTION.code));
  }

  Instructor createInstructor(Instructor instructor) {
    Instructor savedInstructor = instructorRepo.save(instructor);
    log.info("created instructor with id :{}", savedInstructor.getID());
    return savedInstructor;
  }

  Instructor updateInstructor(Instructor instructor) {
    if (instructor.getID() == null) {
      throw new InstructorException(
          InstructorExceptionEnum.ID_REQUIRED_EXCEPTION.message,
          InstructorExceptionEnum.ID_REQUIRED_EXCEPTION.code);
    }
    instructorRepo
        .findById(instructor.getID())
        .orElseThrow(
            () -> {
              log.error("error while updating instructor with id :{}", instructor.getID());
              return new InstructorException(
                  InstructorExceptionEnum.INSTRUCTOR_NOTFOUND_EXCEPTION.message,
                  InstructorExceptionEnum.INSTRUCTOR_NOTFOUND_EXCEPTION.code);
            });
    Instructor updatedInstructor = instructorRepo.save(instructor);
    log.info("updated instructor with id :{}", updatedInstructor.getID());
    return updatedInstructor;
  }

  void deleteInstructor(int id) {
    instructorRepo.deleteById(id);
    log.info("deleted instructor with id :{}", id);
  }
}
