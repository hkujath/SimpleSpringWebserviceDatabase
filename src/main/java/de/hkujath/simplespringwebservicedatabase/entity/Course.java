package de.hkujath.simplespringwebservicedatabase.entity;

import java.util.List;
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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "COURSE")
public class Course implements Comparable {

   @Id
   @Column(name = "ID", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotBlank(message = "Course title is missing.")
   @Column(name = "COURSE_TITLE")
   private String courseTitle;

   //@OneToMany(targetEntity = BookedCourses.class, mappedBy = "course", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
   //@ManyToMany(mappedBy = "bookedCourses")
   @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
   @JoinTable(name = "BOOKED_COURSES", joinColumns = @JoinColumn(name = "COURSE_ID"), inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
   private List<Student> participants;

   @Override
   public int compareTo(Object o) {
      if (o == null || o.getClass() != Course.class) {
         return 0;
      }

      var input = (Course) o;
      if (input.getId() > this.getId()) {
         return 1;
      } else if (input.getId() < this.getId()) {
         return -1;
      }
      return 0;
   }
}
