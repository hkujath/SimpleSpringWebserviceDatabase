package de.hkujath.simplespringwebservicedatabase.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetAddressModel {

   private String streetName;

   private String houseNumber;

   private String cityName;

   private String cityCode;

   private String countryName;
}
