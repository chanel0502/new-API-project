package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CardGame {

    @Test
    public void BlackJack(){
        String newDeckUrl = "https://deckofcardsapi.com/api/deck/new/";
        Response response = RestAssured.get(newDeckUrl);
        response.prettyPrint();
        String deckId = response.jsonPath().getString("deck_id");

        boolean shuffled = response.jsonPath().getBoolean("shuffled");
        Assert.assertFalse(shuffled);

        //shuffled the cards
        String shuffleUrl = "https://deckofcardsapi.com/api/deck/"+ deckId+ "/shuffle/";
        Response response1 = RestAssured.get(shuffleUrl);
        shuffled = response1.jsonPath().getBoolean("shuffled");

        response1.prettyPrint();
        Assert.assertTrue(shuffled);

        //draw 3 cards to 2 different players

        String drawUrl = "https://deckofcardsapi.com/api/deck/" + deckId + "/draw/";
        Map<String,Object> params = new HashMap<>();
        params.put("count",3);

        response = RestAssured.given().params(params).get(drawUrl);
        response.prettyPrint();

        System.out.println("First player's cards");
        System.out.println(response.jsonPath().getString("cards[0].value"));
        System.out.println(response.jsonPath().getString("cards[1].value"));
        System.out.println(response.jsonPath().getString("cards[2].value"));

        response = RestAssured.given().params(params).get(drawUrl);
        System.out.println("Second player's cards");
        System.out.println(response.jsonPath().getString("cards[0].value"));
        System.out.println(response.jsonPath().getString("cards[1].value"));
        System.out.println(response.jsonPath().getString("cards[2].value"));

        //Verify that served cards are not in the remaining anymore
        int remaining = response.jsonPath().getInt("remaining");
        Assert.assertEquals(46,remaining);


    }
}
