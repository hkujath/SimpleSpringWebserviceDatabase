package de.hkujath.simplespringwebservicedatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "de.hkujath.simplespringwebservicedatabase")
public class MainApp {

   public static void main(String[] args) {
      SpringApplication.run(MainApp.class, args);
   }

}
