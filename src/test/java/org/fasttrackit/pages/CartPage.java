package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


@DefaultUrl("http://qa3.fasttrackit.org:8008/cart")
public class CartPage extends PageObject {

    @FindBy(css = ".cart-empty")
    public WebElementFacade cartEmptyMessage;

    @FindBy(css = ".remove")
    public WebElementFacade removeBtn;

    @FindBy(css = ".checkout-button")
    public WebElementFacade checkoutBtn;

    @FindBy(css = ".woocommerce-cart-form__cart-item")
    public List<WebElementFacade> list;

    @FindBy(css = ".fa-shopping-cart")
    public WebElementFacade cartBtn;



    public void confirmationEmptyCart(){
        Assert.assertEquals(cartEmptyMessage.getText(),"Your cart is currently empty.");
    }

    public void infirmationEmptyCart(){
        Assert.assertTrue(checkoutBtn.isDisplayed());
    }

    public void clickOnAllRemoveBtns1() {
        try {
            do {
                clickOn(removeBtn);
            }while (removeBtn.isDisplayed());
        }catch (StaleElementReferenceException e){
            e.printStackTrace();
        }
    }

    public void clickOnAllRemoveBtns2() {
        try {
            for (WebElementFacade product : list){
                if (product.findBy(By.cssSelector(".remove")).isDisplayed()){
                        removeBtn.click();
                    cartBtn.click();
                    waitABit(5000);
                }
            }
        }catch (StaleElementReferenceException e){
            e.printStackTrace();
        }
    }

    public void clickOnAllRemoveBtns3() { // nu sterge toate produsele din cos.
        int counter=0;
        try {
             for (WebElementFacade product : list){
                     if (product.containsElements(By.cssSelector(".remove"))){
                         System.out.println(counter);
                         removeBtn.click();
                         counter++;
                         System.out.println(counter);
                         Actions action = new Actions(getDriver());
                         WebElement element = getDriver().findElement(By.cssSelector(".remove"));
                         action.moveToElement(element).perform();
                        // removeBtn.click();
                         //cartBtn.click();
                     }
             }
        }catch (StaleElementReferenceException e){
            e.printStackTrace();
        }
    }





}
