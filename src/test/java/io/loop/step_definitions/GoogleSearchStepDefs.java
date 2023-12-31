package io.loop.step_definitions;

import io.cucumber.java.en.*;
import io.loop.pages.GoogleSearchPage;
import io.loop.utilities.ConfigurationReader;

import io.loop.utilities.*;
import org.junit.Assert;
import org.junit.Assume;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;


public class GoogleSearchStepDefs {
GoogleSearchPage googleSearchPage= new GoogleSearchPage();
    @Given("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
    }
    @When("user types Loop Academy in the google search box and clicks enter")
    public void user_types_loop_academy_in_the_google_search_box_and_clicks_enter() {
      googleSearchPage.searchBox.sendKeys("Loop Academy"+ Keys.ENTER);

    }
    @Then("user should see Loop Academy - Google Search in the google title")
    public void user_should_see_loop_academy_google_search_in_the_google_title() {
       String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Loop Academy - Google Search", actualTitle);
    }

    @When("user types {string} in the google search box and click enter")
    public void user_types_in_the_google_search_box_and_click_enter(String input) {
        googleSearchPage.searchBox.sendKeys(input+Keys.ENTER);
    }
    @Then("User should see {string} is in the google title")
    public void user_should_see_search_is_in_the_google_title(String title) {
        Assert.assertEquals("Expecter does not match ", title,Driver.getDriver().getTitle());

    }
    @Then("user searches the following item")
    public void user_searches_the_following_item(List<Map<String,String>> items)  {

        for (Map<String,String> item:items){
            System.out.println(item.get("items"));
            googleSearchPage.searchBox.clear();
            googleSearchPage.searchBox.sendKeys(item.get("items")+Keys.ENTER);

        }
//        items.forEach(p-> {
//            googleSearchPage.searchBox.sendKeys(p + Keys.ENTER);
//            Assert.assertEquals(p, Driver.getDriver().getTitle());
//
//    }

//        for (String s : items){
//            googleSearchPage.searchBox.clear();
//            googleSearchPage.searchBox.sendKeys(s + Keys.ENTER);
//            Assert.assertEquals(s + " - Google Search", Driver.getDriver().getTitle());
//        }
//

}

    @When("user searches for the {string}")
    public void user_searches_for_the(String country) {
googleSearchPage.searchBox.sendKeys("What is the capital of "+ country+Keys.ENTER);
    }
    @Then("user should see the {string} in the result")
    public void user_should_see_the_in_the_result(String capital) {
Assert.assertEquals(googleSearchPage.capital.getText(),capital);
    }

}
