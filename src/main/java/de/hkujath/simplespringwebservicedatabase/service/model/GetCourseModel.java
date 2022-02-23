package de.hkujath.simplespringwebservicedatabase.service.model;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetCourseModel {

   @NotBlank
   private Long id;

   @NotBlank
   private String courseName;


}
