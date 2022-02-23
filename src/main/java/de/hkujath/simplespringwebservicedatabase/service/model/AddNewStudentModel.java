package de.hkujath.simplespringwebservicedatabase.service.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddNewStudentModel {

   @NotBlank
   String firstName;

   @NotBlank
   String lastName;

   @Email
   String email;

   AddNewAddressModel address;

}
