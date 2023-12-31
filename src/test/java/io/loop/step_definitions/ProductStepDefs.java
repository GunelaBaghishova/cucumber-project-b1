package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.loop.pages.ProductPage;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ProductStepDefs {

    public static class ProductStepsDefs {
ProductPage productPage = new ProductPage();
        @Given("User is on the HomePage")
        public void user_is_on_the_home_page() {

            Driver.getDriver().get(ConfigurationReader.getProperty("product.url"));
        }
        @Then("User should be able to see expected prices in following products")
        public void user_should_be_able_to_see_expected_prices_in_following_products(List<Map<String,String>> productDetails) {
            for (Map<String,String>productDetail:productDetails ){
                System.out.println("=======PRODUCT DETAILS=========");
                System.out.println(productDetail.get("Category"));
                System.out.println(productDetail.get("Product"));
                System.out.println(productDetail.get("expectedPrice"));
                productPage.clickCategory(productDetail.get("Category"));
                String actualPrice = productPage.getProductPrice(productDetail.get("Product"));
                String expectedPrice = productDetail.get("expectedPrice");
                Assert.assertEquals(expectedPrice,actualPrice);
            }
        }
        @Then("User should be able to see expected prices in following products with listOflist")
        public void user_should_be_able_to_see_expected_prices_in_following_products_with_list_oflist(List<List<String>> productDetails) {
            for(List<String> productDetail:productDetails ){
                System.out.println("=======PRODUCT DETAILS=========");
                System.out.println(productDetail.get(0));
                System.out.println(productDetail.get(1));
                System.out.println(productDetail.get(2));

                productPage.clickCategory(productDetail.get(0));
                String actualPrice = productPage.getProductPrice(productDetail.get(1));
                String expectedPrice = productDetail.get(2);
                Assert.assertEquals(expectedPrice,actualPrice);
            }
        }

        @Then("User should be able to see following names in their groups")
        public void user_should_be_able_to_see_following_names_in_their_groups(Map<String, List<String>> student) {

            List<String> group1 = student.get("Group1");
            System.out.println("group1 = "+group1);

            List<String> group2 = student.get("Group2");
            System.out.println("group2 = "+group2);

            List<String> group3 = student.get("Group3");
            System.out.println("group3 = "+group3);



        }




    }
}
