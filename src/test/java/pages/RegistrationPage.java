package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    private final SelenideElement
            header = $(".text-center"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            stateWrapper = $("#stateCity-wrapper"),
            city = $("#city"),
            cityWrapper = $("#stateCity-wrapper"),
            submit = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    public void openPage() {
        open("/automation-practice-form");
        header.shouldHave(text("Practice Form"));
        executeJavaScript("document.getElementById('close-fixedban').parentNode.remove()");
        executeJavaScript("document.getElementsByTagName('footer')[0].remove()");
    }


    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmailInput(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGenderWrapper(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumberInput(String value) {
        userNumberInput.setValue(value);

        return this;
    }


    public RegistrationPage setDateOfBirth(String month, String year, String day) {
        calendarInput.click();
        calendarComponent.setDate(month, year, day);

        return this;
    }

    public RegistrationPage setSubjectInput(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbiesWrapper(String value) {
        hobbiesWrapper.find(byText(value)).click();

        return this;
    }

    public RegistrationPage setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        stateWrapper.find(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        cityWrapper.find(byText(value)).click();

        return this;
    }

    public RegistrationPage submit() {
        submit.click();

        return this;
    }


}
