package de.hkujath.simplespringwebservicedatabase.service;

import de.hkujath.simplespringwebservicedatabase.service.model.AddNewStudentModel;
import de.hkujath.simplespringwebservicedatabase.service.model.GetAddressModel;
import de.hkujath.simplespringwebservicedatabase.service.model.GetCourseModel;
import de.hkujath.simplespringwebservicedatabase.service.model.GetStudentModel;
import java.util.List;
import java.util.Optional;

public interface StudentService {

   GetStudentModel addStudent(AddNewStudentModel student);

   boolean deleteStudent(Long studentID);

   List<GetStudentModel> getAllStudents();

   Optional<GetStudentModel> getStudentById(Long studentID);

   List<GetCourseModel> getBookedCoursesFromStudent(Long studentID);

   GetAddressModel getAddressFromStudent(Long id);
}
