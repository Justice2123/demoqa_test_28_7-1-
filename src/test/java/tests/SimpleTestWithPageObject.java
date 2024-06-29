package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalWindow;
import utils.TestData;


public class SimpleTestWithPageObject extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ModalWindow modalWindow = new ModalWindow();
    TestData testData = new TestData();

    @Test
    void fillFormTests() {

        registrationPage.openPage();

        registrationPage
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmailInput(testData.email)
                .setGenderWrapper(testData.gender)
                .setUserNumberInput(testData.userNumber)
                .setDateOfBirth(testData.month, testData.calendarYear, testData.calendarDay)
                .setSubjectInput(testData.subject)
                .setHobbiesWrapper(testData.hobbies)
                .setUploadPicture(testData.uploadFile)
                .setCurrentAddress(testData.address)
                .setState(testData.getRandomState)
                .setCity(testData.userCity)
                .submit();


        modalWindow
                .checkModalHeader(modalWindow.modalHeaderText)
                .checkResultTable(modalWindow.modalStudentName, testData.firstName + " " + testData.lastName)
                .checkResultTable(modalWindow.modalStudentEmail, testData.email)
                .checkResultTable(modalWindow.modalGender, testData.gender)
                .checkResultTable(modalWindow.modalMobile, testData.userNumber)
                .checkResultTable(modalWindow.modalBirthday,
                        testData.calendarDay + " " + testData.month + "," + testData.calendarYear)
                .checkResultTable(modalWindow.modalSubjects, testData.subject)
                .checkResultTable(modalWindow.modalHobbies, testData.hobbies)
                .checkResultTable(modalWindow.modalPicture, testData.uploadFile)
                .checkResultTable(modalWindow.modalAddress, testData.address)
                .checkResultTable(modalWindow.modalStateCity, testData.getRandomState + " " + testData.userCity);

    }

    @Test
    void minFormTest() {
        registrationPage.openPage();

        registrationPage
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGenderWrapper(testData.gender)
                .setUserNumberInput(testData.userNumber)
                .submit();


        modalWindow
                .checkModalHeader(modalWindow.modalHeaderText)
                .checkResultTable(modalWindow.modalStudentName, testData.firstName + " " + testData.lastName)
                .checkResultTable(modalWindow.modalGender, testData.gender)
                .checkResultTable(modalWindow.modalMobile, testData.userNumber);

    }

    @Test
    void negativeFormTest() {
        registrationPage.openPage();

        registrationPage
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGenderWrapper(testData.gender)
                .setUserNumberInput(testData.invalidUserNumber)
                .submit();

        modalWindow.modalWindowNotExist();

    }


}