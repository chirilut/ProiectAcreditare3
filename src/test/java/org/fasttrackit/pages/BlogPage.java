package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.commons.lang3.RandomStringUtils;
import org.fasttrackit.utils.Constants;
import org.junit.Assert;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@DefaultUrl("http://qa3.fasttrackit.org:8008/blog")
public class BlogPage extends PageObject {

    String randomComment= RandomStringUtils.randomAlphabetic(10);
    String randomName= RandomStringUtils.randomAlphabetic(5);
    String randomSecondaryName = RandomStringUtils.randomAlphabetic(3);
    String randomSecondaryComm = RandomStringUtils.randomAlphabetic(2);


    @FindBy(css = "#meta-2 li")
    private List<WebElementFacade> listaMeta;

    @FindBy(css = ".comment-form-comment #comment")
    private WebElementFacade commentField;

    @FindBy(id = "author")
    private WebElementFacade nameField;

    @FindBy(id = "email")
    private WebElementFacade emailField;

    @FindBy(id = "submit")
    private WebElementFacade submitBtn;

    @FindBy(id = "error-page strong")
    private WebElementFacade errorMessage;

    @FindBy(css = ".fn")
    private WebElementFacade receveCommFromName;

    @FindBy(css = ".comment-content p")
    private WebElementFacade recevedCommentContent;

    @FindBy(css = ".comments-area>ol>:last-child")
    private WebElementFacade lastComment;

    @FindBy(css = ".comment-list .children")
    private List<WebElementFacade> replayToCommList;

    @FindBy(css = "li[id^='comment-']")
    private List<WebElementFacade> listaDeComentarii;

    @FindBy(css = "ol[class='children']")
    private List<WebElementFacade> listaDeIncercare;

    @FindBy(css = ".comment-reply-link")
    private WebElementFacade replayBtn;

    @FindBy(css = ".row-actions .trash")
    private WebElementFacade trashBtn;

    @FindBy(id = "comment-search-input")
    private WebElementFacade searchForCommField;  //in case you are logged in as admin

    @FindBy(id = "search-submit")
    private WebElementFacade searchForCommBtn;   //in case you are logged in as admin

    @FindBy(id = "cb-select-all-1")
    private WebElementFacade authorFilter;

    @FindBy(id = "bulk-action-selector-top")
    private WebElementFacade selectorFilter;

    @FindBy(css = "#bulk-action-selector-top option[value='trash']")
    private WebElementFacade selectorTrashFilter;

    @FindBy(id = "doaction")
    private WebElementFacade applyBtn;

    @FindBy(css = "#the-comment-list .colspanchange")
    private WebElementFacade noProductMessage;

    @FindBy(css = "a[href*='wp-admin/post.php']")  //in case you are logged in as admin
    private WebElementFacade editPageBtnAdmin;

    @FindBy(css = "#menu-comments .wp-menu-name ")   //in case you are logged in as admin
    private WebElementFacade commentsAdminBtn;

    @FindBy(css = "#the-comment-list tr[id^='comment-']")
    private List<WebElementFacade> commentListAdmin;   //in case you are logged in as admin




    public List<String> getTextFromMetaListElementsBlog(){
        List<String> textNameListBlog= new ArrayList<>();
        for (WebElementFacade metaElement :listaMeta){
            String text= metaElement.findBy(By.cssSelector("a[href^='http']")).getText();
            textNameListBlog.add(text);
        }   //  System.out.println(textNameListBlog);
        return textNameListBlog;
    }

    public void compareListMeta(){  //compara elementele din Meta cu elementele date de documentatia tehnica
        List<String> metaList= new ArrayList<>();
        metaList.add("Register");
        metaList.add("Log in");
        metaList.add("Entries RSS");
        metaList.add("Comments RSS");
        metaList.add("WordPress.org");
        List<String> list2GetedTextFromWebList= new ArrayList<>();
        for (WebElementFacade metaElement :listaMeta){
            String text= metaElement.findBy(By.cssSelector("a[href^='http']")).getText();
            list2GetedTextFromWebList.add(text);
        }
         Assert.assertEquals(list2GetedTextFromWebList, metaList);
    }

        //compara elementele din Meta cu elementele date de documentatia tehnica,primite ca parametrii
    public void compareListMeta2(List<String> metaList2){
        List<String> list2GetedTextFromWebList= new ArrayList<>();
        for (WebElementFacade metaElement :listaMeta){
            String text= metaElement.findBy(By.cssSelector("a[href^='http']")).getText();
            list2GetedTextFromWebList.add(text);
        }
        Assert.assertEquals(list2GetedTextFromWebList, metaList2);
    }

    public void setCommentFieldRandom(){
        waitFor(commentField);
        typeInto(commentField,randomComment);
    }

    public void setCommentFieldRandom2(){
        waitFor(commentField);
        typeInto(commentField,randomSecondaryComm);
    }

    public void setNameFieldRandom(){
        waitFor(nameField);
        typeInto(nameField,randomName);
    }

    public void setNameFieldRandom2(){
        waitFor(nameField);
        nameField.clear();
        typeInto(nameField,randomSecondaryName);
    }

    public void setEmailFieldInvalid(){
        waitFor(emailField);
        typeInto(emailField,"invalid email"+"@yahoo.com");
    }

    public void setNameFieldConstant(){
        waitFor(nameField);
        typeInto(nameField,"this is a name");
    }

    public void searchForComments(String search){
        waitFor(searchForCommField);
        typeInto(searchForCommField,search);
        clickOn(searchForCommBtn);
    }

    public void setEmailFieldValid(){
        waitFor(emailField);
        typeInto(emailField,Constants.emailTestare);
    }

    public void setEmailFieldValidRandom(){
        waitFor(emailField);
        typeInto(emailField,randomName+"@yahoo.com");
    }

    public void leaveAcommentFromValidUser(){
        typeInto(commentField, "this is a comment");
        typeInto(nameField, "this is a name");
        typeInto(emailField, Constants.emailTestare);
        submitBtn.click();
    }

    public void leaveRandomCommentFromValidUser(){
        setCommentFieldRandom();
        typeInto(nameField, "this is a name");
        typeInto(emailField, Constants.emailTestare);
        submitBtn.click();
    }

    public void leaveRandomCommentFromRandomUser(){
        setCommentFieldRandom();
        typeInto(nameField, randomName);
        typeInto(emailField, Constants.emailTestare);
        submitBtn.click();
    }

    public void leaveAcommentFromInvalidUser(){
        setCommentFieldRandom();
        setNameFieldRandom();
        setEmailFieldInvalid();
        submitBtn.click();
    }

    public void leaveIdenticComment(){
        setCommentFieldRandom();
        setNameFieldRandom();
        setEmailFieldValid();
        submitBtn.click();
        setCommentFieldRandom();
        setNameFieldRandom();
        setEmailFieldValid();
        submitBtn.click();
    }

    public void leaveQuiclyComment(){
        setCommentFieldRandom();
        setNameFieldRandom();
        setEmailFieldValid();
        submitBtn.click();
        setCommentFieldRandom();
        setNameFieldConstant();
        setEmailFieldValid();
        waitABit(10000);
        submitBtn.click();
    }

    public String errorMessage(){
        String texteror=getDriver().findElement(By.cssSelector("#error-page p:nth-child(2)")).getText();
        return texteror;
    }

    public String noProductMessage(){
        String texteror=noProductMessage.getText();
        return texteror;
    }

    public String commentFromName(){
        String comment = receveCommFromName.getText();
        return comment;
    }

    public String commentContent(){
        String commentN = recevedCommentContent.getText();
        return commentN;
    }

    public void commentIsDisplayed(){
        setCommentFieldRandom();
        setNameFieldRandom();
        setEmailFieldValidRandom();
        submitBtn.click();
        if (receveCommFromName.isDisplayed()&&recevedCommentContent.isDisplayed()){
           Assert.assertEquals(randomName,commentFromName());
           Assert.assertEquals(randomComment,commentContent());
        }
    }

    public void leaveCommAfterLogin(){
        setCommentFieldRandom();
        submitBtn.click();
    }

    public void checkGievenCommAfterLoginIsDysplayed(){
        String name= Constants.emailTestare.replace("@yahoo.com","");
        leaveCommAfterLogin();
        if (lastComment.isPresent()) {
            Assert.assertEquals(lastComment.find(By.cssSelector(".fn")).getText(),name);
            Assert.assertEquals(lastComment.find(By.cssSelector(".comment-content")).getText(),randomComment);
        }
    }

    public void replayToComment(){ // lasa un comentariu, apoi lasa un replay
        // si verifica daca replayul este afisat
        leaveRandomCommentFromRandomUser();
        for (WebElementFacade comentariu :listaDeComentarii){
            if (comentariu.find(By.cssSelector(".fn")).getText().equals(randomName)){
                comentariu.find(By.cssSelector(".comment-reply-link")).click();
                setCommentFieldRandom2();// lasa Random2 replay
                setNameFieldRandom2();   // userul de la care dau reoplay
                waitABit(35000);
                submitBtn.click();
            }
        }
        try {
             for (WebElementFacade replayComm :replayToCommList){
                 String name= replayComm.findBy(By.cssSelector(".fn")).getText();
                 if (replayComm.find(By.cssSelector(".comment-list .children .comment-content")).getText().equals(randomSecondaryComm)){
                     System.out.println(randomSecondaryComm+"= randomsecondary comm");
                     System.out.println(replayComm.find(By.cssSelector(".comment-list .children .comment-content")).getText());
                     //Assert.assertEquals(randomSecondaryName,replayComm.find(By.cssSelector(".comment-list .children .fn")).getText());
                     Assert.assertEquals(randomSecondaryName,name);
                 }
             }
        }catch (NoSuchElementException e){
                e.printStackTrace();
        }
    }

    public void clickCommentsAdminBtn(){
        commentsAdminBtn.click();
    }

    public void sortByDropDown(){
        selectorFilter.selectByValue("trash");
    }

    public void deleteCommFromTestadresa2(){ // tre sa stearga toate commenturile de la TESTADRESA
        searchForComments(Constants.emailTestare);
        authorFilter.click();
        sortByDropDown();
        applyBtn.click();
    }

    public void verifyCommWasDeleted(){
        searchForComments(Constants.emailTestare);
        Assert.assertEquals(noProductMessage(),"No comments found.");
    }





}
