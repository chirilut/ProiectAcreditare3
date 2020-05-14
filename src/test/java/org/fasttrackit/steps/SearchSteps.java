package org.fasttrackit.steps;
import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.SearchPage;
import org.fasttrackit.utils.Constants;
import org.junit.Assert;
import org.openqa.selenium.By;
public class SearchSteps {

    private HomePage homePage;
    private SearchPage searchPage;



    @Step
    public void verifyYourProductFound(String title , String product){
        String spatiu= " ";
        homePage.open();
        homePage.clickSearchBtn();
        homePage.setSearchField(product);
        homePage.clickSubmit();

        if ((searchPage.find(By.cssSelector(".page-title")).getText().equals(Constants.SearchResultsfor_productMesage))||(searchPage.find(By.cssSelector(".page-title")).getText().equals(null))){
            System.out.println("am introdus spatiu sau nimic");
                        Assert.assertEquals(searchPage.find(By.cssSelector(".page-title")).getText()+spatiu,title);

        }else if(searchPage.find(By.cssSelector(".page-title")).getText().equals(title+product)){
               System.out.println("aici este produsul dvoastra:   abc");
               Assert.assertEquals(title+product,searchPage.find(By.cssSelector(".page-title")).getText());
        }else{
            System.out.println("produsul nui in magazin.");
        }
    }

    @Step
    public void searchProdSendKey(String product){
        homePage.open();
        searchPage.typeElementIntoSearchFieldSendKeys(product);
    }





}