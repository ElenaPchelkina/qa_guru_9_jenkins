package guru.qa;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class PracticeFormPageObjectsTests {
    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = "Male";
    String phone = faker.numerify("##########");
    String day = "12";
    String month = "April";
    String year = "1988";
    String subjects = "History";
    String hobbies = "Reading";
    String currentAddress = faker.address().fullAddress();
    String state = "NCR";
    String city = "Noida";

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest(){
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .selectGender(gender)
                .typePhone(phone)
                .setDateOfBirth(day, month, year)
                .typeSubjects(subjects)
                .selectHobbies(hobbies)
                .uploadPicture()
                .typeCurrentAddress(currentAddress)
                .selectState(state)
                .selectCity(city)
                .submitPage()

                .checkResultsValue(firstName)
                .checkResultsValue(lastName)
                .checkResultsValue(email)
                .checkResultsValue(gender)
                .checkResultsValue(phone)
                .checkResultsValue(day+ " " +month + "," + year)
                .checkResultsValue(subjects)
                .checkResultsValue(hobbies)
                .checkResultsValue("test.jpg")
                .checkResultsValue(currentAddress)
                .checkResultsValue(state)
                .checkResultsValue(city);
    }

}
