package pl.pjwstk.CarRental;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class CarServiceTest {

    private CarStorage carstorage;
    private RentalStorage rentalstorage;

    private final CarStorage carStorage = new CarStorage();
    private final RentalStorage rentalStorage = new RentalStorage();
    private final CarService carService = new CarService(carStorage,  rentalStorage);

    @DisplayName("Cena samochód standard")
    @Test
    void PriceCarStandart(){
        //Given
        User user = new User("1");
        String vin = "ADWDOD";
        LocalDate startDate = LocalDate.of(2022, 12, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 5);
        //When
        RentalInfo rentalInfo = carService.rentACar(user, vin, startDate, endDate);
        //Then
        assertThat(rentalInfo.getPrice()).isEqualTo(200);
    }
    @DisplayName("Samochód nie istnieje")
    @Test
    void NotCar(){
        //Given
        User user = new User("1");
        String vin = "ABC";
        LocalDate startDate = LocalDate.of(2022, 12, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 5);
        //When
        carService.rentACar(user, vin, startDate, endDate);
        //Then
        assertThat(carService.rentACar(user, vin, startDate, endDate)).isEqualTo(null);
    }
    @DisplayName("Samochód Wynajęty")
    @Test
    void RentCar(){
        //Given
        User user = new User("1");
        String vin = "ADWDOD";
        LocalDate startDate = LocalDate.of(2022, 12, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 5);
        //When
        carService.rentACar(user, vin, startDate, endDate);
        //Then
        assertThat(carService.rentACar(user, vin, startDate, endDate)).isEqualTo(null);
    }
    @DisplayName("Data końcowa mniejsza od daty początkowej")
    @Test
    void StartAndDateRentCar(){
        //Given
        User user = new User("1");
        String vin = "ADWDOD";
        LocalDate startDate = LocalDate.of(2022, 12, 6);
        LocalDate endDate = LocalDate.of(2022, 12, 5);
        //When
        RentalInfo rentalInfo = carService.rentACar(user, vin, startDate, endDate);
        //Then
        assertThat(carService.rentACar(user, vin, startDate, endDate)).isEqualTo(null);
    }
    @DisplayName("Cena Samochód Premium")
    @Test
    void PriceCarPremium(){
        //Given
        User user = new User("1");
        String vin = "FNMWKD";
        LocalDate startDate = LocalDate.of(2022, 12, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 5);
        //When
        RentalInfo rentalInfo = carService.rentACar(user, vin, startDate, endDate);
        //Then
        assertThat(rentalInfo.getPrice()).isEqualTo(300);
    }
    @DisplayName("Vin jest nullem")
    @Test
    void CarVin(){
        //Given
        User user = new User("1");
        String vin = null;
        LocalDate startDate = LocalDate.of(2022, 12, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 5);
        //When
        RentalInfo rentalInfo = carService.rentACar(user, vin, startDate, endDate);
        //Then
        assertThat(carService.rentACar(user, vin, startDate, endDate)).isEqualTo(null);
    }

}