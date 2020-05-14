package org.fasttrackit.features;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.HomePageSteps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.utils.BaseTest;
import org.junit.Test;

public class HomePageTest extends BaseTest {

    @Steps
    private HomePageSteps homePageSteps;
    @Steps
    private LoginSteps loginSteps;


    @Test     // verificam prezenta in pagina a LOGO-ului.
    public void verifyLogoIsPresent(){
        homePageSteps.checkLogoIsDisplayed();
    }

    @Test      // verificam prezenta in pagina a butoanelor "MyAccount" si "REGISTER".
    public void verifyLoginAndRegisterBtnArePresent(){
        homePageSteps.checkRegisterAndLoginBtnAreDisplayed();
    }



}
