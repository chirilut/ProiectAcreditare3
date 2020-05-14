package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


@DefaultUrl("http://qa3.fasttrackit.org:8008/wp-admin/")
public class AdminPage extends PageObject {

    @FindBy(css = "a[href='http://qa3.fasttrackit.org:8008/wp-admin/post-new.php?post_type=product']")
    private WebElementFacade addNewProductBtn;

    @FindBy(css = "#title")
    private WebElementFacade prodNameField;

    @FindBy(css = "#_regular_price")
    private WebElementFacade prodPriceField;

    @FindBy(css = "#menu-posts-product .wp-menu-name")
    private WebElementFacade productsGeneralBtn;

    @FindBy(css = "a[href='post-new.php?post_type=product']")
    private WebElementFacade createNewProdBtn;

    @FindBy(css = "textarea#excerpt")
    private WebElementFacade prodDescriptionField;

    @FindBy(css = "#publish")
    private WebElementFacade prodPublishBtn;

    @FindBy(css = "#wp-admin-bar-site-name.menupop")
    private WebElementFacade swichUserToAdminWindow;

    @FindBy(css = ".menupop>a[href='http://qa3.fasttrackit.org:8008/'].ab-item")
    private WebElementFacade swichAdminToUserWindow;

    @FindBy(css =".editinline")
    private WebElementFacade quickEditBtn;

    @FindBy(css ="tr.author-self")
    private List<WebElementFacade> listOfProducts;

    @FindBy(css = ".inline-editor .inline-edit-legend")
    private WebElementFacade quickEditTitle;

    @FindBy(css = ".inline-editor .ptitle")
    private WebElementFacade titleField;

    @FindBy(css = ".inline-editor .regular_price")
    private WebElementFacade priceField;

    @FindBy(css = ".inline-editor .save")
    private WebElementFacade updateBtn;

    public void nameField(String name){
        typeInto(prodNameField,name);
    }

    public void createANewProductWay(){
        clickOn(swichUserToAdminWindow);
        clickOn(productsGeneralBtn);
        clickOn(createNewProdBtn);
    }

    public void setQuickEditTitleField(String newTitle){
        typeInto(titleField,newTitle);
    }

    public void setQuickEditPriceField(int newPrice){
        typeInto(priceField, String.valueOf(newPrice));
    }

    public void clickUpdateBtn(){
        clickOn(updateBtn);
    }

    public void clickProductGeneralBtn(){
        clickOn(productsGeneralBtn);
    }

    public void setProdPriceField(String price){
        typeInto(prodPriceField,price);
    }

    public void setProdDescriptionField(String description){
        typeInto(prodDescriptionField,description);
    }

    public void productPublish(){prodPublishBtn.click();}

    public void setSwichUserToAdminWindow(){
        clickOn(swichUserToAdminWindow);
    }

    public void setSwichAdminToUserWindow(){
            clickOn(swichAdminToUserWindow);
        }

    public void createNewProduct(String name){
        createANewProductWay();
        nameField(name);
        productPublish();
    }

    public void productQuickEdit(String produsName){
        clickProductGeneralBtn();
        int counter=0;
        for (WebElementFacade product : listOfProducts){
            if (product.findBy(By.cssSelector(".row-title")).getText().equals(produsName)&&counter<1) {
                Actions action = new Actions(getDriver());
                action.moveToElement(product).perform();
                product.find(By.cssSelector("a[aria-label='Quick edit “"+produsName+"” inline']")).click();
                counter++;
            }
        }
    }

    public boolean verifyQuickEditMenuPresent(){
        Assert.assertTrue(quickEditTitle.isDisplayed());
        return true;
    }

    public void modifyProductAttributesQuickEdit(String newTitle,int newPrice){
        setQuickEditTitleField(newTitle);
        setQuickEditPriceField(newPrice);
        clickUpdateBtn();
    }

    public void deleteProduct(String produsName){
        clickProductGeneralBtn();
        int counter=0;
        for (WebElementFacade product : listOfProducts){
            if ((counter<1)&&product.findBy(By.cssSelector(".row-title")).getText().equals(produsName)) {
                Actions action = new Actions(getDriver());
                action.moveToElement(product).perform();
                product.find(By.cssSelector("a[aria-label='Move “"+produsName+"” to the Trash']")).click();
                counter++;
            }
        }
    }








}
