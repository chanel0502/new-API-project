package steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.TempStorage;

import java.util.HashMap;
import java.util.Map;

public class Blackjack_steps {
    @Given("user hits get new deck api with {string}")
    public void user_hits_get_new_deck_api_with(String newDeckUrl) {
        Response response = RestAssured.get(newDeckUrl);
        response.prettyPrint();
        String deckId = response.jsonPath().getString("deck_id");
        TempStorage.addValue("deckId",deckId);
        TempStorage.addValue("remaining",response.jsonPath().getString("remaining"));
        TempStorage.addValue("shuffled",response.jsonPath().getString("shuffled"));
    }
    @Then("user verifies total remaining to be {string} and not shuffled")
    public void user_verifies_total_remaining_to_be_and_not_shuffled(String remaining) {
        Assert.assertEquals(remaining,TempStorage.getValue("remaining"));
        Assert.assertEquals("false",TempStorage.getValue("shuffled"));


    }
    @Then("user hits shuffle api with same deck id")
    public void user_hits_shuffle_api_with_same_deck_id() {
        String shuffleUrl = "https://deckofcardsapi.com/api/deck/"+ TempStorage.getValue("deck_id")+ "/shuffle/";
        Response response = RestAssured.get(shuffleUrl);
        String shuffled = response.jsonPath().getString("shuffled");
        TempStorage.addValue("shuffledAfter",shuffled);
    }
    @Then("user verifies for shuffled value to be {string}")
    public void user_verifies_for_shuffled_value_to_be(String shuffled) {
        Assert.assertEquals(shuffled,TempStorage.getValue("shuffledAfter"));
    }

    @Then("user hits draw api two times with same deck id with count {string}")
    public void user_hits_draw_api_times_with_same_deck_id_with_count(String count) {



    }
    @Then("user verifies remaining cards to be {string}")
    public void user_verifies_remaining_cards_to_be(String remaining) {

    }

}
