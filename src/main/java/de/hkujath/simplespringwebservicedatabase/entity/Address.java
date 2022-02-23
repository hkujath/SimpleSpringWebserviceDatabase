package de.hkujath.simplespringwebservicedatabase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ADDRESS")
public class Address {


   @Id
   @Column(name = "ID", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;


   @NotBlank(message = "Street name is missing.")
   @Column(name = "STREET_NAME")
   private String streetName;


   @NotBlank(message = "House number is missing.")
   @Column(name = "HOUSE_NUMBER")
   private String houseNumber;


   @NotBlank(message = "City name is missing.")
   @Column(name = "CITY_NAME")
   private String cityName;


   @NotBlank(message = "City code is missing.")
   @Column(name = "CITY_CODE")
   private String cityCode;


   @NotBlank(message = "Country name is missing.")
   @Column(name = "COUNTRY_NAME")
   private String countryName;

   // Back reference
//   @Getter
//   @Setter
//   @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
//   private Student student;

   /**
    * Constructor
    *
    * @param streetName
    * @param houseNumber
    * @param cityName
    * @param cityCode
    * @param countryName
    */
   public Address(String streetName, String houseNumber, String cityName, String cityCode, String countryName) {
      this.streetName = streetName;
      this.houseNumber = houseNumber;
      this.cityName = cityName;
      this.cityCode = cityCode;
      this.countryName = countryName;

   }
}
