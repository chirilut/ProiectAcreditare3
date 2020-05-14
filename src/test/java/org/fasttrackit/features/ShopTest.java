package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.ShopSteps;
import org.fasttrackit.utils.BaseTest;
import org.junit.Test;

public class ShopTest extends BaseTest {

    @Steps
    private ShopSteps shopSteps;


    @Test //verific daca face drop down pe pret.
    public void selectFilterByPrice(){
        shopSteps.dropDownSortByPrice("price");
    }

    @Test //verific daca face drop down
    public void selectFilterByPopularity(){
        shopSteps.dropDownSortByPopularity("popularity");
    }

    @Test // adauga in cos produsele de pe prima pagina
    public void addProductsToCart(){
        shopSteps.addProductsToCart();
    }

    @Test // adauga 2 produse in cos. tre sa verific ca sunt doar 2
    public void add2ProductsToCart(){
        shopSteps.add2ProductsToCart();
    }

    @Test //adauga recenzie
    public void addReviewToProduct(){
        shopSteps.addReview("AtmBWycW","2"); // stars: intre 1 si 5
    }

    @Test  // verifica daca produsele sunt aranjate dupa pret descendent
    public void verifyPriceDescending(){
        shopSteps.dropDownSortByPriceDescending();
    }


}
