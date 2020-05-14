package org.fasttrackit.steps;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.ShopPage;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ShopSteps {

    private ShopPage shopPage;


    @Step
    public void dropDownSortByPrice(String text){
        shopPage.open();
        shopPage.sortByDropDown(text);
        Assert.assertEquals(shopPage.find(By.cssSelector("option[value='"+text+"']")).getText(),"SORT BY PRICE: LOW TO HIGH");
    }

    @Step
    public void dropDownSortByPopularity(String text){
        shopPage.open();
        shopPage.sortByDropDown(text);
        Assert.assertEquals(shopPage.find(By.cssSelector("option[value='"+text+"']")).getText(),"SORT BY POPULARITY");
    }

    @Step
    public void dropDownSortByPriceDescending(){
        shopPage.open();
        shopPage.sortByDropDown("price-desc");
        //Assert.assertEquals(shopPage.find(By.cssSelector("option[value='"+text+"']")).getText(),"SORT BY PRICE: HIGH TO LOW");
        Assert.assertTrue(shopPage.checkPriceDescending());
    }

    @Step
    public void addProductsToCart(){
       shopPage.open();
       shopPage.addProductsToCart();
    }

    @Step
    public void add2ProductsToCart(){
        shopPage.open();
        shopPage.add2ProductsToCart();
    }

    @Step
    public void addReview(String product,String stars){
        shopPage.open();
        shopPage.addReviewToProduct(product,stars);
        shopPage.verifyReviewPresent();
    }






}
