package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.AdminSteps;
import org.fasttrackit.utils.BaseTest;
import org.junit.Test;

public class AdminTest extends BaseTest {

    @Steps
    private AdminSteps adminSteps;

//TEST 1
    @Test
    public void createANewProduct(){
        adminSteps.createNewProduct(adminSteps.getProduct());
        adminSteps.verifyProductWasCreeated();
    }

//TEST 2
    @Test
    public void changeTitleAndsPrice(){
      adminSteps.editProduct("Produsul meu BWw");
     adminSteps.modifyTitleAndPriceQuickEdit("aaa",50);
     adminSteps.searchProduct("Produsul meu BWw");
    }

//TEST 3
    @Test
    public void quickEditProduct(){
        adminSteps.editProduct("aaa");
        adminSteps.editProdVerify();
    }

//TEST 4
    @Test
    public void deleteProduct(){
        adminSteps.deleteProduct();
        adminSteps.verifiProdWasDeleted();
    }


}
