package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.ArrayList;
import java.util.List;


@DefaultUrl("http://qa3.fasttrackit.org:8008/checkout")
public class CheckoutPage extends PageObject {

    @FindBy(css = ".cart_item") //
    private List <WebElementFacade> checkoutProducts;



    public void checkoutReadyProducts(){
        List <String> allBrutPrices = new ArrayList<>();
        try {
           for (WebElementFacade product : checkoutProducts){
                   String price= (product.findBy(By.cssSelector(".cart_item .amount")).getText());
                   allBrutPrices.add(price);
               }
        }catch (StaleElementReferenceException e){
            e.printStackTrace();
        }System.out.println(allBrutPrices);
    }

    public void testamListaProduselorDinCos(){
        List <String> pricesAfterCut = new ArrayList<>();
        try {
            for (WebElementFacade produs : checkoutProducts){
                System.out.println(produs.findBy(By.cssSelector(".cart_item .amount")).getText());
                String pret=waitFor((WebElementFacade) produs.findBy(By.cssSelector(".cart_item .amount"))).getText().replace(",00 lei","");
                System.out.println(pret);
                pricesAfterCut.add(pret);
                System.out.println(pricesAfterCut);
            }
        }catch (StaleElementReferenceException er){
            er.printStackTrace();
        }
    }


}
