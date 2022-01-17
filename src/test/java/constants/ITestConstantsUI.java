package constants;

import util.PropertyReader;

public interface ITestConstantsUI {

    String ERROR_MESSAGE_LOGIN = "Email/Login or password is incorrect. Please try again.";
    String LOGIN_BOX_TEXT = "Log into Your Account";
    String INVALID_EMAIL = "hello";
    String INVALID_PASSWORD = "world";
    String EMAIL_UI = System.getProperty("email", PropertyReader.getProperty("email"));
    String PASSWORD_UI = System.getProperty("password", PropertyReader.getProperty("password"));
}
