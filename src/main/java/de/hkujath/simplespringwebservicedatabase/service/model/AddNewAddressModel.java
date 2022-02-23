package de.hkujath.simplespringwebservicedatabase.service.model;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddNewAddressModel {

   @NotBlank(message = "Street name is missing.")
   private String streetName;

   @NotBlank(message = "House number is missing.")
   private String houseNumber;

   @NotBlank(message = "City name is missing.")
   private String cityName;

   @NotBlank(message = "City code is missing.")
   private String cityCode;

   @NotBlank(message = "Country name is missing.")
   private String countryName;
}
