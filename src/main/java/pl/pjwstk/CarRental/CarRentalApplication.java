package pl.pjwstk.CarRental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class CarRentalApplication {


    public CarRentalApplication(CarService carService) {

        User user = new User("1");
        RentalInfo rentalInfo = carService.rentACar(user, "ADWDOD", LocalDate.of(2022, 12, 1),
                LocalDate.of(2022, 12, 15));
        System.out.println(rentalInfo);

        carService.rentACar(user, "FNMWKD", LocalDate.of(2022, 12, 16),
                LocalDate.of(2022, 12, 15));

        carService.rentACar(user, "dffd", LocalDate.of(2022, 12, 7),
                LocalDate.of(2022, 12, 15));

        carService.rentACar(user, "FNMWKD", LocalDate.of(2022, 12, 7),
                LocalDate.of(2022, 12, 15));

    }


    public static void main(String[] args) {
        SpringApplication.run(CarRentalApplication.class, args);
    }


}
