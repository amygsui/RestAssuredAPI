package testcases;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GETRequestPracticeTest {

    @Test
    public void get_request_practice_1() {

        // 1. Register a base URI where the request will be sent
        RestAssured.baseURI = "https://reqres.in";

        // 2. specify the request that will be sent
        RequestSpecification spec = RestAssured.given();
        Response response = spec.get("/api/users/2");

        // 3. Using the response object, extract each part of the response
        System.out.println("Status Line: " + response.statusLine());
        System.out.println("Status Code: " + response.statusCode());

        // Headers
        Headers headers = response.headers();
        String entireHeader = headers.toString();
        String contentType = headers.getValue("Content-Type");
        String server = headers.getValue("Server");
        String date = headers.getValue("Date");

        System.out.println("Content Type: " + contentType);
        System.out.println("Server: " + server);
        System.out.println("Date: " + date);

        // Body
        String responseBody = response.getBody().prettyPrint();
        System.out.println(responseBody);

        // Extract specific data from the payload
        String emailValue = JsonPath.read(responseBody, "$.data.email");
        String firstNameValue = JsonPath.read(responseBody, "$.data.first_name");
        String lastNameValue = JsonPath.read(responseBody, "$.data.last_name");
        String companyValue = JsonPath.read(responseBody, "$.ad.company");

        System.out.println("Email: " + emailValue);
        System.out.println("First Name: " + firstNameValue);
        System.out.println("Last Name: " + lastNameValue);
        System.out.println("Ad Company: " +  companyValue);


    }

}

/*
$.data.email
$.data.first_name
$.data.last_name
$.ad.company
 */