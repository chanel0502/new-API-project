package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomResponse {

    private int category_id;
    private String created;
    private  int seller_id;
    private List<CustomResponse> responses;
    private  String email;
    private  String seller_name;
    private  int balance;
    private  String id;
    private String responseBody;
    @JsonProperty("company_name")
    private  String companyName;
    private String phone_number;
    private String  role;
    private CustomResponse business_area;
    private String ruTitle;
    private String enTitle;
    private Service service_type;
    private  CustomResponse category;






}
