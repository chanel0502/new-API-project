package api;

import org.junit.Assert;
import org.junit.Test;
import utilities.APIRunner;

public class CashwiseProfileTests {

    @Test
    public void verifyProfileFields(){
        String path = "/api/myaccount/editors/get/profile";
        APIRunner.runGET(path);
        Assert.assertFalse(APIRunner.getCustomResponse().getBusiness_area().getRuTitle().isEmpty());
        Assert.assertNotNull(APIRunner.getCustomResponse().getBusiness_area().getRuTitle());

        Assert.assertFalse(APIRunner.getCustomResponse().getBusiness_area().getEnTitle().isEmpty());
        Assert.assertNotNull(APIRunner.getCustomResponse().getBusiness_area().getEnTitle());

        Assert.assertFalse(APIRunner.getCustomResponse().getRole().isEmpty());
        Assert.assertNotNull(APIRunner.getCustomResponse().getRole());


    }
}
