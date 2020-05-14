package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.fasttrackit.utils.Constants;


@DefaultUrl("http://qa3.fasttrackit.org:8008/my-account")
public class LoginPage extends PageObject {

    @FindBy(id = "username")
    private WebElementFacade emailField;

    @FindBy(id = "reg_email")
    private WebElementFacade registerEmailField;

    @FindBy(id = "user_login")
    private WebElementFacade forgotPassEmailContactField;

    @FindBy(id = "password")
    private WebElementFacade passField;

    @FindBy(id = "reg_password")
    private WebElementFacade registerPassField;

    @FindBy(css = ".button[name^='log']")
    private WebElementFacade loginButton;

    @FindBy(css = ".button[name^='reg']")
    private WebElementFacade registerButton;

    @FindBy(css = "button[value='Reset password']")
    private WebElementFacade forgotResetPassButton;

    @FindBy(css = "a[href='http://qa3.fasttrackit.org:8008/my-account/lost-password/']")
    private WebElementFacade lostYourPassLink;

    @FindBy(css = "li[class*='customer-logout']")
    private WebElementFacade logoutButton;

    @FindBy(css = ".woocommerce-MyAccount-content")
    private WebElementFacade welcomeMessageParagraph;

    @FindBy(css = ".woocommerce-error li")
    private WebElementFacade loginErrorMessageParagrapf;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade resetedPassMessage;



    public void setEmailField(String email){
        waitFor(emailField);
        typeInto(emailField, email);
    }

    public void setPassField(String pass){
        waitFor(passField);
        typeInto(passField, pass);
    }

    public void setRegisterEmailField(String email){
        waitFor(registerEmailField);
        typeInto(registerEmailField, email);
    }

    public void setRegisterPassField(String pass){
        waitFor(registerPassField);
        typeInto(registerPassField, pass);
    }

    public void setForgotPassEmailField(String email){
        waitFor(forgotPassEmailContactField);
        typeInto(forgotPassEmailContactField, email);
    }

    public void clickLogin(){
        clickOn(loginButton);
    }

    public void clickRegisterBtn(){
        clickOn(registerButton);
    }

    public void clickLostYourPassLink(){
        clickOn(lostYourPassLink);
    }

    public void clickResetPassBtn(){
        clickOn(forgotResetPassButton);
    }

    public String getWelcomeMessage(){
        return welcomeMessageParagraph.getText();
    }

    public String resetedPassMessage(){
        return resetedPassMessage.getText();
    }

    public String loginErrorMessage(){
        return loginErrorMessageParagrapf.getText();
    }

    public void clickLogout(){
        clickOn(logoutButton);
    }

    public void loginAsAdmin(){
        setEmailField(Constants.ADMIN_EMAIL);
        setPassField(Constants.ADMIN_PASSWORD);
        clickLogin();
    }


}
