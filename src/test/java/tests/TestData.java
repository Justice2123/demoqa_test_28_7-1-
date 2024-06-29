package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("en-GB"));
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();

    String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    String gender = getRandomGender();
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String invalidUserNumber = faker.internet().password(9, 10);

    String getRandomMonth() {
        String[] month = {"December", "January", "February", "March",
                "April", "May", "June", "July",
                "August", "September", "October", "November"};
        return faker.options().option(month);
    }

    String month = getRandomMonth();
    String calendarYear = String.format("%s", faker.number().numberBetween(1900, 2014));
    String calendarDay = String.format("%s", faker.random().nextInt(1, 28));

    String getRandomSubject() {
        String[] subject = {"English", "Maths", "Arts", "Hindi", "History"};
        return faker.options().option(subject);
    }

    String subject = getRandomSubject();

    String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    String hobbies = getRandomHobbies();
    String uploadFile = faker.options().option("2.png", "mountains.jpg");
    String address = faker.address().fullAddress();
    String getRandomState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    String userCity = getRandomCity(getRandomState);

    public String getRandomCity(String value) {
        if (getRandomState.equals("NCR")) userCity = faker.options().option("Delhi", "Gurgaon", "Noida");
        if (getRandomState.equals("Uttar Pradesh")) userCity = faker.options().option("Agra", "Lucknow", "Merrut");
        if (getRandomState.equals("Haryana")) userCity = faker.options().option("Karnal", "Panipat");
        if (getRandomState.equals("Rajasthan")) userCity = faker.options().option("Jaipur", "Jaiselmer");
        return userCity;
    }


}
