package de.hkujath.simplespringwebservicedatabase.service;

import de.hkujath.simplespringwebservicedatabase.entity.Address;
import de.hkujath.simplespringwebservicedatabase.entity.Course;
import de.hkujath.simplespringwebservicedatabase.entity.Student;
import de.hkujath.simplespringwebservicedatabase.repository.StudentRepository;
import de.hkujath.simplespringwebservicedatabase.service.model.AddNewAddressModel;
import de.hkujath.simplespringwebservicedatabase.service.model.AddNewStudentModel;
import de.hkujath.simplespringwebservicedatabase.service.model.GetAddressModel;
import de.hkujath.simplespringwebservicedatabase.service.model.GetCourseModel;
import de.hkujath.simplespringwebservicedatabase.service.model.GetStudentModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("studentService")
public class StudentServiceImpl implements StudentService {

   private final StudentRepository repository;

   @Autowired
   public StudentServiceImpl(StudentRepository repo) {
      this.repository = repo;
   }

   /**
    * Add a student with the given model
    *
    * @param student
    * @return
    */
   @Override
   public GetStudentModel addStudent(AddNewStudentModel student) {
      var tmpStudent = convertToStudentEntity(student);
      var entity = this.repository.save(tmpStudent);
      return this.convertToGetStudentModel(entity);
   }

   /**
    * Delete a student with a given ID
    *
    * @param studentID
    * @return true, if the student could be deleted; false otherwise.
    */
   @Override
   public boolean deleteStudent(Long studentID) {
      if (this.repository.existsById(studentID)) {
         this.repository.deleteById(studentID);
         return true;
      }
      return false;
   }

   /**
    * @return all students inside the repository.
    */
   @Override
   public List<GetStudentModel> getAllStudents() {
      List<GetStudentModel> resultList = new ArrayList();
      var tmpStudentsInRepo = this.repository.findAll();
      tmpStudentsInRepo.forEach(x -> resultList.add(this.convertToGetStudentModel(x)));

      var studentHolger = this.repository.findStudentByFirstNameHolger();
      var studentFirstName = this.repository.findStudentByFirstNameContains("Klaus");

      return resultList;
   }

   /**
    * Return a specific student by a given ID.
    *
    * @param studentID
    * @return
    */
   @Override
   public Optional<GetStudentModel> getStudentById(Long studentID) {
      var foundStudent = this.repository.findById(studentID);
      return foundStudent.map(this::convertToGetStudentModel);
   }

   @Override
   public List<GetCourseModel> getBookedCoursesFromStudent(Long studentID) {
      if (!this.repository.existsById(studentID)) {
         return new ArrayList<>();
      }

      List<GetCourseModel> results = new ArrayList<>();
      var bookedCourses = new ArrayList<>(this.repository.findById(studentID).get().getBookedCourses());
      bookedCourses.sort(Comparator.reverseOrder());
      bookedCourses.forEach(x -> results.add(convertCourseToCourseModel(x)));

      return results;
   }

   @Override
   public GetAddressModel getAddressFromStudent(Long id) {
      if (!this.repository.existsById(id)) {
         return null;
      }

      var tmpAddress = this.repository.findById(id).get().getAddress();
      return convertAddressToAddressModel(tmpAddress);
   }

   //########### Helper methods #######################
   private AddNewStudentModel convertToAddNewStudentModel(Student inStudent) {
      if (inStudent == null) {
         return null;
      }
      var model = new AddNewStudentModel(inStudent.getFirstName(), inStudent.getLastName(), inStudent.getEmail(),
          convertToAddNewStudentAdressModel(inStudent.getAddress()));
      return model;
   }

   private GetStudentModel convertToGetStudentModel(Student inStudent) {
      if (inStudent == null) {
         return null;
      }
      var model = new GetStudentModel(inStudent.getId(), inStudent.getFirstName(), inStudent.getLastName(), inStudent.getEmail());
      return model;
   }

   private Student convertToStudentEntity(AddNewStudentModel student) {
      if (student == null) {
         return null;
      }
      var tmpStudent = new Student(student.getFirstName(), student.getLastName(), student.getEmail(), convertToAddressEntity(student.getAddress()));
      return tmpStudent;
   }

   private AddNewAddressModel convertToAddNewStudentAdressModel(Address address) {
      if (address == null) {
         return null;
      }
      return new AddNewAddressModel(address.getStreetName(), address.getHouseNumber(), address.getCityName(), address.getCityCode(),
          address.getCountryName());
   }

   private Address convertToAddressEntity(AddNewAddressModel model) {
      if (model == null) {
         return null;
      }
      return new Address(model.getStreetName(), model.getHouseNumber(), model.getCityName(), model.getCityCode(), model.getCountryName());
   }

   private GetCourseModel convertCourseToCourseModel(Course course) {
      if (course == null) {
         return null;
      }
      return new GetCourseModel(course.getId(), course.getCourseTitle());
   }

   /**
    * @param address
    * @return net {@link GetAddressModel} instance or null, if nothing was found.
    */
   private GetAddressModel convertAddressToAddressModel(Address address) {
      if (address == null) {
         return null;
      }
      return new GetAddressModel(address.getStreetName(), address.getHouseNumber(), address.getCityName(), address.getCityCode(),
          address.getCountryName());
   }
}
