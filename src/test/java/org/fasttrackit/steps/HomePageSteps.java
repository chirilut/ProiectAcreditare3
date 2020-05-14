package org.fasttrackit.steps;
import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePageSteps {

    private HomePage homePage;

    @Step
    public void checkLogoIsDisplayed(){  //verifica daca Logoul este afisat in pagina
        homePage.open();
        Assert.assertEquals(homePage.getTitle(),"FastTrackIT");
    }

    @Step
    public boolean checkRegisterAndLoginBtnAreDisplayed(){ //verifica prezenta butoanelor MYACCOUNTsiREGISTER in pagina
        homePage.open();
        Boolean registerBtn= homePage.getDriver().findElement(By.cssSelector("#menu-item-1730 a")).isDisplayed();
        Boolean loginBtn= homePage.getDriver().findElement(By.cssSelector("a[title^='Login']")).isDisplayed();
        if(registerBtn&&loginBtn){
            System.out.println("Test passed");
            return true;
        }else{
            System.out.println("Test fallen");
        }return false;
    }



}
