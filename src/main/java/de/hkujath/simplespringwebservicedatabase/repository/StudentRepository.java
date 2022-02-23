package de.hkujath.simplespringwebservicedatabase.repository;

import de.hkujath.simplespringwebservicedatabase.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

   Student findStudentByFirstNameContains(String s);

   @Query("select x from Student x where x.firstName='Holger'")
   Student findStudentByFirstNameHolger();

}
