package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.fasttrackit.pages.AdminPage;
import org.fasttrackit.pages.LoginPage;
import org.fasttrackit.pages.SearchPage;
import org.junit.Assert;

public class AdminSteps {

    private LoginPage loginPage;
    private AdminPage adminPage;
    private SearchPage searchPage;

    String name= "Produsul meu "+ RandomStringUtils.randomAlphabetic(2);

    @Step
    public String getProduct(){
     return name;
    }

    @Step
    public void createNewProduct(String name){
        loginPage.open();
        loginPage.loginAsAdmin();
        adminPage.createNewProduct(name);
    }

    @Step
    public void verifyProductWasCreeated(){
        adminPage.setSwichAdminToUserWindow();
        searchPage.typeElementIntoSearchField(name);
        searchPage.searchResultsTitle();
        Assert.assertEquals(searchPage.afisazanumeleprodusului(),name);
    }

    @Step
    public void navigateToAdminDashboard(){
        loginPage.open();
        loginPage.loginAsAdmin();
        adminPage.setSwichUserToAdminWindow();
    }

    @Step
    public void editProduct(String product){
        navigateToAdminDashboard();
        adminPage.productQuickEdit(product);
    }

    @Step
    public void editProdVerify(){
        adminPage.verifyQuickEditMenuPresent();
    }

    @Step
    public void modifyTitleAndPriceQuickEdit(String newTitle, int newPrice){
        adminPage.modifyProductAttributesQuickEdit(newTitle,newPrice);
    }

    @Step
    public void deleteProduct(){
        createNewProduct(name);
        adminPage.deleteProduct(name);
    }

    @Step
    public boolean verifiProdWasDeleted(){
        adminPage.setSwichAdminToUserWindow();
        searchPage.typeElementIntoSearchField(name);
        Assert.assertFalse(name.equals(searchPage.searchResultsTitle()));
        return true;
    }

    @Step
    public void searchProduct(String product){
        adminPage.setSwichAdminToUserWindow();
        searchPage.typeElementIntoSearchFieldSendKeys(product);
        Assert.assertFalse(product.equals(searchPage.searchResultsTitle()));
    }






}
