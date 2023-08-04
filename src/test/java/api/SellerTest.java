package api;

import com.github.javafaker.App;
import com.github.javafaker.Faker;
import entities.CustomResponse;
import entities.RequestBody;
import org.apiguardian.api.API;
import org.junit.Assert;
import org.junit.Test;
import utilities.APIRunner;

import java.util.HashMap;
import java.util.Map;

public class SellerTest {
    @Test
    public void getSellers(){
        String path = "/api/myaccount/sellers/55";
        APIRunner.runGET(path);
        System.out.println(APIRunner.getCustomResponse().getSeller_name());
        System.out.println(APIRunner.getCustomResponse().getEmail());
    }

    @Test
    public void getSellersList(){
        String path = "/api/myaccount/sellers";
        Map<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("page", 1);
        params.put("size", 50);
        APIRunner.runGET(path, params);
        int counter = 0;
        for (CustomResponse cr: APIRunner.getCustomResponse().getResponses()){
            System.out.println(cr.getCompanyName());
            counter++;
        }
        System.out.println("total: " + counter);
    }


    @Test
    public void  createNewSeller(){
        String path = "/api/myaccount/sellers";
        RequestBody body = new RequestBody();
        body.setCompany_name("Facebook");
        body.setSeller_name("Mark");
        body.setEmail("mark@gmail.com");
        body.setPhone_number("7734550504");
        APIRunner.rubPOST(path,body);
        System.out.println(APIRunner.getCustomResponse().getResponseBody());
    }

    @Test
    public void singleSellerCreation(){
        String pathForPost = "/api/myaccount/sellers";
        Faker faker = new Faker();
        String companyName =faker.company().name();
        String sellerName =faker.name().fullName();
        String  email = faker.internet().emailAddress();
        String phone =faker.phoneNumber().phoneNumber();

        RequestBody body = new RequestBody();
        body.setCompany_name(companyName);
        body.setSeller_name(sellerName);
        body.setEmail(email);
        body.setPhone_number(phone);

        APIRunner.rubPOST(pathForPost,body);
        int id = APIRunner.getCustomResponse().getSeller_id();
        String urlForGet = "/api/myaccount/sellers/" + id;
        APIRunner.runGET(urlForGet);
        System.out.println(APIRunner.getCustomResponse().getResponseBody());

        Assert.assertEquals(sellerName,APIRunner.getCustomResponse().getSeller_name());
        Assert.assertEquals(companyName,APIRunner.getCustomResponse().getCompanyName());
        Assert.assertEquals(email,APIRunner.getCustomResponse().getEmail());
        Assert.assertEquals(phone,APIRunner.getCustomResponse().getPhone_number());

    }
}
