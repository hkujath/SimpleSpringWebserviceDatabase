package de.hkujath.simplespringwebservicedatabase.service.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetStudentModel {

   @NotBlank
   private Long id;

   @NotBlank
   private String firstName;

   @NotBlank
   private String lastName;

   @Email
   private String email;

}
