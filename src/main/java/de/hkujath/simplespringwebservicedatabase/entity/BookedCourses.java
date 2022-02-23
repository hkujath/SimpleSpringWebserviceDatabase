package de.hkujath.simplespringwebservicedatabase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "BOOKED_COURSES")
@NoArgsConstructor
public class BookedCourses {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ID", nullable = false)
   private Integer id;

   @ManyToOne
   @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID", nullable = false)
   private Student student;

   @ManyToOne
   @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID", nullable = false)
   private Course course;

}