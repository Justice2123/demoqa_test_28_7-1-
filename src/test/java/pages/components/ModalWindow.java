package pages.components;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class ModalWindow {

    private final SelenideElement modalHeader = $("#example-modal-sizes-title-lg"),
            modalWindowTable = $(".table-responsive"),
            modalWindow = $(".modal-dialog");


    public final String
            modalHeaderText = "Thanks for submitting the form",
            modalStudentName = "Student Name",
            modalStudentEmail = "Student Email",
            modalGender = "Gender",
            modalMobile = "Mobile",
            modalBirthday = "Date of Birth",
            modalSubjects = "Subjects",
            modalHobbies = "Hobbies",
            modalPicture = "Picture",
            modalAddress = "Address",
            modalStateCity = "State and City";


    public ModalWindow checkModalHeader(String value) {
        modalHeader.shouldHave(exactText(value));

        return this;
    }

    public ModalWindow checkResultTable(String key, String value) {
        modalWindowTable.$(byText(key)).sibling(0).shouldHave(text(value));

        return this;
    }

    public ModalWindow modalWindowNotExist() {
        modalWindow.shouldNotBe(exist);

        return this;
    }

}

