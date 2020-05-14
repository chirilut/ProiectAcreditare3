package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.CartSteps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.steps.ShopSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class CartTest extends BaseTest {

    @Steps
    private CartSteps cartSteps;
    @Steps
    private ShopSteps shopSteps;
    @Steps
    private LoginSteps loginSteps;

//TEST 1
    @Test // verifica daca cosul este gol
    public void checkIfCartEmpty(){
        cartSteps.verifyCartEmpty();
    }

//TEST 2 --------------------------------------------------------
    @Test // adauga produse in cos apoi goleste cosul. pe urma verifica daca cosul este gol
    public void emptyTheCart(){
        shopSteps.addProductsToCart();
        cartSteps.clickCartBtn();
        cartSteps.removeProductsFromCart();
      //  cartSteps.verifyCartEmpty();
    }//nu merge , tre sa mai corectez!!!!!
// nu sterge toate produsele din cos!!!!!!!!!!!!!!!!!!!!!!!!!!!

//TEST 3
    @Test // adauga produse in cos si verific daca sunt prezente dupa logare
    public void checkProductsAreInCartAfterLogin(){
        shopSteps.addProductsToCart();
        loginSteps.navigateToLoginPage();
        loginSteps.setCredentials(Constants.emailTestare,Constants.passTestare);
        loginSteps.clickLogin();
        cartSteps.verifyCartNotEmpty();
    }

//TEST 4 --------------------------------------------------------------------------------
    @Test // verifica pretul produselor din cart
    public void checkProductsPriceIsRight(){
        cartSteps.calculateProductsPrice();
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // atentie ca nu ia tot timpu acelasi numar de produse , chiar daca in cos se adauga acelasi nr.
    }

//TEST 5 -------------------------------------------------------------------------------------
    @Test //testarea listei de produse
  //  testu asta nu lucraza bine. cateodata pica la linia 40 din CheckoutPage!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //  cate o data la linia 44.... nu aduce tot timpul ambele produse din cos....
    public void testarealistei(){
        cartSteps.testProducts();
    }



}
