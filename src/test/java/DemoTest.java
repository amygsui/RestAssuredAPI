import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class DemoTest {

    @Test
    public void practice_test() {

        String url = "https://reqres.in/api/users/2";
        Response response = RestAssured.given().get(url).andReturn();
        response.getBody().prettyPrint();

//        Request Types

//        RestAssured.get();
//        RestAssured.post();
//        RestAssured.put();
//        RestAssured.delete();


//        Getting response - 3 parts of a request

//        response.getStatusCode();
//
//        response.getContentType();
//        response.getHeader("Key");
//        response.getHeaders();
//
//        response.getBody();

    }

    @Test
    public void practice_test_2() {

        String url = "https://swapi.dev/api/people/1/";
        Response response = RestAssured.given().get(url).andReturn();
        String responseBodyPayload = response.getBody().asString();
        System.out.println("I got the following data back from the server.");
        System.out.println(responseBodyPayload);


    }

}

//  1. Prepare a request
//  2. Send the request
//  3. Convert the response json data into a String; body.asString()
//  4. Use JsonPath to extract the target data
//  5. Validate the extracted data with expected data