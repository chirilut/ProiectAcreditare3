package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.SearchSteps;
import org.fasttrackit.utils.BaseTest;
import org.fasttrackit.utils.Constants;
import org.junit.Test;

public class SearchTest extends BaseTest {

    @Steps
    private SearchSteps searchSteps;

    @Test //cauta produsul dat ca string
    public void searchProductSendKeys(){
        searchSteps.searchProdSendKey("bag");
    }

    @Test  // verifica daca se face search pe produse existente , inexistente sau fara nici un produs.
    public void checkProductFound(){
        searchSteps.verifyYourProductFound(Constants.SearchResultsfor_productMessage,"mihai");
    }



}
