package constants;

import util.PropertyReader;

public interface ITestConstantsUI {

    String ERROR_MESSAGE_LOGIN = "Email/Login or Password is incorrect. Please try again.";
    String LOGIN_BOX_TEXT = "Log into Your Account";
    String INVALID_EMAIL = "hello";
    String INVALID_PASSWORD = "world";
    String EMAIL_UI = System.getProperty("email", PropertyReader.getProperty("email"));
    String PASSWORD_UI = System.getProperty("password", PropertyReader.getProperty("password"));
    String TEST_CASE_SUCCESS_MSG = "Successfully added the new test case. Add another";
    String TEST_CASE_ERROR_MSG = "Field Title is a required field.";
    String TEST_CASE_ADD_AND_NEXT_SUCCESS_MSG = "Successfully added the new test case. View test case";
}
