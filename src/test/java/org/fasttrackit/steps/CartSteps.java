package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.CartPage;
import org.fasttrackit.pages.CheckoutPage;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.ShopPage;


public class CartSteps {

    private CartPage cartPage;
    private HomePage homePage;
    private ShopPage shopPage;
    private CheckoutPage checkoutPage;


    @Step
    public void clickCartBtn(){
        homePage.clickCartButton();
    }

    @Step
    public void verifyCartEmpty(){
        cartPage.open();
        cartPage.confirmationEmptyCart();
    }

    @Step
    public void verifyCartNotEmpty(){
        cartPage.open();
        cartPage.infirmationEmptyCart();
    }


    @Step // nu merge , tre corectat!!!!!!!!!!!!!!!!!1
    public void removeProductsFromCart(){
        //cartPage.open();
      //  cartPage.removeProductsFromCart();
        cartPage.clickOnAllRemoveBtns3();
    }

    @Step  // aduce pretu produselor din cos
    public void calculateProductsPrice(){
        shopPage.open();
        shopPage.add2ProductsToCart();
        shopPage.clickCheckout();
        checkoutPage.checkoutReadyProducts();
     //   cartPage.getProductsPrice();
    }

    @Step //testam produsele din cos
    public void testProducts(){
        shopPage.open();
        shopPage.add2ProductsToCart();
        shopPage.clickCheckout();
        checkoutPage.testamListaProduselorDinCos();
    } //!!!!!!!!!!!!!!!!!!!nu merge bine!!!!!!!!!!!!. nu returneaza tot timpul ambele produse din cos!!!

}
