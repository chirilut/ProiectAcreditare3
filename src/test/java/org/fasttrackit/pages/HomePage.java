package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("http://qa3.fasttrackit.org:8008")
public class HomePage extends PageObject {


    @FindBy(css = "a[title^='Login']")
    private WebElementFacade registerLink;

    @FindBy(css = "#menu-item-1730 a")
    private WebElementFacade myAccountLink;

    @FindBy(css = "a[title^='Fast']")
    private WebElementFacade logo;

    @FindBy(css = ".search-btn")
    private WebElementFacade searchButton;

    @FindBy(css = ".search-field")
    private WebElementFacade searchField;

    @FindBy(css = ".search-submit")
    private WebElementFacade submitButton;

    @FindBy(css = ".fa-shopping-cart")
    private WebElementFacade cartButton;


    public void clickAccount(){
        clickOn(registerLink);
    }

    public void clickSearchBtn(){
        clickOn(searchButton);
    }

    public void setSearchField(String product){
        waitFor(searchField);
        typeInto(searchField,product);
    }
    public void clickSubmit(){
        clickOn(submitButton);
    }

    public void clickCartButton(){
        cartButton.click();
    }


}
