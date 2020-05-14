package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("http://qa3.fasttrackit.org:8008/?s=")
public class SearchPage extends PageObject {


    @FindBy(css = ".page-title")
    private WebElementFacade searchResultsMessage;

    @FindBy(css = ".page-title span")
    private WebElementFacade searchResultsFor;

    @FindBy(css = ".search-btn")
    private WebElementFacade searchBtn;

    @FindBy(css = ".search-block .search-field")
    private WebElementFacade searchField;

    @FindBy(css = ".search-block .search-submit")
    private WebElementFacade submitBtn;

    @FindBy(css = ".entry-title")
    private WebElementFacade firstProduct;

    public String searchResultsTitle(){
        return searchResultsMessage.getText();
    }

    public String afisazanumeleprodusului(){
        return firstProduct.getText();
    }

    public void typeElementIntoSearchField(String product){
         clickOn(searchBtn);
         typeInto(searchField, product);
         clickOn(submitBtn);
    }

    public void typeElementIntoSearchFieldSendKeys(String product){
        clickOn(searchBtn);
        searchField.sendKeys(product);
        clickOn(submitBtn);
    }



}
