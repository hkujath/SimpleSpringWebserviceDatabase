package de.hkujath.simplespringwebservicedatabase.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
public class Student {

   @Id
   @Column(name = "ID")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotBlank
   @Column(name = "FIRST_NAME")
   private String firstName;

   @NotBlank
   @Column(name = "LAST_NAME")
   private String lastName;

   @Email
   @Column(name = "EMAIL")
   private String email;

   @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
   @JoinColumn(name = "ADDRESS_ID")
   //@PrimaryKeyJoinColumn(name = "ADDRESS_ID")
   private Address address;

   //@OneToMany(targetEntity = BookedCourses.class, mappedBy = "student", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
   @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
   @JoinTable(name = "BOOKED_COURSES", joinColumns = @JoinColumn(name = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
   //@JoinColumn(name="STUDENT_ID")
   private Set<Course> bookedCourses;

   @ManyToOne
   @JoinColumn(name = "UNIVERSITY_ID")
   private University university;

   /**
    * Constructor
    *
    * @param firstName
    * @param lastName
    * @param email
    */
   public Student(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   /**
    * Constructor
    *
    * @param firstName
    * @param lastName
    * @param email
    * @param address
    */
   public Student(String firstName, String lastName, String email, Address address) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.address = address;
   }

   @Override
   public String toString() {
      return "Student{" + "id=" + this.id + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName + '\'' + ", email='" + this.email
          + '\'' + '}';
   }
}
