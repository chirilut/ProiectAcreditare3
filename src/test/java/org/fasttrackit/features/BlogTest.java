package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.BlogSteps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.utils.BaseTest;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class BlogTest extends BaseTest {

    @Steps
    private BlogSteps blogSteps;
    @Steps
    private LoginSteps loginSteps;

//TEST 1
    @Test // aduce textul din registru Meta
    public void textFromMetaRegister(){
        blogSteps.aduTextDinREGISTERmeta();
    }

//TEST 2
    @Test   // compara elementele din Meta cu o lista de elemente date in documentatie din BlogPage
    public void listaMeta(){
        blogSteps.compareListMeta();
    }

//TEST 3
    List <String> metaList2= new ArrayList<>();
    @Test   // compara elementele din Meta cu o lista de elemente date in documentatia tehnica
            // primeste elementele din documentatie ca parametrii
    public void listaMeta2(){
        metaList2= new ArrayList<>();
        metaList2.add("Register");
        metaList2.add("Log in");
        metaList2.add("Entries RSS");
        metaList2.add("Comments RSS");
        metaList2.add("WordPress.org");
        blogSteps.compareListMeta2(metaList2);
    }

//TEST 4
    @Test   // compara lista Meta din BLOG cu lista Meta din SHOP
    public void compareMetaFromBlogWithMetaFromSHOP(){
        blogSteps.compareBlogMetaElementsWithShopMetaElemants();
    }

//TEST 5
    @Test   // test care verifica daca se trimit Commenturile,
    // de pe email random valid , nume random si mesaj random
    public void leaveCommentFromValidEmail(){
        blogSteps.leaveCommFromValidUsserAndVerifyIfDisplayed();
    }

//TEST 6
    @Test  // lasa comentariu de pe email invalid
           //testul cade, in cazul in care primeste un email aparent real "sddivnh@yahoo.com"
    public void leaveCommentFromInvalidEmail(){
        blogSteps.leaveAcommentFromInvalidEmail();
    }

//TEST 7
    @Test  // test care verifica daca ma lasa sa trimit consecutiv,
    // 2 mesaje identice de la acelasi Nume cu aceeasi adresa de email
    public void leaveIdenticCommentFromSameName(){
        blogSteps.leaveADuplicateComment();
    }

//TEST 8
    @Test  // test care verifica daca ma lasa sa trimit consecutiv,
    // 2 mesaje identice de pe nume diferite dar acelasi email
    // !! setat pe 10 secunde, testul trece, dar la 60 de secunde , testul o sa cada.
    public void leaveQuiclyComments(){
        blogSteps.leaveQuiclyComment();
    }

//TEST 9
    @Test   // test cu: ma loghez si pe urma dau comment
    public void leaveCommentAfterLogIn(){
        blogSteps.leaveCommAfterLoggedIn();
    }

//TEST 10
    @Test //test care verifica daca pot da "Replay" la un comment
    public void replayToComment(){
        blogSteps.replay();
    }

//TEST 11 -----------------------------------------------------
    @Test //test care sterge comment din blog
    public void eraceComments2(){
        blogSteps.deleteCommentsFromTestadresa2();
    } //!!!!!!!!!!!!!!!!!!! merge doar daca exista commenturi anterioare de la testadresa@yahoo.com


}
