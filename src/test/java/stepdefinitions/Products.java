package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.json.simple.JSONObject;

import static org.testng.AssertJUnit.assertEquals;

public class Products {
    public int statuscode;
    public RequestSpecification httpRequest;
    public Response response;
    public ResponseBody body;
    public JSONObject requestParams = new JSONObject();

    @Given("I hit the url of the api endpoint")
    public void i_hit_the_url_of_the_api_endpoint(){

        RestAssured.baseURI = "https://fakestoreapi.com";
        httpRequest = RestAssured.given();

    }

    @When("I pass the url of products in the request")
    public void i_pass_the_url_of_products_in_the_request() {

        response = httpRequest.get("/products");
    }

    @Then("I receive the response code as {int}")
    public void i_receive_the_response_code_as(int int1) {
        statuscode = response.getStatusCode();
        assertEquals(int1, statuscode);
    }

    @Then("I verify that the rate of the first product is {string}")
    public void i_verify_that_the_rate_of_the_first_product_is(String rate) {
        body = response.getBody();

        //convert response body to string
        String responsebody = body.asString();

        //JSON Representation from response body
        JsonPath jsnpath = response.jsonPath();

        String s = jsnpath.getJsonObject("rating[0].rate").toString();
        assertEquals(rate,s);
    }

    @And("I pass the request body of the product title {string}")
    public void iPassTheRequestBodyOfTheProductTitleProductTitle(String item) {
        requestParams.put("title",item);
        requestParams.put("price","15.5");
        requestParams.put("description","lorem ipsum set");
        requestParams.put("image","https://i.pravatar.cc");
        requestParams.put("category","Clothing");

    }

    @Then("I receive the response code as {int} and id as {string}")
    public void iReceiveTheResponseCodeAsAndIdAs(int arg0, String arg1) {
        // Checking 200 statuscode
        statuscode = response.getStatusCode();
        assertEquals(arg0, statuscode);

        //Verifying the id after post is 21
        body = response.getBody();
        System.out.println(body.asString());

        //JSON Representation from response body
        JsonPath jsnpath = response.jsonPath();
        String s = jsnpath.getJsonObject("id").toString();
        assertEquals(arg1,s);

    }

    @When("I pass the post url of products in the request")
    public void iPassThePostUrlOfProductsInTheRequest() {
        httpRequest.body(requestParams.toJSONString());
        response = httpRequest.post("/products");
    }

    @When("I pass the put url of products in the request {string}")
    public void iPassThePutUrlOfProductsInTheRequestEndpoint(String endpoint) {
        //httpRequest.body(requestParams.toJSONString());
        response = httpRequest.put("/products/"+endpoint);

    }

    @When("I pass the delete url of products in the request {string}")
    public void iPassTheDeleteUrlOfProductsInTheRequestEndpoint(String endpoint) {
        response = httpRequest.delete("/products/"+endpoint);
    }
}
