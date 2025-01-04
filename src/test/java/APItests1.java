import static io.restassured.RestAssured.*;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APItests1 {

    @Test
    void test1 () {
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println("Body is " + " " + response.getBody().asString());
        System.out.println("Status is " + response.getStatusCode());
        System.out.println("Response is " + response.asString());
        System.out.println("Time taken " + response.getTime());
        System.out.println("Header is " + response.getHeader("content-type"));

        Assert.assertEquals(response.getStatusCode(),200);
    }

    void test2(){

    }
}
