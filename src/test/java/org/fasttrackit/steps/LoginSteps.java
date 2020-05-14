package org.fasttrackit.steps;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.LoginPage;
import org.fasttrackit.utils.Constants;
import org.junit.Assert;
import org.openqa.selenium.By;


public class LoginSteps {

    private HomePage homePage;
    private LoginPage loginPage;


    @Step
    public void navigateToLoginPage(){
        homePage.open();
        homePage.clickAccount();
    }

    @Step
    public void setCredentials(String email, String password){
        loginPage.setEmailField(email);
        loginPage.setPassField(password);
    }

    @Step
    public void clickLogin(){
        loginPage.clickLogin();
    }

    @Step
    public void clickLogout(){
        loginPage.clickLogout();
    }

    @Step
    public void loginErrorFromInvalidUser(String expected){
        String message = loginPage.loginErrorMessage();
        Assert.assertEquals(expected, message);
    }

    @Step
    public void checkLoggedIn(String expected){
        String message = loginPage.getWelcomeMessage();
        Assert.assertEquals(expected, message);
    }

    @Step
    public void login(String email, String pass){
        navigateToLoginPage();
        setCredentials(email, pass);
        clickLogin();
    }

    @Step
    public void verifyUserGetInAndOut(){
        navigateToLoginPage();
        setCredentials(Constants.emailTestare,Constants.passTestare);
        clickLogin();
        checkLoggedIn("Hello testadresa (not testadresa? Log out)\n" +
                "From your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details.");
        clickLogout();
        Assert.assertTrue(loginPage.find(By.cssSelector(".button[name^='log']")).isDisplayed());
    }

    @Step
    public void setRegisterCredentials(String email,String pass){
        loginPage.setRegisterEmailField(email);
        loginPage.setRegisterPassField(pass);
        loginPage.clickRegisterBtn();
    }

    @Step
    public void forgotYourPass(){
        String email= RandomStringUtils.randomAlphabetic(8);
        String domain = "@mailinator.com";
        navigateToLoginPage();
        setRegisterCredentials(email+domain,Constants.passTestare);
        loginPage.clickLogout();
        loginPage.clickLostYourPassLink();
        loginPage.setForgotPassEmailField(email+domain);
        loginPage.clickResetPassBtn();
        Assert.assertEquals(loginPage.resetedPassMessage(),"Password reset email has been sent.");
    }

}



