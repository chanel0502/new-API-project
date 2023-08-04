package utilities;

import entities.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CashwiseAuthorization {


    public static String getToken() {
        RequestBody requestBody = new RequestBody();
        requestBody.setEmail(Config.readValue("username"));
        requestBody.setPassword(Config.readValue("password"));
        Response response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).
                post(Config.readValue("cashwiseApiUrl") + "/api/myaccount/auth/login");

        System.out.println(response.statusCode());
        String token = response.jsonPath().getString("jwt_token");
        System.out.println(token);
        return token;
    }

}
