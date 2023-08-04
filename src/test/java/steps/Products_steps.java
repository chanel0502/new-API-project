package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.APIRunner;

import java.util.HashMap;
import java.util.Map;

public class Products_steps {
    @Given("user hits get all products api with {string} params page {int} and size {int}")
    public void user_hits_get_all_products_api_with_params_page_and_size(String path, Integer page, Integer size) {
        Map<String ,Object> params = new HashMap<>();
        params.put("page",page);
        params.put("size",size);

        APIRunner.runGET(path,params);

    }
    @Then("user verifies all the products service type and categories")
    public void user_verifies_all_the_products_service_type_and_categories() {
        int size = APIRunner.getCustomResponse().getResponses().size();

        for(int i =0; i < size; i++){
            Assert.assertNotNull(APIRunner.getCustomResponse().getResponses().get(i).getService_type());
            Assert.assertNotNull(APIRunner.getCustomResponse().getResponses().get(i).getCategory());
        }
    }
    @Then("user verifies service types has value {string} or {string}")
    public void user_verifies_service_types_has_value_or(String service, String product) {
        int size = APIRunner.getCustomResponse().getResponses().size();

        for(int i = 0; i < size;i++) {
            int id = APIRunner.getCustomResponse().getResponses().get(i).getService_type().getService_type_id();
            if(id == 1){
                Assert.assertEquals(service,APIRunner.getCustomResponse().getResponses().get(i).getService_type().getService_type().trim());
            }if(id == 2){
                Assert.assertEquals(service,APIRunner.getCustomResponse().getResponses().get(i).getService_type().getService_type().trim());
            }
        }
    }

}
