package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.AdminPage;
import org.fasttrackit.pages.BlogPage;
import org.fasttrackit.pages.LoginPage;
import org.fasttrackit.pages.ShopPage;
import org.fasttrackit.utils.Constants;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class BlogSteps {

    private LoginPage loginPage;
    private BlogPage blogPage;
    private ShopPage shopPage;
    private AdminPage adminPage;



    @Step
    public void navigateToBlogpage(){
        blogPage.open();
    }

    @Step
    public void aduTextDinREGISTERmeta(){
        navigateToBlogpage();
        System.out.println( blogPage.find(By.cssSelector("a[href='http://qa3.fasttrackit.org:8008/wp-login.php?action=register']")).getText());
    }


    @Step
    public void compareListMeta(){
        blogPage.open();
        blogPage.compareListMeta();
    }

    @Step
    public void compareListMeta2(List<String> metaList2){
        blogPage.open();
        blogPage.compareListMeta2(metaList2);
    }

    @Step // compara textul elementelor din: BLOG/META cu cele din SHOP/META
    public void compareBlogMetaElementsWithShopMetaElemants(){
        blogPage.open();
        blogPage.getTextFromMetaListElementsBlog();
        shopPage.open();
        shopPage.getTextFromMetaListElementsShop();
        Assert.assertEquals(shopPage.getTextFromMetaListElementsShop(),blogPage.getTextFromMetaListElementsBlog());
    }

    @Step  // lasa Commentariu cu o adresa de email valida
    // tre sa fac assert. innainte de assert fac o lista de webElemente in BLOG PAGES,
    // pe urma verific cu assert daca textul si numele se gasesc in lista din Pages.
    public void leaveCommentFromValidUser(){
        blogPage.open();
        blogPage.leaveAcommentFromValidUser();

    }

    @Step  // lasa comentariu de la email invalid
    public void leaveAcommentFromInvalidEmail(){
        blogPage.open();
        blogPage.leaveAcommentFromInvalidUser();
        Assert.assertEquals(blogPage.errorMessage(),"ERROR: please enter a valid email address.");
    }

    @Step  // lasa comentariu identic succesiv de la email valid
    public void leaveADuplicateComment(){
        blogPage.open();
        blogPage.leaveIdenticComment();
        Assert.assertEquals(blogPage.errorMessage(),"Duplicate comment detected; it looks as though you’ve already said that!");
    }

    @Step  // lasa comentariu identic succesiv de la email valid
    public void leaveQuiclyComment(){
        blogPage.open();
        blogPage.leaveQuiclyComment();
        Assert.assertEquals(blogPage.errorMessage(),"You are posting comments too quickly. Slow down.");
    }

    @Step  // lasa comentariu de la user valid si verifica daca s-a postat
    public void leaveCommFromValidUsserAndVerifyIfDisplayed(){
        blogPage.open();
        blogPage.commentIsDisplayed();
    }

    @Step // fac pasul de login si aici pt metoda de mai jos: leaveAcommentAfterLoggedin
    public void login(){
        loginPage.open();
        loginPage.setEmailField(Constants.emailTestare);
        loginPage.setPassField(Constants.passTestare);
        loginPage.clickLogin();
    }

    @Step //lasa comentariu dupa logare si verifica daca se afiseaza
    public void leaveCommAfterLoggedIn(){
        login();
        blogPage.open();
        blogPage.checkGievenCommAfterLoginIsDysplayed();
    }

    @Step // da replay la un comment
    public void replay(){
        blogPage.open();
        blogPage.replayToComment();
    }

    @Step //sterge comenturile de la testadresa
    public void deleteCommentsFromTestadresa2(){
        loginPage.open();
        loginPage.loginAsAdmin();
        adminPage.setSwichUserToAdminWindow();
        blogPage.clickCommentsAdminBtn();
        blogPage.deleteCommFromTestadresa2();
        blogPage.verifyCommWasDeleted();
    }









}
