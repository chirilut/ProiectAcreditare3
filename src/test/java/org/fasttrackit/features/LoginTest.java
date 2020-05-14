package org.fasttrackit.features;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;
public class LoginTest  extends BaseTest {


    @Steps
    private LoginSteps loginSteps;


    @Test    //test logare admin
    public void testValidLoginAdmin(){
        loginSteps.login(Constants.ADMIN_EMAIL,Constants.ADMIN_PASSWORD);
        loginSteps.checkLoggedIn("Hello admin (not admin? Log out)\n" +
                "From your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details.");
    }

    @Test    //test logare user
    public void testValidLoginUser(){
        loginSteps.login(Constants.emailTestare,Constants.passTestare);
        loginSteps.checkLoggedIn("Hello testadresa (not testadresa? Log out)\n" +
                "From your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details.");
    }

    @Test // test logare cu user invalid
    public void logInWithInvalidUsername(){
        loginSteps.login("email@yahoo.com","password");
        loginSteps.loginErrorFromInvalidUser("ERROR: Invalid email address. Lost your password?");
    }

    @Test // test logare cu user valid si parola gresita
    public void logInWithValidUsernameWrongPass(){
        loginSteps.login(Constants.emailTestare,"password");
        loginSteps.loginErrorFromInvalidUser("ERROR: The password you entered for the email address testadresa@yahoo.com is incorrect. Lost your password?");
    }

    @Test // test logare cu user valid fara parola
    public void logInWithValidUsernameEmptyPassField(){
        loginSteps.login(Constants.emailTestare,"");
        loginSteps.loginErrorFromInvalidUser("ERROR: The password field is empty.");
    }

    @Test    //test logare user2
    public void testValidLoginUser1(){
        loginSteps.login(Constants.emailTestare,Constants.passTestare);
        loginSteps.checkLoggedIn("Hello testadresa (not testadresa? Log out)\n" +
                "From your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details.");
    }

    @Test    //test logare si delogare user, cu verificarea delogarii
    public void userLogInAndOut(){
        loginSteps.verifyUserGetInAndOut();
    }


    @Test // register test cu user existent
    public void registerWithAnExistingEmail(){
        loginSteps.navigateToLoginPage();
        loginSteps.setRegisterCredentials(Constants.emailTestare,Constants.passTestare);
        loginSteps.loginErrorFromInvalidUser("Error: An account is already registered with your email address. Please log in.");
    }

    @Test // register cu email si parola generate de RandomString.Utils
    public void register(){
        String email= RandomStringUtils.randomAlphabetic(8);
        String domain = "@mailinator.com";
        loginSteps.navigateToLoginPage();
        loginSteps.setRegisterCredentials(email+domain,Constants.passTestare);
        loginSteps.checkLoggedIn("Hello "+email+" (not "+email+"? Log out)\n" +
                "From your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details.");
    }

    @Test  // test forgot your pass trimite un email cu parola resetata la adresa generata de RandomStringUtils
    public void forgotPass(){
        loginSteps.forgotYourPass();
    }




}
